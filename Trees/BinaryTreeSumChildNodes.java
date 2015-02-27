package Trees;


/*
 * In a binary tree change each node's value(except leaf node) as the sum of left and right subtree's value. 
 * 
 *  
   Constructed binary tree is:
           1
        /      \
       2        3
     /  \        \
    4   5        8
               /    \
              6       7


 After sum stored is in each node, binary tree is:
          35
        /    \
       9     21
     /  \       \
    4   5       13
               /   \
              6     7

 */
public class BinaryTreeSumChildNodes
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

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
		printNice(a);
		System.out.println();
		makeSum(a);
		printNice(a);
	}

	public static int makeSum(NextNode root)
	{
		// if its a root node return 0
		if (root == null)
			return 0;
		// else get the value
		// store the sum of left and right subtrees in a variable
		int temp = root.value;
		int sum = makeSum(root.left) + makeSum(root.right);
		// left!=null or right!= null the new value of that node is the sum that is obtained till now
		if (root.left != null || root.right != null)
			root.value = sum;
		// return the sum + the current nodes value
		return temp + sum;
	}

	public static void printNice(NextNode root)
	{
		if (root == null)
			return;
		else
		{
			System.out.print(root.value);
			if (root.left != null)
			{
				System.out.print(" L->[");
				printNice(root.left);
				System.out.print("]");
			}
			if (root.right != null)
			{
				System.out.print(" R->[");
				printNice(root.right);
				System.out.print("]");
			}
		}
	}
}