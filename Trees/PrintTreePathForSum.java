package Trees;


public class PrintTreePathForSum 
{

	public static void printSums(NextNode n, int sum, int currentSum, String buffer) 
	{
		if (n == null)
		{
			return;
		}
		int newSum = currentSum + n.value;
		String newBuffer = buffer + " " + n.value;
		
		if (newSum == sum) 
		{
			System.out.println(newBuffer);
		}
		printSums(n.left, sum, newSum, newBuffer);
		printSums(n.right, sum, newSum, newBuffer);
		//printSums(n.left, sum, 0, "");
		//printSums(n.right, sum, 0, "");
	} 

	public static void main(String[] args) 
	{
		
		/*
		 * 		 a(1)
		 * 	    / \
		 *    b(2) c(3)
		 *   /    / \
		 *  d(4) e(5)f(6)
		 * 
		 * 
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
		c.left = e;
		c.right = f;
		f.left = g;
		f.right = h;

		printSums(a,9,0,"");

	}

}
