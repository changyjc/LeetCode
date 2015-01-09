package hash;

import java.util.Hashtable;

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {2, 7, 11, 15};
		System.out.println(twoSum(numbers, 26)[0] + " " + twoSum(numbers, 9)[1]);
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		int[] a = new int[2];
		Hashtable<Integer, Integer> nums = new Hashtable<Integer, Integer>();
		for(int i = 0; i < numbers.length; i++){
			
			Integer n = nums.get(numbers[i]);		//nums中查询
			if(n == null)	nums.put(numbers[i], i);//加入nums
			n = nums.get(target - numbers[i]);		//nums中查询差值
			//找到了！！返回数组
			if(n != null && n < i){
				a[0] = n + 1;
				a[1] = i + 1;
				return a;
			}
		}
		
		return a;
	}
}
