package LinkedLists;

public class MergingLinkedList 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Node n1 = new Node(1);
		Node n3 = new Node(3);
		Node n5 = new Node(5);
		Node n7 = new Node(7);
		Node n9 = new Node(9);

		n1.next = n3;
		n3.next = n5;
		n5.next = n7;
		n7.next = n9;
		n9.next = null;

		Node n2 = new Node(2);
		Node n4 = new Node(4);
		Node n6 = new Node(6);
		Node n8 = new Node(8);
		Node n10 = new Node(10);

		n2.next = n4;
		n4.next = n6;
		n6.next = n8;
		n8.next = n10;
		n10.next = null;

		System.out.println("Merge : " + mergeLinkedList(n1, n2));
	}


	public static Node mergeLinkedList(Node n1, Node n2)
	{
		// if first list is null the resultant list is the second list itself
		if(n1==null)
			return n2;
		// if second list is null the resultant list is the first list 
		if(n2==null)
			return n1;
		// if the value of the element of first list is smaller than the second list
		// point the next element of the n1 to the resultant of the recursive call on
		// the next and n2
		if(n1.value < n2.value)
		{
			n1.next = mergeLinkedList(n1.next, n2);
			return n1;
		}
		// else merge n2.next with 
		else
		{
			n2.next = mergeLinkedList(n2.next, n1);
			return n2;
		}
	}
}


class Node
{
	Node next;
	int value;

	public Node(int num) {
		// TODO Auto-generated constructor stub
		value = num;
	}

	public String toString()
	{
		// allocating the current Node to curr Node
		Node curr=this;
		String str = "";
		while(curr!=null)
		{
			str = str + curr.value + " --> " ;
			curr = curr.next;
		}

		return str + "TAIL";
	}
}
