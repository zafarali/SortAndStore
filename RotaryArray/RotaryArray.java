package RotaryArray;
public class RotaryArray<T>{

	private T[] a; //an array of T's
	//private so nobody can acces it directyl!
	private int addNext;
	//constructor(just makes an array of given size.)
	public RotaryArray(int size){
		a = new T[size];
		addNext = 0;
	}

	//using an existing array and turning it into a RotaryArray
	public RotaryArray(T[] transfer){
		a = transfer;
		addNext = transfer.length-1;
	}

	public boolean isFull(){
		for(int i = 0; i < a.length; i++){
			//goes through each element in the array
			//if we find a null element (i.e. not filled) return a false
			if(a[i] == null){
				return false;
			}
		}
		//return a true because we didnt find any null indexes.
		return true;
	}

	public void add(T toAdd){
		a[addNext] = toAdd;
		addNext = determineIndex(addNext+1);
	}

	public T removeFirst(){
		T toBeReturned;
		for(int i = 0; i<a.length; i++){
			if(a[i]!=null){
				toBeReturned = a[i];
				a[i] = null;
			}
		}
		return toBeReturned;
	}


	//we can use this in combination with search for example:
	//print(myRotaryArray.access(myRotaryArray.search(looking for this)));
	public T access(int index){
		return a[index];
	}
	public int search(T target){
		for(int i = 0; i<a.length; i++){
			if(a[i].equals(target)){
				return i;
			}
		}
		return -1;
	}


	//determines the index of the n'th element in the rotary array.
	public int determineIndex(int n){
		int modstore = n % a.length;
		return modstore;
	}
}