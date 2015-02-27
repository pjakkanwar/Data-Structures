package LinkedLists;

public class LinkedListWithLoop
{
	public static void main(String[] args)
	{
		Node head = new Node(1);
		Node middle = head.append(2).append(3).append(4).append(5);
		Node tail = middle.append(6).append(7).append(8).append(9).append(10)
				.append(11);
		tail.next = middle;
		//findLoopInformation(head);
		System.out.println(findStartOfLoop(head).value);
		findLoopInformation(head);
		System.out.println(findLoopBrent(head));
	}
	

	// Approach 1 :
	// Have a field in your Node class showing whether the node has been visited or not
	// by default set it to false;
	// if the node is visited, mark the node as visited (true)
	// if while traversing the list ,we encounter a node that has been visited,
	// then we know that the list has a loop

	// Complexity : time O(n) but overhead field in the Node class


	// Approach 2:
	// Keep a HashSet of all the nodes visited so far,
	// As the list is traversed, check if it already exists in the set
	// if it does then the list has a loop
	// else not

	/*
	 * function boolean hasLoop(Node startNode)
	 * {
	  		HashSet nodesSeen = new HashSet();
	  		Node currentNode = startNode;
	  		do 
	  		{
	    		if (nodesSeen.contains(currentNode)) 
	    			return true;
	    		nodesSeen.add(currentNode);
	  		} while (currentNode = currentNode.next);
	  		
	  		return false;
		}
	 */

	// Complexity : time O(n) and space O(n)

	// Approach 3: Floyd's Cycle detection algorithm
	
	// I have used this somehow while running on track
	
	// Keep two pointers, slow and fast runners
	// start at head and increment each node by one and two respectively
	// until both are null
	// break the loop when slow runner is equal to the fast runner
	// Now take back the slow runner to point to the head
	// again loop until the slow runner is equal to the fast runner
	// this time, increment each runner by just one
	// whenever they are equal, the fast   pointer is pointing to the loop start
	// return the fast pointer
	
	// Complexity : time O(n) and space O(1)
	
	private static Node findStartOfLoop(Node head)
	{
		Node slowRunner = head;
		Node fastRunner = head;

		// loop till either is null
		while(fastRunner!=null && slowRunner!=null)
		{
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;

			// break if both are equal
			// you have got a loop
			if(fastRunner==slowRunner)
				break;
		}

		// Move the slow runner back to the head
		slowRunner = head;

		// Loop till slow and fast are equal again
		// increment both by one
		while(fastRunner!=slowRunner)
		{
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next;
		}
		return fastRunner;
	}

	
	// Approach 4 : Brent's Cycle detection algorithm
	// Keep two pointers
	// One would be stationary and the other would be the moving pointer
	// have a counter for checking the no of steps taken by the moving pointer
	// have a separate field for step limit and set it to 2 initially
	// start the loop and continue until moving pointer is null
	// if moving pointer == stationary pointer
	// return true
	// if steps taken == step limit
	// increase the step limit by a factor of 2 and reinitialize the step taken counter to 0
	// also move the stationary pointer to point to where the moving pointer currently is
	// return false if the pointers are never equal
	
	// Complexity : time O(n) but faster than Floyd's (about 30%)
	
	public static boolean findLoopBrent(Node head)
	{
		Node statPointer = head;
		Node movPointer = head;
		int stepsTaken =0;
		int stepLimit = 2;
		
		while(movPointer!=null)
		{
			movPointer = movPointer.next;
			stepsTaken++;
			
			if(statPointer == movPointer)
				return true;
			if(stepLimit == stepsTaken)
			{
				stepLimit = stepLimit * 2;
				stepsTaken = 0;
				statPointer = movPointer;
			}
		}
		return false;
	}
	
	// Getting the Length of Loop
	private static void findLoopInformation(Node head)
	{
		Node slowPointer = head;
		Node fastPointer = head;
		boolean isLooped = false;
		while (fastPointer != null && fastPointer.next != null)
		{
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer)
			{
				isLooped = true;
				break;
			}
		}
		if (isLooped)
		{
			System.out.println("Linkedlist is looped");
			fastPointer = fastPointer.next;
			int count = 1;
			while (slowPointer != fastPointer)
			{
				fastPointer = fastPointer.next;
				count++;
			}
			System.out.println("Loop length = " + count);
			
			// to get the start node of the loop
			slowPointer = head;
			fastPointer = head;
			while (count-- > 0)
			{
				fastPointer = fastPointer.next;
			}
			while (slowPointer != fastPointer)
			{
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
			}
			System.out.println("Loop starting point = " + slowPointer.value);
		} else
		{
			System.out.println("Linkedlist is NOT looped");
		}
	}

	private static class Node
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