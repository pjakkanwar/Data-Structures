package Trees;

public class IsBinaryTreeBST 
{

	public static void main(String[] args)
	{

		/*
		 *		4-------> mt
		 * 	  2   6	
		 *   1 3 5 7
		 *   
		 *   *	8-------> mt
		 * 	  4   12	
		 *   2 6 10 14
		 * 
		 * */

		MyTree mt = new MyTree(8);
		mt.left = new MyTree(4);
		mt.right = new MyTree(12);
		mt.left.left = new MyTree(2);
		mt.left.right = new MyTree(6);
		mt.right.left = new MyTree(10);
		mt.right.right = new MyTree(14);

		System.out.println(IsBST(mt, Integer.MIN_VALUE, Integer.MAX_VALUE));
		MorrisTraversal(mt);

		//System.out.println(IsBST(mt));

	}

	public static void MorrisTraversal(MyTree root)
	{
		MyTree current,pre;

		if(root == null)
			return; 

		current = root;
		while(current != null)
		{                 
			if(current.left == null)
			{
				current = current.right;      
			}    
			else
			{
				/* Find the inorder predecessor of current */
				pre = current.left;
				while(pre.right != null && pre.right != current)
					pre = pre.right;

				/* Make current as right child of its inorder predecessor */
				if(pre.right == null)
				{
					pre.right = current;
					current = current.left;
				}

				/* Revert the changes made in if part to restore the original 
	        tree i.e., fix the right child of predecssor */   
				else 
				{
					pre.right = null;
					System.out.println(current.value);
					current = current.right;      
				} /* End of if condition pre->right == NULL */
			} /* End of if condition current->left == NULL*/
		} /* End of while */
	}

	// Recursive method - best solution
	public static boolean IsBST(MyTree tree,int small,int large)
	{
		if(tree==null)
			return true;
		if(tree.value>small && tree.value<large)
		{
			boolean leftChild = IsBST(tree.left, small, tree.value);
			boolean rightChild = IsBST(tree.right, tree.value, large);

			return (leftChild&&rightChild);
		}
		else
			return false;
	}

	// if no (int min max) allowed **************************

	// For each node, check if maximum value in left subtree is smaller than the node 
	// and minimum value in right subtree greater than the node.
	public static boolean IsBST(MyTree tree)
	{
		MyTree curr;
		MyTree curr1;
		int max = 0;
		int min = 0;

		curr = tree;
		curr1 = tree;

		while(curr!=null)
		{
			max = curr.value;
			curr = curr.right;

		}
		System.out.println("maxVal " + max);

		while(curr1!=null)
		{
			min = curr1.value;
			curr1 = curr1.left;

		}

		System.out.println("minVal " + min);

		if(tree==null)
			return true;
		if(tree.left!=null && tree.value < min)
			return false;
		if(tree.right!=null && tree.value >= max)
			return false;
		if(!IsBST(tree.left) || !IsBST(tree.right))
			return false;

		return true;
	}

}


class MyTree
{
	int value;
	MyTree left;
	MyTree right;

	public MyTree(int num) 
	{
		value = num;
		left=right=null;
	}
}
