package main;
import java.io.*;
import java.util.*;
public class Solver {
	/*public Tree buildSubtree(Tree root){
	    ArrayList<BoardConfiguration> possibleConfigs = root.board.getPossibleConfigs();
	    for(BoardConfiguration b: possibleConfigs){
	        if (seenBoardBefore) {
	            continue;
	        }
	        Tree leaf = new Tree(b);
	        root.addChild(buildSubtree(leaf));
	    }
	    return root;
	}*/

	public static void main(String[] args){
		if (args[0].equals("-ooption")){
			//print debugging options
		}
		 try {
				FileReader file = new FileReader(args[0]);
				BoardConfiguration bc = BoardConfiguration.intial(file);
				System.out.println(bc.toString());
				ArrayList<BoardConfiguration> possibleConfigs = bc.getPossibleConfigs();
				for(BoardConfiguration b: possibleConfigs)
				System.out.println(b.toString());
				
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		}
        
	}


