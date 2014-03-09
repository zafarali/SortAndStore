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
	/* I N S E R T I O N   S O R T 
	sorts in place by removing individual elements at i from the array
	finds the appropriate location for i in the front of the array*/
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

	public static void merge(int[] toSort){
	/* M E R G E   S O R T
	divide the array into two halves
	sort each individual array using merge sort(implemented in btsms) i.e. recusion magic
	combine the results of the individual arrays by 'merging it'.
	Helper Method: combine to merge the arrays*/
		btsms(toSort, 0, toSort.length-1); 
	}

	//behind the scenes merge sort (btsms)
	private static void btsms(int[] toSort, int leftIndex, int rightIndex){
	//this method sorts between the left and right indexes.
		if(leftIndex<rightIndex){ //escape case.
			int mid = (leftIndex+rightIndex)/2;
			btsms(toSort, leftIndex, mid);
			btsms(toSort, mid+1, rightIndex);
			//the heavy lifting happens in our combine method
			combine(toSort, leftIndex, mid, rightIndex);
		}
	}//end btsms

	public static void quick(int[] toSort){
	/*Q U I C K   S O R T
	I can't even explain whats happening here. Magic of recursion.
	*/
		btsqs(toSort, 0, toSort.length-1);
	}

	//behind the scenes quick sort (btsqs)
	private static void btsqs(int[] toSort, int leftIndex, int rightIndex){
		if(leftIndex < rightIndex){//escape case
			int q = partition(toSort, leftIndex, rightIndex);
			btsqs(toSort, leftIndex, q);
			btsqs(toSort, q+1, rightIndex);
		}
	}

	private static int partition(int[] toSort, int leftIndex, int rightIndex){
	//this method makes sure all elements are sorted before and after a certain element in the list
		int x = toSort[leftIndex];
		int i = leftIndex-1;
		int j = rightIndex+1;
		while(true){
			do{
			i=i+1;
			}while(!(toSort[i] >= x));

			do{
			j = j-1;

			}while(!(toSort[j] <= x));
			if(i<j){
				swap(toSort, i, j);
			}else{
				return j;
			}
		}
	}
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

/*WARNING THIS DOESNT WORK*/
	private static void combine(int[] toCombine, int leftIndex, int midpoint, int rightIndex){
	//we assume that toCombine is sorted between leftIndex and midpoint and midpoint+1 and the rightIndex
		int[] tempArray = new int[rightIndex-leftIndex+1]; //holds the temporily sorted array.
		int i = leftIndex; //our left finger.
		int j = midpoint+1; //our middle finger.
		int k = 0; //keeps track of our location in the temp array
		//we now go over the two sorted halfs of the array and place them in the right order
		while(i<=midpoint && j <= rightIndex){//while we havent overshot our limits keep sorting.
						p(tempArray);

			if(toCombine[i] <= toCombine[j]){
				//we know that the element (at j) in the second half is larger than the one in the first half
				//we now push that first one (at i) into the tempArray
				tempArray[k] = toCombine[i];
				i = i + 1; //increment our finger to check the next element
			}else if(toCombine[j] < toCombine[i]){
				//we know that the element (at i) in the first half is larger than the one in the second half
				//we now push that element (at j) into the tempArray
				tempArray[k] = toCombine[j];
				j = j + 1;//increment our finger to check the next element
			}

			k = k+1; //moves our k location in the temporary array
		}//end while

		//we now need to copy back our temp array into toCombine
		for(int o = 1; o < rightIndex-leftIndex+1; o++){
			toCombine[o+leftIndex-1] = tempArray[o-1];
		}//end for

	}//end combine

	// T E S T I N G 
	public static void main(String[] args){
		int[] a = {10};
		p("before: ");
		p(a);
		quick(a);
		p("after:");
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
