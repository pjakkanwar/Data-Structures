package Trees;


public class CheckIfBalancedTree 
{
	
	public static boolean isBalanced(MyBinaryTree root)
	{
		return (maxDepth(root) - minDepth(root) <= 1);
	}
	
	
	public static int maxDepth(MyBinaryTree root)
	{
		if(root==null)
			return 0;
		else
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	public static int minDepth(MyBinaryTree root)
	{
		if(root==null)
			return 0;
		else
			return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}
	
	
	public static void main(String[] args)
	{
		MyBinaryTree a = new MyBinaryTree(10);
		MyBinaryTree b = new MyBinaryTree(20);
		MyBinaryTree c = new MyBinaryTree(30);
		MyBinaryTree d = new MyBinaryTree(40);
		MyBinaryTree e = new MyBinaryTree(50);
		MyBinaryTree f = new MyBinaryTree(60);
		MyBinaryTree g = new MyBinaryTree(70);
		
		a.left = b;
		b.left = c;
		b.right = d;
		a.right = e;
		e.right = f;
		e.left = g;
		
		System.out.println(isBalanced(a));
		
	}
}
