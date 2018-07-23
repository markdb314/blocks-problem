package main;

import java.util.*;
public class Solver {
	HashSet<BoardConfiguration> boardsSeen = new HashSet<BoardConfiguration>();
	boolean foundGoal = false;
	
	public TreeNode buildSubtree(TreeNode root){
	    ArrayList<BoardConfiguration> possibleConfigs = root.value.getPossibleConfigs();
	    for(BoardConfiguration b: possibleConfigs){ 
	    	if (boardsSeen.contains(b)||foundGoal) {
	            continue;
	        } 
	    	else{
	        	//System.out.println(b.toDisplayString());
	        	boardsSeen.add(b);
	        }
	    	TreeNode leaf = new TreeNode(b);
	    	if(Goal.isGoal(b)){
	    		root.addChild(leaf);
	    		foundGoal = true;
	    		System.out.println("Found Goal!!");
	    		System.out.println(b.toDisplayString());
	    		return root;
	    	}
	    	else{
	        root.addChild(buildSubtree(leaf));
	        }
	    }
	    return root;
	}
}


