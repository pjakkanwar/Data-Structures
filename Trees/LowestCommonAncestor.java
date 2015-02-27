package Trees;

import java.util.HashSet;

public class LowestCommonAncestor
{

	/**
	 * @param args
	 */
	
	static NextNode LCANode = null;
	
	
	public static void main(String[] args)
	{

		NextNode a = new NextNode(1);
		NextNode b = new NextNode(2);
		NextNode c = new NextNode(3);
		NextNode d = new NextNode(4);
		NextNode e = new NextNode(5);
		NextNode f = new NextNode(8);
		NextNode g = new NextNode(6);
		NextNode h = new NextNode(7);
		a.left = b;
		a.right = c;
		b.left = d;
		c.left = e;
		c.right = f;
		f.left = g;
		f.right = h;
		
		NextNode a1 = new NextNode(5);
		NextNode b1 = new NextNode(6);
		NextNode c1 = new NextNode(7);
		NextNode d1 = new NextNode(8);
		NextNode e1 = new NextNode(9);
		a1.left=b1;
		b1.parent=a1;
		b1.left=c1;
		c1.parent=b1;
		b1.right=d1;
		d1.parent=b1;
		d1.right=e1;
		e1.parent=d1;

		//LCA(a, g, h);
		
		//System.out.println(findLCA(a, g, h).value);
		System.out.println("LCAWithParentLink : " + LCAWithParentLink(c1,e1).value); // 6
		System.out.println("LCANew :  " + LCANew(a, g, h).value); // 8
		
		//System.out.println(LCANode.value);
		//System.out.println(LCANode.value);
	}


	// Complexity O(log n)
	// WITH A PARENT FIELD  IN THE NODE 
	public static NextNode LCAWithParentLink(NextNode a , NextNode b)
	{
		HashSet<NextNode> set = new HashSet<NextNode>();
		
		while(a!=null)
		{
			set.add(a);
			a= a.parent;
		}
		
		while(b!=null)
		{
			if(set.contains(b))
				return b;
			b=b.parent;
		}
		
		return null;
	}
	
	
	// Complexity O(n)
	public static NextNode LCANew(NextNode root,NextNode p, NextNode q)
	{
		//base cases
		if(root==null)
			return null;

		// If either p or q matches with root, report
	    // the presence by returning root (Note that if a node is
	    // ancestor of other, then the ancestor node becomes LCA
		if(root==p || root==q)
			return root;

		// Look for values in left and right subtrees
		NextNode left=LCANew(root.left,p,q);
		NextNode right=LCANew(root.right,p,q);

		//p and q are on the different branches, return root
		if(left!=null && right!=null)
			return root;

		//p and q are on the same branch
		// Otherwise check if left subtree or right subtree is LCA
		else if(left!=null)
			return left;
		else
			return right;
	}


//	public static int LCA(NextNode currentNode, NextNode n1, NextNode n2)
//	{
//		if (currentNode == null)
//			return 0;
//		int currentValue = 0;
//		if (currentNode == n1 || currentNode == n2)
//			currentValue = 1;
//		int leftValue = LCA(currentNode.left, n1, n2);
//		int rightValue = LCA(currentNode.right, n1, n2);
//		if ((currentValue == 1 && leftValue == 1)
//				||(currentValue == 1 && rightValue == 1)
//				||(leftValue == 1 && rightValue == 1))
//		{
//			LCANode = currentNode;
//			return 2;
//		}
//		return currentValue + leftValue + rightValue;
//
//	}
//
//	public static NextNode findLCA(NextNode root, NextNode p, NextNode q) {
//		if (root == null || p == null || q == null)
//			return null;
//
//		int depth1 = getDepth(root, p);
//		int depth2 = getDepth(root, q);
//		if (depth1 > depth2) {
//			swap(depth1, depth2);
//			swap(p, q);
//		}
//		for (int i = 0; i < depth1 - depth2; i++) {
//			q = q.parent;
//		}
//		while (p!=null) {
//			if (p == q)
//				return p;
//			p = p.parent;
//			q = q.parent;
//		}
//		return null;
//	}
//
//	public static int getDepth(NextNode root, NextNode n) {
//		if (root == null || n == null) 
//			return 0;
//		int depth = 0;
//		while (root != n) 
//		{
//			depth++;
//			n = n.parent;
//		}
//		return depth;
//	}
//
//	public static void swap(Object a, Object b) {
//		Object tmp = a;
//		a = b;
//		b = tmp;
//	}

}

class NextNode
{
	public NextNode left;
	public NextNode right;
	public NextNode next;

	//just for lowest common ancestor
	public NextNode parent;

	public int value;
	public NextNode(int value)
	{
		this.value=value;
	}
}

class NodeContainer
{
	public NextNode node;
}