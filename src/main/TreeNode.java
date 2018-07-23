import java.util.*;
public class TreeNode {
	BoardConfiguration value;
	ArrayList<TreeNode> children;
	public TreeNode(BoardConfiguration b){
		this.children = new ArrayList<TreeNode>();
		this.value = b;
	}
	public void addChild(TreeNode child){
		this.children.add(child);
	}
}
