package LinkedLists;

public class KthElementFromLast {
	static int i=0;
	static int j=1;
	static void kthFromLast(LinkedList head, int n)
	{
		if(head==null)
			return;
		kthFromLast(head.next, n);
		if(++i==n)
			System.out.println(head.value);
	}
	
	public static void main(String[] args)
	{
		LinkedList l = new LinkedList(1);
		l.next = new LinkedList(2);
		l.next.next = new LinkedList(3);
		l.next.next.next = new LinkedList(4);
		l.next.next.next.next = new LinkedList(5);
		l.next.next.next.next.next = new LinkedList(6);
		l.next.next.next.next.next.next = new LinkedList(7);
		l.next.next.next.next.next.next.next = new LinkedList(8);
		
		kthFromLast(l, 5);
	}

}
