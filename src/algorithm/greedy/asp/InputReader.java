/**
 * Nihanth Dara nxd130730@utdallas.edu
 * Aditya Cherukuri axc130330@utdallas.edu
 */
package algorithm.greedy.asp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputReader{
	/**
	 * Method to read the input from the given file
	 * @param aspList 
	 * @return 
	 * @throws IOException
	 */
	public int readInput(ArrayList<ASPDataStructure> aspList) throws IOException {
		ASPDataStructure aspDataStructure = null;
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/input-10.txt"));
		String line = null;
		int size = 0;
		int activityNumber = 1;
		int maxSmallActivitiesCount = 0;
		if((line = br.readLine()) != null)
		{
			size = Integer.parseInt(line);
		}
		if(size > 2){
			while((line = br.readLine()) != null)
			{
				aspDataStructure = new ASPDataStructure(line, activityNumber);
				aspList.add(aspDataStructure);
				if(aspDataStructure.isActivityLong != null && aspDataStructure.isActivityLong.equalsIgnoreCase("Small"))
				{
					maxSmallActivitiesCount++;
				}
				activityNumber++;
			}
		}
		br.close();
		return maxSmallActivitiesCount;
	}
}
