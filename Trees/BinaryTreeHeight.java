package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeHeight 
{
	// Iterative solutin f
	public static int height(NextNode node) 
	{
	    int height = 0;
	    if (node != null) 
	    {
	        // Breadth-first traversal, keeping track of the number of levels
	    	Queue<NextNode> thisLevel = new LinkedList<NextNode>();
	    	Queue<NextNode> nextLevel = new LinkedList<NextNode>();

	        thisLevel.add(node);
	        
	        while ((node = thisLevel.poll())!=null) 
	        {
	            if (node.left  != null) 
	            	nextLevel.add(node.left);
	            if (node.right != null) 
	            	nextLevel.add(node.right);

	            if (thisLevel.isEmpty()) 
	            {
	                height++;

	                Queue<NextNode> swapTemp = thisLevel;
	                thisLevel = nextLevel;
	                // We could create a new nextLevel queue, but reusing the
	                // newly emptied thisLevel queue is more efficient.
	                nextLevel = swapTemp;
	            }
	        }
	    }
	    return height;
	}
	
	
	
	// Recursive solution
	public static int heightOfTree(NextNode bt)
	{
		// if its null return 0
		if(bt==null)
			return 0;
		// else return 1 + the maximum of the recursive calls on the left subtree and
		// the right subtree
		// the plus 1 is for the root node
		else
			return 1 + Math.max(heightOfTree(bt.left), heightOfTree(bt.right));
	}
	
	public static void main(String[] args)
	{
		
		/*
		 * 		 a
		 * 	   /   \
		 * 	  b     c
		 *   / \     \
		 *  d   e     f
		 *           / \
		 *          g   h
		 * 
		 */
		NextNode a = new NextNode(1);
		NextNode b = new NextNode(2);
		NextNode c = new NextNode(3);
		NextNode d = new NextNode(4);
		NextNode e = new NextNode(5);
		NextNode f = new NextNode(8);
		NextNode g = new NextNode(6);
		NextNode h = new NextNode(7);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.right = f;
		f.left = g;
		f.right = h;
		
		System.out.println(heightOfTree(a));
		System.out.println(height(a));
	}

}
