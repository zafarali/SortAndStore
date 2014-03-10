package Queue;
public class EmptyListException extends Exception{
//inherits Exception class methods.
	
	public EmptyListEception(){
		//calls the parent constructor with the message.
		super("Illegal operation: SingleLinkedList is Empty");
	}
}