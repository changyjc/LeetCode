/**
 * Nihanth Dara nxd130730@utdallas.edu
 * Aditya Cherukuri axc130330@utdallas.edu
 */
package algorithm.greedy.asp;

import java.util.ArrayList;

public class ASPSort {
	/**
	 * This method implements quick sort based on the finish times of the activities
	 * @param aspList
	 * @param start
	 * @param end
	 */
	public static void sortASP(ArrayList<ASPDataStructure> aspList, int start, int end) {
		if(start<end)
		{
			int q = Partition(aspList, start, end);
			sortASP(aspList, start, q-1);
			sortASP(aspList, q+1, end);
		}
	}
	
	/**
	 * This method does partition of the array as in quick sort based on the pivot
	 * @param aspList
	 * @param start
	 * @param end
	 * @return
	 */
	private static int Partition(ArrayList<ASPDataStructure> aspList, int start,
			int end) {
		ASPDataStructure temp = aspList.get(end);
		int i = start-1;
		for(int j = start; j <= end-1; j++)
		{
			if(aspList.get(j).activityEndTime <= temp.activityEndTime)
			{
				i++;
				swapActivities(aspList, i, j);
			}
		}
		swapActivities(aspList, i+1, end);
		return i+1;
	}
	
	/**
	 * This method is used for swapping the elements in the arraylist 
	 * based on the indexes provided.
	 * @param aspList
	 * @param index1
	 * @param index2
	 */
	private static void swapActivities(ArrayList<ASPDataStructure> aspList,
			int index1, int index2) {
		ASPDataStructure temp = aspList.get(index1);
		aspList.set(index1, aspList.get(index2));
		aspList.set(index2, temp);
	}

}
