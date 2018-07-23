package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
public class Program {
	public static void main(String[] args){
		if (args[0].equals("-ooption")){
			//print debugging options
		}
		 try {
				FileReader file = new FileReader(args[0]);
				FileReader file2 = new FileReader(args[1]);
				BoardConfiguration bc = BoardConfiguration.intial(file);
				Goal.finalConfig(file2);
				System.out.println(bc.toDisplayString());
				TreeNode root = new TreeNode(bc, null, null);
				Solver solver = new Solver();
				solver.buildSubtree(root);
				
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		}
}
