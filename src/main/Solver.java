import java.util.*;
public class Solver {
	HashSet<BoardConfiguration> boardsSeen = new HashSet<BoardConfiguration>();
	
	public TreeNode buildSubtree(TreeNode root){
	    ArrayList<BoardConfiguration> possibleConfigs = root.value.getPossibleConfigs();
	    for(BoardConfiguration b: possibleConfigs){
	    	if(Goal.isGoal(b)){
	    		System.out.println("Found Goal!!");
	    		System.out.println(b.toDisplayString());
	    		return null;
	    	}
	        if (boardsSeen.contains(b)) {
	            continue;
	        }
	        else{
	        	System.out.println(b.toDisplayString());
	        	boardsSeen.add(b);
	        }
	        TreeNode leaf = new TreeNode(b);
	        root.addChild(buildSubtree(leaf));
	    }
	    return root;
	}
}


