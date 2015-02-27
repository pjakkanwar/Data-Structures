package Trees;

import java.util.Stack;

public class TestExamples 
{

	// Complexity : O(n)
	public static MyBinaryTree createTree(int[] arr,int start,int end)
	{
		if(end < start)
			return null;

		int middle = (start + end)/2;
		// root is the middle element of the array
		MyBinaryTree root = new MyBinaryTree(arr[middle]);
		// recursively call the left half and the right half
		root.left = createTree(arr,start,middle-1);
		root.right = createTree(arr, middle+1, end);

		return root; 
	}

	public static MyBinaryTree createTree(int[] arr)
	{
		return createTree(arr,0,arr.length-1); 
	}

	public static double median(MyBinaryTree root ) 
	{

		int count = 0;
		int median = 0;
		// 7 is the size of array
		boolean even = 7 % 2 == 0 ? true : false;

		MyBinaryTree node = root;
		Stack<MyBinaryTree> stack = new Stack<MyBinaryTree>( );
		while( ! stack.isEmpty( ) || node != null ) 
		{
			if( node != null ) 
			{
				stack.push( node );
				node = node.left;
			}
			else 
			{
				node = stack.pop( );

				// 7 is the size of array
				if( even && count == ( 7 / 2 ) - 1 ) 
				{
					median = node.value;
				}
				// 7 is the size of array
				else if( count == 7 / 2 ) 
				{
					median += node.value;
					break;
				}

				count++;               
				node = node.right;
			}
		}

		return even ? median / 2.0 : median;
	}

	public static void main(String[] args) 
	{

		int[] arr = {1,2,3,4,5,6,7};
		MyBinaryTree bt = createTree(arr);
		System.out.println(bt.value);
		System.out.println(bt.left.value);
		System.out.println(bt.right.value);
		System.out.println(bt.left.left.value);
		System.out.println(bt.left.right.value);
		// TODO Auto-generated method stub
		System.out.println(median(bt));
		
		createTree(arr);

	}

}
