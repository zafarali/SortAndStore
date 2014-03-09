public class Sort{
//nothing to sort yet!

	public static void bubble(int[] toSort){
		/*
		B U B B L E   S O  R T 
		Works by checking consecutive pairs of members and swapping them
		if one is bigger than the other
		*/
		boolean swapped = true;
		/* The use of swapped:
		We have a swapped boolean to show that we made a change in the array.
		We will now have to recheck the array if there are more changes.
		If there are no changes (i.e. false) then the while loop will not execute
		and the array is sorted.
		*/
		while(swapped){
		swapped = false;//not swapped anything yet
		for(int i = 0; i < toSort.length-1; i++){

			if(toSort[i] > toSort[i+1]){
				//element at i is larger than the one after. swap them
				int temp = toSort[i+1];
				toSort[i+1] = toSort[i];
				toSort[i] = temp;

				swapped = true;
			}//endif
		}}//endwhile & endfor

	}//end bubble


	// T E S T I N G 
	public static void main(String[] args){
		int[] a = {5,10,9,8,9,10,1,1};
		bubble(a);
		printArray(a);
	}


	//NOT RELATED TO SORTING ANYTHING 
	public static void printArray(int[] array1){
  	String toBePrinted = "{";
  	for(int i=0;i<array1.length;i++){
    	toBePrinted += array1[i];
    	if(i>=0 && i<(array1.length-1)){ toBePrinted += ", ";}
    }
  	toBePrinted +="}";
  	System.out.println(toBePrinted);
  	}//end printArray
}//end class
