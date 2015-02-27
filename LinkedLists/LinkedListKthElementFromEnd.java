package LinkedLists;

public class LinkedListKthElementFromEnd
{
	public static void main(String[] args)
	{
		Node head = new Node(1);
		head.append(2).append(3).append(4).append(5).append(6).append(7)
		.append(8).append(9);
		Node result = findKFromEnd(head, 3);
		System.out.println(result.value);
	}
	
	
	// One Approach is to find the length of the Linked List by traversing it first
	// then once you have the length, traverse it again till the (length - n + 1) node
	// and print it
	
	
	// Second Approach is to have two pointers both starting at the head
	// Move the first pointer to point at 'nth' node from the start
	// Now increment both the pointers by one till the first one reaches the end
	// i.e. (first.next ==null)
	// once it has reached the end, the second pointer will be pointing to the
	// nth node from last 
	// return the second pointer
	private static Node findKFromEnd(Node head, int k)
	{
		Node ahead = head;
		while (k-- > 0)
			ahead = ahead.next;
		while (ahead != null)
		{
			head = head.next;
			ahead = ahead.next;
		}
		return head;
	}

	// Node class for getting the nth node from last
	// has once node pointer pointing to the next node
	// and an integer value field.
	// append function is added just to append nodes to the end of the list
	public static class Node
	{
		public Node next;
		public int value;

		public Node(int value)
		{
			this.value = value;
		}

		public Node append(int value)
		{
			Node node = new Node(value);
			next = node;
			return node;
		}
	}

}