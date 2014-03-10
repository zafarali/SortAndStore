package BinarySearchTree;
public class BinarySearchTree{
	// BINARY SEARCH TREE
	// Only two children per node
	// node on the right is bigger than the node on the left	


	BinarySearchTreeNode root;	
	public BinarySearchTree(){ root = null;}

	public BinarySearchTree(Object val){ root = new BinarySearchTreeNode(val); }
	public boolean search(Object val){	return root.search(val); }

	public void insert(Object val){
	/* Always insert at the leaves of the tree...*/
	/* this calls on an insert method in the BinarySearchTreeNode*/
		if(root!=null){ //empty tree
			root.insert(val);
		}else{
			root = new BinarySearchTreeNode(val);
		}
	}//end insert

	public Object remove(Object val){
	/*Three cases: (1) Removing a terminal node
				   (2a) Removing a parent node, we need to maintain the children 
				   (2b) Removing a parent node with two children*/

	//in general we need to reset the parent node to the largest value in the left subtree (left---->right)
				   //or the smallest value in the right (right ---> left)
		if(left==null && right == null){
			root.remove();
			root = null;
		}
		
	}
}