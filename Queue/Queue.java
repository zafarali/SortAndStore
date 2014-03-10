package Queue;
public class Queue<T> extends SingleLinkedList<T>{
	Node<T> head;

	public Queue(){
		super();
	}
	public void insertFirst(T o) throws FirstInFirstOutException{
		throw new FirstInFirstOutException();
	}

	public T deQueue(T o) throws EmptyQueueException{
		if(head == null)
			throw new EmptyQueueException;
		return super.removeFirst();
	}

	public T removeLast() throws EmptyQueueException{
		try{
			super.removeLast()
		}catch(EmptyListException e){
			throw new EmptyQueueException;
		}
	}
}