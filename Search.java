public class Search{

	//linear search using loops
	public static int linear(int[] toSearch, int target){
		//loop through the whole array!
		for(int i = 0; i < toSearch.length; i++){
			//check member at index to target
			if(toSearch[i] == target){
				return i;
			}
		}
		//not found, return a -1!
		return -1;
	}//end linear

	//binary search using loops
	public static int binary(int[] toSearch, int target){
		//initialize the important indexing variables.
		int left = 0;
		int right = toSearch.length -1;
		int mid;

		//keeps looping as long as the indexes don't pass each other
		while (left < right){

			//set the middle variable
			mid = (left+right)/2;

			//checking values
			if(toSearch[mid] == target){
				return mid;
			}

			//not the middle value --> reset the left or right indexes
			if(toSearch[mid] > target){right = mid - 1;}else{left = mid + 1;}
		}

		//not found, return a -1!
		return -1;
	}//end binary

	//binary search using recursion
	//behind the scenes implimentation (DO NOT USE)
	private static int btsrb(int[] a, int t, int l, int r){
		//escape case:
		if(l>r) return -1;

		//checking the middle
		int mid = (l + r)/2;
		if (a[mid] == t) return mid;

		//if the middle is larger than the target, we need to check first half
		if (a[mid] > t)
			return btsrb(a, t, l, mid-1);
		return btsrb(a,t,mid+1,r);
	}//end btsrb

	//signature for you to use
	public static int rbinary(int[] toSearch, int target){
		//initialize the important indexing variables.
		int left = 0;
		int right = toSearch.length -1;
		return btsrb(toSearch, target, left, right);
	}//end rbinary

}//end class