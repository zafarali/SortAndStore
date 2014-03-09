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
	}

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
	}

	//binary search using recursion
	public static int rbinary(int[] toSearch, int target){
		//initialize the important indexing variables.
		int left = 0;
		int right = toSearch.length -1;
		int mid;
	}
}