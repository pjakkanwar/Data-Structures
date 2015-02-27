package Trees;
public class TreeImplementation 
{
	public static void main(String args[])
	{
		try 
		{
			Tree objTree = new Tree();
			objTree.insert(6);
			objTree.insert(10);
			objTree.insert(30);
			objTree.insert(15);
			objTree.insert(5);
			objTree.insert(60);
			
			Node searchedNode = objTree.find(6);
			if(searchedNode != null)
				System.out.println("Node found");
			else
				System.out.println("Node not found");
			
			
			
			objTree.inorderTraversal(searchedNode);
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println("Not found");
		}
		
	}
}

class Node
{
	int data;
	Node leftChild;
	Node rightChild;
}

class Tree
{
	public Node root;
	
	public Node find(int key)
	{
		Node current=root;
		
		while(current.data != key)
		{
			if(key < current.data)
			{
				current = current.leftChild;
				System.out.println("Moving to left child : " + current.data);
			}
			else
			{
				current = current.rightChild;
				System.out.println("Moving to right child : " + current.data);

			}
		}
		return current;
		
	}

	public void insert(int dataToInsert)
	{
		Node newNode = new Node();
		newNode.data = dataToInsert;
		
		if(root == null)
			root=newNode;
		else
		{
			Node current = root;
			Node parent;
			while(true)
			{
				// to keep the track to the current node so as to link
				//it with the node to be inserted
				parent = current;
				
				// Go to left subtree
				if(dataToInsert < current.data)
				{
					current = current.leftChild;
					if(current == null)
					{
						parent.leftChild = newNode;
						return;
					}
				}
				//Go to right subtree
				else
				{
					current = current.rightChild;
					if(current == null)
					{
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public void inorderTraversal(Node root)
	{
		if(root != null)
		{
			inorderTraversal(root.leftChild);
			System.out.println(root.data);
			inorderTraversal(root.rightChild);
		}
	}
}
