package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TreeNode
{
	public TreeNode parent;
	public String value;
	public List<TreeNode> children;

	public TreeNode(String value)
	{
		this.value = value;
		this.parent = null;
		children = new ArrayList<TreeNode>();
	}
	
	public String toString()
	{
		return this.value.toString();
	}
}

public class ParentChildPairs{

	public static TreeNode ConvertCSPairsToTree(List<String> pairs)
	{
		HashMap<String, TreeNode> nodeNameToNodeMap = new HashMap<String, TreeNode>();

		for(String pair : pairs)
		{
			String child = pair.split(",")[1].trim();//a from a,b
			String parent = pair.split(",")[0].trim();//b from a,b
			
			TreeNode childNode = new TreeNode(child);
			TreeNode parentNode = new TreeNode(parent);

			if (!nodeNameToNodeMap.containsKey(child))
				nodeNameToNodeMap.put(child, childNode);
			if (!nodeNameToNodeMap.containsKey(parent))
				nodeNameToNodeMap.put(parent, parentNode);

			parentNode.children.add(childNode);//add a to b's children
			childNode.parent = parentNode;//mark a as b's child
		}

		//find the node that doesn't have a parent. that is the root node.
		for(String nodeName : nodeNameToNodeMap.keySet())
		{
			if (nodeNameToNodeMap.get(nodeName).parent == null)
				return nodeNameToNodeMap.get(nodeName);
		}

		return null;//there was a cycle or the input list was empty
	}


	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();
		list.add("a,b");
		list.add("a,c");
		list.add("c,d");
		list.add("c,e");
		list.add("b,f");
		System.out.println("Root is : "+ConvertCSPairsToTree(list).toString());
	}
}