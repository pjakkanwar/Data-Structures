package Stacks;

class StackX
{
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public StackX(int size)
	{
		maxSize=size;
		stackArray = new long[maxSize];
		top = -1;
	}
	
	public void push(long item)
	{
		if(isFull())
		{
			System.out.println("Stack full!!");
			System.out.println("last (" + item +")" + " - not added");
		}
		else
			stackArray[++top] = item;
	}

	public long pop()
	{
		return stackArray[top--];
	}
	
	public long peek()
	{
		return stackArray[top]; 
	}

	public boolean isFull()
	{
		return (top == maxSize-1);
	}

	public boolean isEmpty()
	{
		return (top==-1);
	}
}

class StackImplementation
{
	public static void main(String args[])
	{
		StackX st=new StackX(5);
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(40);
		st.push(40);
		
		System.out.println("Pop out order : ");
		while(!st.isEmpty())
		{
			long value=st.pop();
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println(" ");
	}
}