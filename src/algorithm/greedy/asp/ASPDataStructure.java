/**
 * Nihanth Dara nxd130730@utdallas.edu
 * Aditya Cherukuri axc130330@utdallas.edu
 */
package algorithm.greedy.asp;

/**
 * This is the class file for the data structure of ASP
 * @author Nihanth
 *
 */
public class ASPDataStructure {
	
	public int activityNumber;
	public int activityStartTime;
	public int activityEndTime;
	public int activityWeight;
	public String isActivityLong = 
			profitArray = new int[lastIndex+2][maxSmallActivnull;
	public boolean shouldActivityBeUsed = false;
	public int smallCompatibleCount = 0;
	
	/**
	 * This is the over ridden constructor method. 
	 * It initializes the variables of the data structure.
	 * @param line
	 * @param activityNumber
	 */
	public ASPDataStructure(String line, int activityNumber) {
		String[] input = line.split("\\s+");
		this.activityNumber = activityNumber;
		this.activityStartTime = Integer.parseInt(input[0]);
		this.activityEndTime = Integer.parseInt(input[1]);
		this.activityWeight= Integer.parseInt(input[2]);
		if(this.activityEndTime == this.activityStartTime)
		{
			this.isActivityLong = null;
		}
		else if(this.activityEndTime - this.activityStartTime > 4)
		{
			this.isActivityLong = "Long";
		}
		else
		{
			this.isActivityLong = "Small";
		}
	}
}
