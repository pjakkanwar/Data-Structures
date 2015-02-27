package Trees;

public class FindSumInATree {

	public static void findSum(MyBinaryTree node,int sum)
	{
		int depth = depth(node);
		int[] path = new int[depth];
		
		findSum(node,sum,path,0);
	}
	
	public static void findSum(MyBinaryTree node,int sum,int[] path,int level)
	{
		if(node==null)
			return;
		
		// adding the node to the path
		
		path[level] = node.value;
		
		// checking of their is a sum in the path
		
		int t=0;
		for(int i=level;i>=0;i--)
		{
			t = t + path[i];
			if(t==sum)
				printSum(path,i,level);
		}
		
		// GO to next level
		
		findSum(node.left, sum, path, level+1);
		findSum(node.right, sum, path, level+1);
		
//		path[level] = Integer.MIN_VALUE;
	}
	
	public static void printSum(int[] path,int start,int end)
	{
		for(int i=start;i<=end;i++)
		{
			System.out.print(path[i]+ " ");
		}
		System.out.println();
	}
	public static int depth(MyBinaryTree root)
	{
		if(root==null)
			return 0;
		else
			return 1 + Math.max(depth(root.left), depth(root.right));
	}
	
	
	public static void main(String[] args) 
	{
		
		/*
		 * 		 a(1)
		 * 	    / \
		 *    b(2) c(3)
		 *   /    / \
		 *  d(4) e(5)f(8)
		 *           / \
		 *         g(6)h(7)   
		 * 
		 * 
		 * 
		 */
		MyBinaryTree a = new MyBinaryTree(1);
		MyBinaryTree b = new MyBinaryTree(2);
		MyBinaryTree c = new MyBinaryTree(3);
		MyBinaryTree d = new MyBinaryTree(4);
		MyBinaryTree e = new MyBinaryTree(5);
		MyBinaryTree f = new MyBinaryTree(8);
		MyBinaryTree g = new MyBinaryTree(6);
		MyBinaryTree h = new MyBinaryTree(7);
		a.left = b;
		a.right = c;
		b.left = d;
		c.left = e;
		c.right = f;
		f.left = g;
		f.right = h;

		findSum(a, 18);

	}
}
