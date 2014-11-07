package array;

import java.util.Arrays;

public class SearchRotated {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {113,220,258,2,3,4,5};
		System.out.println(getNewArray(array)[0]);
	}

	private static int[] getNewArray(int[] array) {
		// TODO Auto-generated method stub
		System.out.println((double)array.length/2);
		int mid = (int) Math.ceil((double)array.length/2);
		System.out.println(mid);
		int last = array.length-1;
		
		if(array[0] < array[mid-1]){
			return Arrays.copyOfRange(array, mid-1, mid);
		}else{
			if(array.length > 1){
				if(array[mid]< array[last]){
					array = Arrays.copyOf(array, mid);
				}else{
					array = Arrays.copyOfRange(array, mid, last);
				}
				return getNewArray(array);
			}else{
				return array;
			}
		}
	}

}
