package main;

import java.util.*;
public class Solver {
	public int subtreeCount = 0;
	HashSet<BoardConfiguration> boardsSeen = new HashSet<BoardConfiguration>();
	TreeNode foundGoal = null;
	
	public TreeNode buildSubtree(TreeNode root){
		if(boardsSeen.size()==0){
			boardsSeen.add(root.value);
		}
		subtreeCount++;
		boolean foundNewConfig = false;
	    ArrayList<BoardMove> possibleConfigs = root.value.getPossibleConfigs();
	    for(BoardMove b: possibleConfigs){ 
	    	if (boardsSeen.contains(b.bc)||foundGoal!=null) {
	            continue;
	        } 
	    	else{
	        	//System.out.println(b.bc.toDisplayString());
	        	boardsSeen.add(b.bc);
	        	foundNewConfig = true;
	        }
	    	TreeNode leaf = new TreeNode(b.bc, b.m, root);
	    	if(Goal.isGoal(b.bc)){
	    		root.addChild(leaf);
	    		foundGoal = leaf;
	    		System.out.println("Found Goal!!");
	    		System.out.println(b.bc.toDisplayString());
	    		printMovestoNode(foundGoal);
	    		return root;
	    	}
	    	else{
	        root.addChild(buildSubtree(leaf));
	        }
	    }
	    return root;
	}
	public void printMovestoNode(TreeNode n){
		TreeNode currentNode = n;
		Stack<Move> moveStack = new Stack<Move>();
		while(currentNode!=null && currentNode.edge!=null){
			moveStack.push(currentNode.edge);
			currentNode = currentNode.parent;
		}
		while(!moveStack.isEmpty()){
			Move m = moveStack.pop();
			System.out.println(m);
		}
	}
}


