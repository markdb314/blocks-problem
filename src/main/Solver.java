package main;

import java.util.*;
public class Solver {
	HashSet<BoardConfiguration> boardsSeen = new HashSet<BoardConfiguration>();
	TreeNode foundGoal = null;
	
	public TreeNode buildSubtree(TreeNode root){
	    ArrayList<BoardMove> possibleConfigs = root.value.getPossibleConfigs();
	    for(BoardMove b: possibleConfigs){ 
	    	if (boardsSeen.contains(b.bc)||foundGoal!=null) {
	            continue;
	        } 
	    	else{
	        	//System.out.println(b.toDisplayString());
	        	boardsSeen.add(b.bc);
	        }
	    	TreeNode leaf = new TreeNode(b.bc, b.m, root);
	    	if(Goal.isGoal(b.bc)){
	    		root.addChild(leaf);
	    		foundGoal = leaf;
	    		System.out.println("Found Goal!!");
	    		System.out.println(b.bc.toDisplayString());
	    		return root;
	    	}
	    	else{
	        root.addChild(buildSubtree(leaf));
	        }
	    }
	    return root;
	}
	public void printMovestoGoal(){
		TreeNode currentNode = foundGoal;
		while(currentNode!=null){
			System.out.println(currentNode.edge);
			currentNode = currentNode.parent;
		}
	}
}


