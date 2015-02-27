package Stacks;

import java.util.Stack;

public class SortUsingStacks 
{
	public static Stack<Integer> sort(Stack<Integer> stkInp)
	{
		Stack<Integer> out = new Stack<Integer>();
		
		while(!stkInp.isEmpty())
		{
			int temp = stkInp.pop();
			while(!out.isEmpty() && out.peek() > temp)
			{
				stkInp.push(out.pop());
			}
			out.push(temp);
		}
		return out;
	}
	
	public static void main(String[] args)
	{
		Stack<Integer> stkInp = new Stack<Integer>();
		Stack<Integer> stkOut;
		
		stkInp.push(20);
		stkInp.push(10);
		stkInp.push(40);
		stkInp.push(30);
		stkInp.push(50);
		stkInp.push(60);
		
		System.out.println(stkInp);
		stkOut = sort(stkInp);
		System.out.println(stkOut);
		
	}

}
