package array;

import java.util.Arrays;

public class RemoveDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,3,4,5,6,7,7,7,8,9,9,9,9,9,9,9};
		
		int index = 0;
		for(int i=1;i<array.length;i++){
			if(array[index] != array[i+1]){
				index++;
				array[index] = array[i];
			}
		}
		array = Arrays.copyOf(array, index+1);
		
		for(int i:array){
			System.out.println(i);
		}
	}

}
