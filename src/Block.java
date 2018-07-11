
public class Block implements Cloneable{
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
	public int hashCode(Block b){
		return Integer.hashCode(b.width) + Integer.hashCode(b.height);
	}
	public boolean equals(Block b1, Block b2){
		if(b1.width==b2.width && b1.height==b2.height){
			return true;
		}
		return false;
	}
	public void move(Move m){
		this.row+=m.rowShift;
		this.col+=m.colShift;
	}
	@Override 
	public Block clone(){
		return new Block(this.row, this.col, this.width, this.height);
	}
}
