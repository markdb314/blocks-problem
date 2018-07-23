package main;

import java.util.*;
public class TreeNode {
	Move edge;
	BoardConfiguration value;
	ArrayList<TreeNode> children;
	TreeNode parent;
	public TreeNode(BoardConfiguration b, Move e, TreeNode p){
		this.children = new ArrayList<TreeNode>();
		this.value = b;
		this.edge = e;
		this.parent = p;
	}
	public void addChild(TreeNode child){
		this.children.add(child);
	}
}
