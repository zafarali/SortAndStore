package SingleLinkedList;

public class SingleLinkedList <T>{
	Node head;

	public SingleLinkedList(){
		head = null;
	}//end constructor

	public boolean isEmpty(){
		return (head==null); 
	}//end isEmpty


// I N S E R T E R   M E T H O D S
	public void insertFirst(T o){
		Node<T> n = new Node<T>(o);
		//set the next element of the newly created node to the head
		n.next = head;

		//modify our head so it points to the new node.
		head = n;
	}//end insertFirst

	public void insertLast(T o){
		Node<T> n = new Node<T>(o);

		if(head==null){
			//the list is empty that means the last element and head element will be this
			head = n;
		}else{
			//the list is not empty so we must go along until we come to the end of it
			Node<T> crt = head; //points to the current Node in the list, set to head as first.
			
			while(crt.next!=null){
				//goes along until it finds a node that doesnt have a next.
				crt = crt.next;//moves our current pointer to the next node.
			}

			crt.next = n;//make the last element point to our newly created node.
		}

	}//end insertLast

// D E L E T E R  M E T H O D S
	public T removeFirst() throws EmptyListException{
		if (head == null )
			throw new EmptyListException();

		//set the current pointer to the head.
		Node<T> crt = head;

		head = crt.next; //move the head pointer to the next element in the list
		T toBeReturned = crt.content;
		
		//nulls the current content and next so that garbage collector can clear it
		crt.content = null;
		crt.next = null;

		return toBeReturned;
	}

	public T removeLast() throws EmptyListException{
		if(head == null){
			throw new EmptyListException();
		}else{
			T toBeReturned;

			if(head.next == null){
				//this means that there is only one node in our list (the head node has no next!)
				toBeReturned = head.content;

				//set the head to be null
				head.content = null;
				head = null;
				return toBeReturned;
			}

			//we execute this code only if there is more than one element in our list.
			Node<T> crt = head;

			while(crt.next.next !=null){
				//a bit odd, it just says, refer to the curren elements next elements next element.
				//if this is null that means we have come to the second to last element.
				crt = crt.next;
			}

			toBeReturned = crt.next.content;

			//the usual nullifications
			crt.next.content = null;
			crt.next = null;

			return toBeReturned;

		}
	}

	public boolean search(T toFind){
		if(head == null) 
			return false; //we could have easily thrown an exception here.

		for(Node<T> crt = head; crt!=null; crt= crt.next){
			if (toFind.equals(crt.content)) return true;
		}
		return false;
	}
}