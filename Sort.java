public class Sort{
	public static int linear(int[] toSearch, int target){
		for(int i = 0; i < toSearch.length; i++){
			if(toSearch[i] == target){
				return i;
			}
		}
		return -1;
	}
	public static int binary(int[] toSearch, int target){
		return 1;
	}
}