package LinkedLists;

import java.util.Stack;

public class LinkedListPalindrome 
{
	public static void main(String[] args)
	{
		NewNode head = new NewNode(1);
		head.append(2);
		head.append(1);

		System.out.println(isPalindrome(head));
	}

	// Approach 1 :
	// We can traverse the List once and push all the values onto a Stack
	// Traverse the list again an for each element pop the Stack
	// and check for equality with the current node
	// return true if the nodes are matching
	// else return false.

	// Complexity : O(n) and extra space O(n)

	//----------------------------------------------------------------------------------------------------

	// Approach 2 :
	// have two Node pointers
	// apply the slow and fast runner approach to take the second pointer to
	// the middle of the list.
	// as the pointers are incremented, we will keep adding the elements pointed by the first
	// pointer onto a STACK.
	// when the original list has even elements ,both the first and second sub-lists will have equal elements
	// if the original list has odd elements, when the first pointer has moved to the last element,
	// we just increment the second pointer by one so that the middle element is skipped for comparisons
	// The next step is to compare the first half with the second half,
	// Now start incrementing the second pointer till it reached the end
	// while doing this we will pop the elements out of the stack and compare them with
	// the current element pointed by the second pointer
	// if they match then we will return true
	// At any instance if they don't match we will return false then and there.
	
	// Complexity :  O(n)

	public static boolean isPalindrome(NewNode head) 
	{
		// Stack for keeping a track of the first half of the list
		Stack<Integer> stack = new Stack<Integer>();
		// Two pointers
		NewNode slow = head;
		NewNode fast = head;
		// continue the loop until the fast pointer reaches the end
		// or the pen-ultimate node
		while (fast != null && fast.next != null) 
		{
			// keep pushing the values onto the stacks
			stack.push(slow.value);
			slow = slow.next;
			fast = fast.next.next;
		}
		// if list has odd number of elements, skip the middle element for comparisons
		if (fast != null) 
		{
			slow = slow.next;
		}
		// loop until the second pointer reaches the end
		// Keep popping the values from the stack
		// and compare it with the current value pointed by the slow pointer
		while (slow != null) 
		{
			int top = stack.pop();
			if (slow.value != top) 
			{
				return false;
			}
			slow = slow.next;
		}

		return true;
	}

}

class NewNode
{
	public NewNode next;
	public int value;

	public NewNode(int value)
	{
		this.value = value;
	}

	public NewNode append(int value)
	{
		NewNode node = new NewNode(value);
		next = node;
		return node;
	}
}



