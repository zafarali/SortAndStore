public class MergeSort{
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

/*WARNING THIS DOESNT WORK*/
	private static void combine(int[] toCombine, int leftIndex, int midpoint, int rightIndex){
	//we assume that toCombine is sorted between leftIndex and midpoint and midpoint+1 and the rightIndex
		int[] tempArray = new int[rightIndex-leftIndex+1]; //holds the temporily sorted array.
		int i = leftIndex; //our left finger.
		p(toCombine);
		int j = midpoint+1; //our middle finger.
		int k = 0; //keeps track of our location in the temp array
		//we now go over the two sorted halfs of the array and place them in the right order
		while(i<=midpoint && j <= rightIndex){//while we havent overshot our limits keep sorting.
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

		if(i<=midpoint && j > rightIndex){
			while (i<=midpoint){
				tempArray[k] = toCombine[i];
				i = i+1; k=k+1;
			}
		}else{
			while(j<=rightIndex){
				tempArray[k] = toCombine[j];
				k=k+1;j=j+1;
			}
		}
		//we now need to copy back our temp array into toCombine
		for(int o = 0; o < tempArray.length; o++){
			toCombine[o+leftIndex] = tempArray[o];
		}//end for
		p(toCombine);
	}//end combine
		// T E S T I N G 
	public static void main(String[] args){
		int[] a = {10,9,8,3,4,6,1,11};
		p("before: ");
		p(a);
		merge(a);
		p("after:");
		p(a);
	}//end main
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
  	private static void p(int e){System.out.println(e);}//end 
}