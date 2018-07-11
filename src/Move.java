
public class Move {
	//Location l;
	int colShift;
	int rowShift;
	public Move(int rs, int cs){
		this.rowShift=rs;
		this.colShift=cs;
	}
	public boolean canApply(BoardConfiguration b){
		//return true if location isEmpty
		return true;
	}
	public BoardConfiguration apply(BoardConfiguration bc){
		//return new BC after move
		return bc;
	}
}
