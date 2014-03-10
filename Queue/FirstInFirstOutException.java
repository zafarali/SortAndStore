package Queue;
public class FirstInFirstOutException extends Exception{
	public FirstInFirstOutException(){
		super("You cannot insert anything to the front of the Queue!");
	}
}