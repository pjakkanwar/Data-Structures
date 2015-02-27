package LinkedLists;

public class ReverseLinkedList 
{

	public static void main(String[] args)
	{
		LinkedList l = new LinkedList(1);
		l.next = new LinkedList(2);
		l.next.next = new LinkedList(3);
		l.next.next.next = new LinkedList(4);
		l.next.next.next.next = new LinkedList(5);
		l.next.next.next.next.next = new LinkedList(6);

		System.out.println(Reverse(l).toString());
		//System.out.println(l.toString());
		//System.out.println(reverse(l).toString());
		//System.out.println(reverseLinkedList(l).toString());
	}

	// iteratively
	public static LinkedList reverseLinkedList(LinkedList head)
	{
		LinkedList prev=null;
		LinkedList next=null;
		LinkedList current=head;
		
		while(current!=null)
		{ 
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		return prev;
	}

	// recursively
	public static LinkedList reverse(LinkedList L)
	{
		// Check if it is null or the last node
		if(L==null || L.next==null)
			return L;

		// call the function recursively
		LinkedList list = reverse(L.next);
		L.next.next = L;
		L.next = null;

		return list;
	}
	
	public static LinkedList Reverse(LinkedList list)
	{
	    if (list == null) return null; // if list is null return null

	    if (list.next == null) return list; // if only one element ,return it

	    // we grab the second element (which will be the last after we reverse it)

	    LinkedList secondElem = list.next;

	    // 	to unlink list from the rest or you will get a cycle
	    list.next = null;

	    // then we reverse everything from the second element on
	    LinkedList reverseRest = Reverse(secondElem);

	    // then we join the two lists
	    secondElem.next = list;

	    return reverseRest;
	}
	
}

class LinkedList
{
	LinkedList next;
	int value;

	public LinkedList(int num) 
	{
		// TODO Auto-generated constructor stub
		value = num;
	}

	public String toString()
	{
		LinkedList curr = this;
		String pr = "";
		while(curr!=null)
		{
			pr += curr.value + " --> ";
			curr = curr.next;
		}
		return pr + "NULL";
	}



}
