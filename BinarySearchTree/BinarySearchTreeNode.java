package BinarySearchTree;
public class BinarySearchTreeNode{
	Object content;
	BinarySearchTreeNode left;
	BinarySearchTreeNode right;

	public BinarySearchTreeNode(Object val){
		content = val;
		left = null;
		right = null;
	}

	public boolean search(Object val){
		if(val.equals(content)){ return true; }
		if(left == null && right == null){ return false;}
		if(val.compareTo(content) == -1 && left!=null){return left.search(val);}//-1 means val is smaller
		if(val.compareTo(content) == +1 && right!=null){return right.search(val);}
		return false;
	}//end search
	//RECCURANCE FOR RUNNING TIME ON A TREE WITH n NODES; TAKEN EACH BRANCH HAS k NODES
	//T(n)=c+T(k)

	//Worst case: All nodes are on one side of the branch - we go through all of them
	// T(n) = c + T(n-1) = c + c + T(n-2) = c + c + c + T(n-3)
	//unroll and you will get: O(n)
	/* Best Case: T(n)= c + T(n/2) //always looks at one side
		T(n) = c + c + T(n/4) = c + c + c + T(n/8)
		O(log_2 n)
	*/

	public void insert(Object val){
		//looks first if we are at the leaf
		if(left==null && val.compareTo(content)==-1){
			//the left node is empty, we check if our insertion object is smaller than the content
			//if so we can insert it here!
			BinarySearchTreeNode x = new BinarySearchTreeNode(val);
			left = x;
		}
		if(right==null && val.compareTo(content) == 1){
			BinarySearchTreeNode x = new BinarySearchTreeNode(val);
			right = x;
		}
		if(val.compareTo.(content) == -1 && left !=null){
			left.insert(val);
		}else if(val.compareTo(content)==1 && right !=null){
			right.insert(val);
		}

		//what do we do if the object is equal? You're choice: exception, counters etc.

	}//end insert
	/* Running time depends on how balanced the tree is: T(n)=c+T(k)
	if the tree is balanced: O(log_2 n) 
	We need to pay some extra cost to make sure that our tree is balanced*/

	public void remove(Object val){
		if(!search(val)) return ; //nothing to remove

		//root is not null now we need to look for the value to replace the nodew with
		if(left==null && val.compareTo(content) == -1){
			content = right.content;
			left = right.left;			
			right = right.right;

			//OR IF WE HAVE REF TO PARENT(parent.left = right; )
		}

	}
}