package main;

import java.io.*;
import java.util.*;
public class Goal {
	public static ArrayList<Block> GoalBlock;
	public static boolean isGoal(BoardConfiguration bc){
		for(Block b: GoalBlock){
			if (bc.board.contains(b)){
				continue;
			}
			else{
				return false;
			}
		}
		return true;
	}
	public static void finalConfig(FileReader file){
		Scanner scan2 = new Scanner(file);
		ArrayList<Block> goalBlock = new ArrayList<Block>();
		while(scan2.hasNextLine()){
			String finalconfig = scan2.nextLine();
			StringTokenizer st2 = new StringTokenizer(finalconfig);
			int flength = Integer.parseInt(st2.nextToken());
			int fwidth = Integer.parseInt(st2.nextToken());
			int frow = Integer.parseInt(st2.nextToken());
			int fcol = Integer.parseInt(st2.nextToken());
			Block b = new Block(frow, fcol, fwidth, flength);
			goalBlock.add(b);
    	}
		scan2.close();
		GoalBlock = goalBlock;
	}
}
