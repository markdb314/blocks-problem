package main;

public class Block implements Cloneable, Comparable<Block>{
	int row;
	int col;
	int width;
	int height;
	public Block(int r, int c, int w, int h){
		this.row = r;
		this.col = c;
		this.width = w;
		this.height = h;
	}
	@Override
	public int hashCode(){
		return Integer.hashCode(this.width) + Integer.hashCode(this.height);
	}
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Block)){
			return false;
		}
		Block b2 = (Block) o;
		if(this.width==b2.width && this.height==b2.height && this.row==b2.row && this.col==b2.col){
			return true;
		}
		return false;
	}
	public void move(Move m){
		this.row+=m.rowShift;
		this.col+=m.colShift;
	}
	@Override
	public String toString(){
		return this.row + " " + this.col + " " + this.width + " " + this.height;
	}
	@Override 
	public Block clone(){
		return new Block(this.row, this.col, this.width, this.height);
	}
	@Override
	public int compareTo(Block o) {
		String otherblock = o.toString();
		String thisblock = this.toString();
		return thisblock.compareTo(otherblock);
	}
}
