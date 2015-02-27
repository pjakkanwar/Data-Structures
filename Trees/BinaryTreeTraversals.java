package Trees;

import java.util.Stack;

public class BinaryTreeTraversals 
{

	public static void main(String[] args) 
	{
		MyBinaryTree mt = new MyBinaryTree(1);
		mt.left = new MyBinaryTree(2);
		mt.right = new MyBinaryTree(3);
		mt.left.left = new MyBinaryTree(4);
		mt.left.right = new MyBinaryTree(5);
		mt.right.left = new MyBinaryTree(6);
		mt.right.right = new MyBinaryTree(7);
		
		System.out.print("In order with recursion : ");
		mt.inOrderRecursion();
		System.out.println();
		
		System.out.print("In order without recursion : ");
		mt.inOrderWithoutRecursion();
		System.out.println();
		
		System.out.print("Pre order with recursion : ");
		mt.preOrderRecursion();
		System.out.println();
		
		System.out.print("Pre order without recursion : ");
		mt.preOrderWithoutRecursion();
		System.out.println();
		
		System.out.print("Post order with recursion : ");
		mt.postOrderWithRecursion();
		System.out.println();
		
		System.out.print("Post order without recursion : ");
		mt.postOrderWithoutRecurssion();

	}

}


class MyBinaryTree
{
	int value;
	MyBinaryTree left;
	MyBinaryTree right;
	
	public MyBinaryTree(int num) 
	{
		value = num;
	}
	
	// Inorder WITH recursion
	public void inOrderRecursion()
	{
		if(left!=null)
			left.inOrderRecursion();
		System.out.print(value+",");
		if(right!=null)
			right.inOrderRecursion();
	}
	
	// With out recursion
	// use a stack to maintain the current values
	public void inOrderWithoutRecursion()
	{
		Stack<MyBinaryTree> stack = new Stack<MyBinaryTree>();
		
		MyBinaryTree current = this;
		
		while(current!=null || !stack.isEmpty())
		{
			// while the end is not reached,
			// keep visiting the left nodes and pushing all values onto the stack
			if(current!=null)
			{
				stack.push(current);
				current = current.left;
			}
			// if current is null
			// pop the item from the stack and now this is the current value
			// Print the value
			// set the current to the right child
			else
			{
				current = stack.pop();
				System.out.print(current.value + ",");
				current = current.right;	
			}
		}
	}

	// PreOrder with recursion
	public void preOrderRecursion()
	{
		System.out.print(value+",");
		if(left!=null)
			left.preOrderRecursion();
		if(right!=null)
			right.preOrderRecursion();
	}

	// Preorder without recursion
	public void preOrderWithoutRecursion()
	{
		Stack<MyBinaryTree> stack = new Stack<MyBinaryTree>();
		MyBinaryTree current = this;
		
		while(current!=null || !stack.isEmpty())
		{
			// while the end of left subtree is not reached
			// print the values
			// push the right child onto stack
			// set the current node as the left child  
			if(current!=null)
			{
				System.out.print(current.value + ",");
				stack.push(current.right);
				current = current.left;
			}
			else
				current = stack.pop();
		}
		
	}
	
	// Post order with recursion
	public void postOrderWithRecursion()
	{
		if(left!=null)
			left.postOrderWithRecursion();
		if(right!=null)
			right.postOrderWithRecursion();
		if(this!=null)
			System.out.print(value+ " ");
	}
	
	// post order without recursion
	public void postOrderWithoutRecurssion()
	{
		Stack<MyBinaryTree> st = new Stack<MyBinaryTree>();
		MyBinaryTree previous = null;
		
		st.push(this); // root node onto the stack for processing
		
		while(!st.isEmpty())
		{
			MyBinaryTree current = st.peek();
			
			if(current==null)
				st.pop();
			
			//if leaf node then print it
			if(current.left==null && current.right==null)
			{
				System.out.print(current.value+ " ");
				st.pop();
			}
			// if the left node is null/current then the next node to be processed is the right node
			// so we will push it onto the stack
			else if(current.left==previous)
				st.push(current.right);
			
			// else if right is null
			else if(current.right==previous)
			{
				System.out.print(current.value+" ");
				st.pop();
			}
			//else push left child for processing
			else
				st.push(current.left);
			
			previous = current;
				
		}
	}


}
