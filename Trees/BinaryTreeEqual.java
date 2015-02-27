package Trees;

public class BinaryTreeEqual 
{
	
	// Complexity : O(n) since each node is visited atmost once
	public static boolean isEqual(MyBinaryTree tr1,MyBinaryTree tr2)
	{
		// if tree1 and tree 2 both are null
		// return true since null trees are equal
		if(tr1==null && tr2==null)
			return true;
		// if either one is null return false
		if(tr1==null || tr2 == null)
			return false;
		// else check recursively for left children and right children
		// along with the data values for each nodes
		else
			return isEqual(tr1.left, tr2.left) && isEqual(tr1.right, tr2.right) && (tr1.value==tr2.value);
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MyBinaryTree mt = new MyBinaryTree(1);
		mt.left = new MyBinaryTree(2);
		mt.right = new MyBinaryTree(3);
		mt.left.left = new MyBinaryTree(4);
		mt.left.right = new MyBinaryTree(5);
		mt.right.left = new MyBinaryTree(6);
		mt.right.right = new MyBinaryTree(7);
		
		MyBinaryTree mt1 = new MyBinaryTree(1);
		mt1.left = new MyBinaryTree(2);
		mt1.right = new MyBinaryTree(3);
		mt1.left.left = new MyBinaryTree(4);
		mt1.left.right = new MyBinaryTree(5);
		mt1.right.left = new MyBinaryTree(6);
		mt1.right.right = new MyBinaryTree(7);
		
		System.out.println(isEqual(mt, mt1));

	}

}
