package Stacks;

import java.util.*;


public class MinMaxStack 
{

	public int max;
	public int min;

	public Stack<Integer> stack;
	public Stack<Integer> minStack;
	public Stack<Integer> maxStack;

	MinMaxStack()
	{
		max=0;
		min=Integer.MAX_VALUE;

		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
		maxStack = new Stack<Integer>();
	}

	public void pushIn(int n)
	{
		stack.push(new Integer(n));

		if (n > max)
		{
			System.out.println("new max is "+n);
			max = n;
			maxStack.push(new Integer(n));   
		}
		if (n < min)
		{
			min = n;
			minStack.push(new Integer(n));
			System.out.println("new min is "+n);
		}
	}

	public void popOut()
	{
		Integer a = (Integer)stack.pop();

		if ( a.intValue() == max)
		{
			maxStack.pop();
			max = (Integer)maxStack.peek();
			System.out.println("new max is "+max);
		}

		if ( a.intValue() == min)
		{
			minStack.pop();
			min = (Integer)minStack.peek();
			System.out.println("new min is "+min);
		}
	}

	public void printStack()
	{
		System.out.println(minStack);
		System.out.println(maxStack);
		System.out.println(stack);
	}

	public int rangeStack()
	{

		return(max-min);
	}

	public void pushOnTheStack(int n)
	{
		stack.push(n);

		if(n > max)
		{
			max = n;
			maxStack.push(n);
		}

		if(n < min)
		{
			min = n;
			minStack.push(n);
		}
	}

	public void popOutOfTheStack()
	{
		int popped = stack.pop().intValue();

		if(popped ==max)
		{
			maxStack.pop();
			max = maxStack.peek();
		}
		if(popped==min)
		{
			minStack.pop();
			min = minStack.peek();
		}
	}

	public void printTheStack()
	{
		System.out.println("Stack is : " + stack);
		System.out.println("MinStack is : " + minStack);
		System.out.println("MaxStack is : " + maxStack);
	}

	public void getRange()
	{
		System.out.println(max-min);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) 
	{
		// TODO code application logic here
		MinMaxStack o = new MinMaxStack();
		o.pushOnTheStack(1);
		o.pushOnTheStack(4);
		o.pushOnTheStack(3);
		o.pushOnTheStack(5);
		o.pushOnTheStack(11);
		o.pushOnTheStack(7);
		o.pushOnTheStack(-9);

		o.printTheStack();
		
//		MyStack myStack = new MyStack(10);
//		myStack.push(10);
//		myStack.push(20);
//		myStack.push(40);
//		myStack.push(10);
//		myStack.push(20);
//		myStack.push(40);
//		//myStack.pop();
//		myStack.push(10);
//		myStack.push(20);
//		myStack.push(40);
//		myStack.push(100);
//		myStack.push(100);
//		myStack.printMyStack(myStack);
	}
}


class MyStack
{
	int[] array;
	int size;
	int top;

	public MyStack(int size) 
	{
		this.size = size;
		array = new int[size];
		top = -1;
	}

	public boolean isFull()
	{
		return (top==size-1);
	}

	public void push(int num)
	{
		if(isFull())
			System.out.println("Stack is full..cannot be pushed onto stack!!");

		else
		{
			array[++top] = num;
		}
	}

	public int pop()
	{
		if(top==-1)
		{
			System.out.println("Cannot be popped!!");
			return 0 ;}
		else
			return array[top--];
	}
	
	public int peek()
	{
		return array[top];
	}
	
	public void printMyStack(MyStack m)
	{
		System.out.print("[");
		for(int i=0;i<m.array.length;i++)
			System.out.print(m.array[i] + ",");
		System.out.println("]");
	}
	
	
}