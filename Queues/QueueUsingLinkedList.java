package Queues;

class Link {
	public int iData;
	public Link next;
	public Link(int id) {
		iData = id;
	}

	public String toString() {
		return "{" + iData + "} ";
	}
}

class LinkList {
	private Link first;

	public LinkList() {
		first = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(int dd) {
		Link newLink = new Link(dd);
		newLink.next = first;
		first = newLink;
	}

	public int deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp.iData;
	}

	public String toString() {
		String str = "";
		Link current = first;
		while (current != null) {
			str += current.toString();
			current = current.next;
		}
		return str;
	}
}

class FirstLastList {
	private Link first;

	private Link last;

	public FirstLastList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(int dd) {
		Link newLink = new Link(dd);
		if (isEmpty())
			last = newLink;
		newLink.next = first;
		first = newLink;
	}

	public void insertLast(int dd) {
		Link newLink = new Link(dd);

		if (isEmpty())
			first = newLink;
		else
			last.next = newLink;
		last = newLink;
	}

	public int deleteFirst() {
		int temp = first.iData;
		if (first.next == null)
			last = null;
		first = first.next;
		return temp;
	}

	public String toString() {
		String str = "";
		Link current = first;
		while (current != null) {
			str += current.toString();
			current = current.next;
		}
		return str;
	}
}

class LinkQueue {
	private FirstLastList theList;

	public LinkQueue() {
		theList = new FirstLastList();
	}

	public boolean isEmpty() {
		return theList.isEmpty();
	}

	public void insert(int j) {
		theList.insertLast(j);
	}

	public double remove() {
		return theList.deleteFirst();
	}

	public String toString() {
		return theList.toString();
	}
} 

public class QueueUsingLinkedList 
{
	public static void main(String[] args) 
	{
		LinkQueue theQueue = new LinkQueue();
		System.out.println("Enqueue");
		theQueue.insert(20);
		theQueue.insert(40);
		System.out.println(theQueue);
		System.out.println("Enqueue");
		theQueue.insert(60);
		theQueue.insert(80);

		System.out.println(theQueue);

		System.out.println();
		System.out.println("Dequeue " + theQueue.remove());
		
		System.out.println("Dequeue " + theQueue.remove());

		System.out.println(theQueue);
	}
}