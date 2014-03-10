package SingleLinkedList;

class Node<T>{
//not public or private, only accesible to members of the package

	T content;
	Node next;//links to the next node in the chain.
	int priority;
	//constructor
	public Node(T o){
		content = o;
		next = null;
		priority = 0;
	}
	public Node(T o, int p){
		content=o;
		next =null;
		priority = p;
	}
}