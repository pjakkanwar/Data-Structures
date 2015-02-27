package Queues;

public class QueueUsingArrays 
{
	int[] array;
	int front;
	int rear;
	int size;
	int items;

	public QueueUsingArrays(int num) 
	{
		size = num;
		array = new int[size];
		front = 0;
		rear = -1;
		items = 0;
		// TODO Auto-generated constructor stub
	}

	public void enqueue(int value)
	{
		if(rear==size-1)
			rear = -1;
		if(isFull())
		{
			System.out.println("Queue Full!!!");
			System.out.println(value + " not added since queue is full");
		}
		else
		{
			rear++;
			array[rear] = value;
			items++;
			System.out.println(value + " added ");
		}
	}

	public int dequeue()
	{
		int val= Integer.MAX_VALUE;
		
		if(isEmpty())
			System.out.println("Queue Empty!!!");
		else
		{
			val = array[front];
			front++;
			if(front==size)
				front=0;
			items--;
		}

		return val;
	}

	public int peekFront()
	{
		return array[front];
	}

	public boolean isFull()
	{
		return (items==size);
	}

	public boolean isEmpty()
	{
		return (items==0);
	}


	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		QueueUsingArrays qa = new QueueUsingArrays(5);
		qa.enqueue(1);
		qa.enqueue(2);
		qa.enqueue(3);
		qa.enqueue(4);
		qa.enqueue(5);
		qa.enqueue(6);
		
		qa.dequeue();
		
		qa.enqueue(61);
		qa.enqueue(67);
		
	}

}
