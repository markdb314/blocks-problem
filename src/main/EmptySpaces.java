package main;

import java.util.*;
public class EmptySpaces {
	int[][] board;
	private static boolean isEmpty(int row, int col, List<Block> board){
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
	public EmptySpaces(int width, int height, List<Block> blocks){
		this.board = new int[height][width];
		for(int i = 0; i<height; i++){
			for(int j=0; j<width; j++){
				if(isEmpty(i,j, blocks)){
					this.board[i][j] = 0;
				}
				else{
					this.board[i][j]=1;
				}
			}
		}
	}
	private boolean canMoveUp(Block b){
		if(b.row==0){
			return false;
		}
		for(int i=b.col; i<b.col+b.width; i++){
			if(board[b.row-1][i]==1){
				return false;
			}
		}
		return true;
	}
	private boolean canMoveDown(Block b){
		int bottomrow = b.row + b.height -1;
		if(board.length==bottomrow+1){
			return false;
		}
		for(int i=b.col; i<b.col+b.width; i++){
			if(board[bottomrow+1][i]==1){
				return false;
			}
		}
		return true;
	}
	private boolean canMoveLeft(Block b){
		if(b.col==0){
			return false;
		}
		for(int i=b.row; i<b.row+b.height; i++){
			if(board[i][b.col-1]==1){
				return false;
			}
		}
		return true;
	}
	private boolean canMoveRight(Block b){
		int rightedge = b.col + b.width -1;
		if(board[0].length==rightedge+1){
			return false;
		}
		for(int i=b.row; i<b.row+b.height; i++){
			if(board[i][rightedge+1]==1){
				return false;
			}
		}
		return true;
	}
	public List<Move> getPossibleMoves(Block b){
		ArrayList<Move> possibleMoves = new ArrayList<Move>();
		if(canMoveUp(b)==true){
			possibleMoves.add(new Move(b.row, b.col, -1, 0));
		}
		if(canMoveDown(b)==true){
			possibleMoves.add(new Move(b.row, b.col, 1, 0));
		}
		if(canMoveLeft(b)==true){
			possibleMoves.add(new Move(b.row, b.col, 0, -1));
		}
		if(canMoveRight(b)==true){
			possibleMoves.add(new Move(b.row, b.col, 0, 1));
		}
		return possibleMoves;
	}
}
