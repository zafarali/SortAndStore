public class Sort{
//nothing to sort yet!

	public static void bubble(int[] toSort){
	/* B U B B L E   S O  R T 
	Works by checking consecutive pairs of members and swapping them
	if one is bigger than the other.
	Note: There is a better version of bubble sort available */
		boolean swapped = true;
		/* The use of swapped:
		We have a swapped boolean to show that we made a change in the array.
		We will now have to recheck the array if there are more changes.
		If there are no changes (i.e. false) then the while loop will not execute
		and the array is sorted. */
		while(swapped){
		swapped = false;//not swapped anything yet
		for(int i = 0; i < toSort.length-1; i++){
			if(toSort[i] > toSort[i+1]){
				//element at i is larger than the one after. swap them
				swap(toSort, i, i+1);
				swapped = true;
			}//endif
		}}//endwhile & endfor
	}//end bubble

	public static void selection(int[] toSort){//toSort is unique
	/* S E L E C T I O N   S O R T
	Finds the max element and puts it into the last position of the array.
	Sorts the remaining array (n-1)
	Two helper methods: find max index and swap */
		int lastIndex = toSort.length - 1; //index of the last element
		while(lastIndex > 0){
			int indexMax = maxIndex(toSort, lastIndex); //sets the index of the maximum element
			swap(toSort, indexMax, lastIndex); //places the largest element at the last index
			lastIndex = lastIndex - 1; //the last index no longer needs to be checked
		}//end while
	}//end selection

	public static void insertion(int[] toSort){
	/* I N S E R T I O N    S O R T 
	sorts in place by removing individual elements from the array
	replaces the array in a sorted list in front of the unsorted element
	*/
		for(int i = 1; i < toSort.length; i++){//note 1, by default an array of one element is sorted
			int toInsert = toSort[i]; //select the element to be inserted correctly
			int k = i; //set the index for our search!
			//where do we place this element?
			//this while loop looks through the front of the array for the correct location to insert it
			while((k > 0 ) && toInsert < toSort[k-1]){
				//makes sure we move the indexes as long as the elements being checked
				//are larger than what we have to insert
				toSort[k] = toSort[k-1];//shift the element at the index
				k = k-1;//shift the index
			}//endwhile
			toSort[k] = toInsert;//insert the element to
		}//endfor	
	}//end insertion


	// H E L P E R   M E T H O D S
	private static int maxIndex(int[] a, int limit){
		int iMax = 0; 
		int eMax = a[0]; 
		for (int i = 0; i < limit; i++){
			if (a[i] > eMax){
				eMax = a[i];
				iMax = i;
			}}//end if && end for
		return iMax;
	}//end maxIndex

	private static void swap(int[] a, int originIndex, int targetIndex){
		//swaps the origin with the target.
		int temp = a[targetIndex];
		a[targetIndex] = a[originIndex];
		a[originIndex] = temp;
	}
	// T E S T I N G 
	public static void main(String[] args){
	 	int[] a = {1,2,5,5,9,1,1,10,2,5,3};
	 	insertion(a);
	 	p(a);
	}//end main


	//NOT RELATED TO SORTING ANYTHING 
	private static void p(int[] array1){
	  	String toBePrinted = "{";
	  	for(int i=0;i<array1.length;i++){
	    	toBePrinted += array1[i];
	    	if(i>=0 && i<(array1.length-1)){ toBePrinted += ", ";}
	    }
	  	toBePrinted +="}";
	  	System.out.println(toBePrinted);
  	}//end p(array)
  	private static void p(String s){System.out.println(s);}//end p(s)
  	private static void p(int e){System.out.println(e);}//end p(int)
}//end class
