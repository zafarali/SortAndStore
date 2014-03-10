package Queue;
public class EmptyQueueException extends Exception{
//inherits Exception class methods.
	
	public EmptyQueueExeption(){
		//calls the parent constructor with the message.
		super("Illegal operation: Queue is Empty");
	}
}