package Stacks;


// Each link in the list
class Link
{
	public int data;	// data on the linked list
	public Link next;	// next link

	// Constructor
	public Link(int d)
	{
		data = d;
	}

	// displaying the vale of the link
	public void displayLink()
	{
		System.out.println("linkdata : " + data);
	}
}



// Complete linked list
class LinkList
{
	private Link first;

	public LinkList()
	{
		first = null;
	}

	public boolean isEmpty()
	{
		return (first==null);
	}

	public void insertFirst(int data)
	{
		Link newLink =new Link(data);
		newLink.next = first;
		first = newLink;
	}

	public int deleteFirst()
	{
		Link temp = first;
		first = first.next;
		return temp.data;
	}

	public void displayList()
	{
		Link current = first;
		while(current != null)
		{
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}


// Stack methods using a linked list
class LinkStack
{
	private LinkList linklist;

	public LinkStack()
	{
		linklist = new LinkList();
	}

	public void push(int data)
	{
		linklist.insertFirst(data);
	}

	public int pop ()
	{
		return linklist.deleteFirst();
	}

	public boolean isempty()
	{
		return (linklist.isEmpty());
	}

	public void display()
	{
		System.out.println("top ---> bottom");
		linklist.displayList();
	}
}


public class StackImplementatedByLinkedList
{
	public static void main(String args[])
	{
		LinkStack list = new LinkStack();

		list.push(20);
		list.push(30);
	
		list.display();
	
		list.push(40);
		list.push(50);
	
		list.display();
	
		list.pop();
		list.pop();
	
		list.display();	
	}
}