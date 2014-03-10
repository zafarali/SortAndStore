package SingleLinkedList;

class Node<T>{
//not public or private, only accesible to members of the package

	T content;
	Node next;//links to the next node in the chain.

	//constructor
	public Node(T o){
		content = o;
		next = null;
	}
}