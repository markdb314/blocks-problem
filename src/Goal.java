//import java.io.*;
//import java.util.*;

/*public class Goal {
	List<Block> goalBlock;
	List<Location> goalLocation;
	public boolean isGoal(BoardConfiguration b){
		//checks if b is goal configuration
		for(int i=0; i<goalBlock.size(); i++){
			if(b.board.containsKey(goalBlock.get(i)) && b.board.get(goalBlock.get(i)).equals(goalLocation.get(i))){
				continue;
			}
			else{
				return false;
				}
		}
		return true;
	}
	public static Goal finalConfig(FileReader file){
		Scanner scan2 = new Scanner(file);
		while(scan2.hasNextLine()){
		String finalconfig = scan2.nextLine();
		StringTokenizer st2 = new StringTokenizer(finalconfig);
		int flength = Integer.parseInt(st2.nextToken());
		int fwidth = Integer.parseInt(st2.nextToken());
		int frow = Integer.parseInt(st2.nextToken());
		int fcol = Integer.parseInt(st2.nextToken());
		Block b = new Block(flength, fwidth);
		Location l = new Location(frow, fcol);
    	List<Block> blocks = new LinkedList<Block>();
    	blocks.add(b);
    	List<Location> locs = new LinkedList<Location>();
    	locs.add(l);
    	
    	}
		
		return null;
	}
}*/
