package main;

import java.io.*;
import java.util.*;

public class BoardConfiguration {
	int boardWidth;
	int boardHeight;
	ArrayList<Block> board;
	
	public BoardConfiguration(int bw, int bh, ArrayList<Block> b){
		this.boardWidth = bw;
		this.boardHeight = bh;
		this.board = b;
	}
	//if no block occupies the row/col return true
	public boolean isEmpty(int row, int col){
		boolean foundBlock = false;
		for (Block block : board) {
			if (col >= block.col && col < block.col + block.width
					&& row >= block.row && row < block.row + block.height) {
				foundBlock = true;
				break;
			}
		}
		return !foundBlock;
	}
		
	@Override
	public int hashCode(){
		Collections.sort(this.board);
		String hashString = this.board.toString();
		int hashCode = hashString.hashCode();
		System.out.println(hashCode);
		return hashCode;
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof BoardConfiguration)){
			return false;
		}
		BoardConfiguration b = (BoardConfiguration) o;
		Collections.sort(this.board);
		Collections.sort(b.board);
		String hashString = this.board.toString();
		String hashString2 = b.board.toString();
		if(hashString.equals(hashString2)){
			return true;
		}
		return false;
	}
		
	public static BoardConfiguration intial(FileReader file){
		//creates a board configuration from the file 
		Scanner scan = new Scanner(file);
        String line = scan.nextLine( );
        StringTokenizer st = new StringTokenizer(line);
        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        ArrayList<Block> board = new ArrayList<Block>();
        while(scan.hasNextLine()){
        	String initialconfig = scan.nextLine();
        	StringTokenizer str = new StringTokenizer(initialconfig);
        	int ilength = Integer.parseInt(str.nextToken());
        	int iwidth = Integer.parseInt(str.nextToken());
        	int irow = Integer.parseInt(str.nextToken());
        	int icol = Integer.parseInt(str.nextToken());
        	Block b = new Block(irow, icol, iwidth, ilength);
        	board.add(b);
        }
        scan.close();	
        return new BoardConfiguration(width, length, board);
	}
	public ArrayList<BoardConfiguration> getPossibleConfigs(){
		EmptySpaces es = new EmptySpaces(boardWidth, boardHeight, board);
		ArrayList<BoardConfiguration> possibleConfigs = new ArrayList<BoardConfiguration>();
		for(Block b: board){
			List<Move> moves = es.getPossibleMoves(b);
			for(Move move: moves){
				Block clone = b.clone();
				clone.move(move);
				ArrayList<Block> clonedlist = (ArrayList<Block>)board.clone();
				clonedlist.remove(b);
				clonedlist.add(clone);
				BoardConfiguration newbc = new BoardConfiguration(boardWidth, boardHeight, clonedlist);
				possibleConfigs.add(newbc);
				}
			}
		return possibleConfigs;
	}
	@Override
	public String toString(){
		String result = this.boardWidth + " " + this.boardHeight + "\n";
		for(Block b: this.board){
			result+=b.toString()+"\n";
		}
		return result;
	}
	public String toDisplayString(){
		String s = "";
		for(int i = 0; i<boardHeight; i++){
			for(int j=0; j<boardWidth; j++){
				if(isEmpty(i,j)){
					s += "_";
				}
				else{
					s+= "X";
				}
			}
			s += "\n";
		}
		return s;
	}
	public int[][] emptySpaces(){
		int[][] board = new int[boardWidth][boardHeight];
		for(int i = 0; i<boardHeight; i++){
			for(int j=0; j<boardWidth; j++){
				if(isEmpty(i,j)){
					board[i][j] = 0;
				}
				else{
					board[i][j]=1;
				}
			}
		}
		return board;
	}
}
