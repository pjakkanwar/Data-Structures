package Trees;

public class DigitFrequencyInTree 
{
	public static int[] digitFreq = new int[10];

	public static void treeFreq (BTNode tree) 
	{
		/* Base Case */
		if (tree == null) 
		{
			return;
		}

		/* Visit Node, check digit frequency */
		int number = tree.data;
		do 
		{
			digitFreq[number % 10]++;
			number /= 10;
		} 
		while(number != 0);

		treeFreq(tree.left);	/* Check left sub-tree */
		treeFreq(tree.right);	/* Check right sub-tree */
	}
	
	public static void main(String[] args)
	{
		BTNode bt = new BTNode();
		bt.left = new BTNode();
		bt.right = new BTNode();
		bt.data=7;
		bt.left.data = 20;
		bt.right.data = 10;
		
		treeFreq(bt);
		
		for(int i=0;i<digitFreq.length;i++)
		{
			System.out.println(i + " " +  digitFreq[i]);
		}
	}
}

class BTNode 
{
	int data;
	BTNode left;
	BTNode right;

	public BTNode() 
	{
		data = 0;
		left = null;
		right = null;
	}
}