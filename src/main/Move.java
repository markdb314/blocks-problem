package main;

public class Move {
	int initialRow;
	int initialCol;
	int finalRow;
	int finalCol;
	int colShift;
	int rowShift;
	public Move(int ir, int ic, int rs, int cs){
		this.initialRow = ir;
		this.initialCol = ic;
		this.rowShift=rs;
		this.colShift=cs;
		this.finalRow = ir+rs;
		this.finalCol = ic+cs;
	}
	@Override
	public String toString(){
		return initialRow + " " + initialCol + " " + finalRow + " " + finalCol; 
	}
}
