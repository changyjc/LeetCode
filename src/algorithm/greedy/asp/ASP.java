package algorithm.greedy.asp;



import java.io.IOException;
import java.util.ArrayList;

public class ASP {
	



	public static ArrayList<ASPDataStructure> aspList = new ArrayList<ASPDataStructure>();
	public static int[][][] profitArray;
	public static int internationalProfit = 0;
	public static int internationalIndex = 0;
	public static int internationalSmall = 0;
	public static int internationalLarge= 0;
	
	/**
	 * This is the start process method for ASP, and calls all the methods in sequential order.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){
		int maxSmallActivitiesCount = 0;
		try{
			InputReader inputReader = new InputReader();
			maxSmallActivitiesCount =  inputReader.readInput(aspList);
			if(aspList.size() == 0)
			{
				throw new Exception("Activities are not present in the input file.");
			}
			ASPSort.sortASP(aspList, 0 , aspList.size()-1);
			int max = 0, finalMax = 0, finalSmall=0,finalLarge=0;;
			int lastIndex = aspList.size()-1;
			profitArray = new int[lastIndex+2][maxSmallActivitiesCount+1][maxSmallActivitiesCount];
			for(int i = 1; i <= maxSmallActivitiesCount; i++)
			{
				for(int j = 0; j <= i-1; j++)
				{
					max = aspForProfitCalculation(lastIndex, i, j);
					profitArray[lastIndex][i][j] = max;
					if(max > finalMax)
					{
						finalMax = max;
						finalSmall= i;
						finalLarge=j;
					}
				}
			}
			System.out.println("Profit = "+finalMax);
			System.out.println("Excess small = "+(finalSmall-finalLarge));
			for(;internationalIndex > 0;)
			{
				internationalProfit = 0;
				aspForActivitiesSelection(internationalIndex, internationalSmall, internationalLarge);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static int aspForProfitCalculation(int lastIndex, int small, int large) {
		if(small < 0 || large < 0)
		{
			return -10000;
		}
		else if(small == 0 && large == 0)
		{
			return 0;
		}
		else if(lastIndex == 0 && (small > 0 || large > 0))
		{
			return -10000;
		}
		else
		{
			ASPDataStructure temp = aspList.get(lastIndex);
			int j = lastIndex;
			int max = 0;
			while(j >= 0 && aspList.get(j).activityEndTime > aspList.get(lastIndex).activityStartTime)
			{
				j--;
			}
			if(aspList.get(lastIndex).isActivityLong.equalsIgnoreCase("Small"))
			{
				if(small == 0 && large >= 1 && lastIndex >= 1)
				{
					while(j >= 0 && aspList.get(lastIndex).isActivityLong != null && aspList.get(lastIndex).isActivityLong.equalsIgnoreCase("Long"))
						j = j--;
				}
				int output = -10000;
				if(small > 0 && profitArray[j][small-1][large] == 0){
					output = aspForProfitCalculation(j, small-1, large);
					profitArray[j][small-1][large] = output;
				}
				else
				{
					if(small > 0)
					output = profitArray[j][small-1][large];
				}
				max = temp.activityWeight + output;
			}
			else if(aspList.get(lastIndex).isActivityLong.equalsIgnoreCase("Long"))
			{
				if(small >= 1 && large == 0 && lastIndex >= 1)
				{
					while(j >= 0 && aspList.get(lastIndex).isActivityLong != null && aspList.get(lastIndex).isActivityLong.equalsIgnoreCase("Small"))
						j = j--;
				}
				int output = -10000;
				if(large > 0 && profitArray[j][small][large-1] == 0){
					output = aspForProfitCalculation(j, small, large-1);
					profitArray[j][small][large-1] = output;
				}
				else
				{
					if(large > 0)
					output = profitArray[j][small][large-1];
				}
				max = temp.activityWeight + output;
			}
			int	anotherResult = -10000;
			if(profitArray[lastIndex-1][small][large] == 0)
			{
				anotherResult = aspForProfitCalculation(lastIndex-1, small, large);
				profitArray[lastIndex-1][small][large] = anotherResult; 
			}
			else
			{
				anotherResult = profitArray[lastIndex-1][small][large];
			}
			if(internationalProfit < max && max > anotherResult)
			{
				internationalProfit = max;
				internationalIndex = lastIndex;
				internationalSmall = small;
				internationalLarge = large;
				aspList.get(j).shouldActivityBeUsed = true;
				aspList.get(lastIndex).shouldActivityBeUsed = true;
//				System.out.println(aspList.get(lastIndex).activityStartTime);
			}
			if(internationalProfit < anotherResult && anotherResult > max)
			{
				internationalProfit = max;
				internationalIndex = lastIndex-1;
				internationalSmall = small;
				internationalLarge = large;
				aspList.get(lastIndex-1).shouldActivityBeUsed = true;
//				System.out.println(aspList.get(lastIndex-1).activityStartTime);
			}
			return Math.max(max, anotherResult);
		}
	}
	
	private static int aspForActivitiesSelection(int lastIndex, int small, int large) {
		if(small < 0 || large < 0)
		{
			return -10000;
		}
		else if(small == 0 && large == 0)
		{
			return 0;
		}
		else if(lastIndex == 0 && (small > 0 || large > 0))
		{
			return -10000;
		}
		else
		{
			ASPDataStructure temp = aspList.get(lastIndex);
			int j = lastIndex;
			int max = 0;
			while(j >= 0 && aspList.get(j).activityEndTime > aspList.get(lastIndex).activityStartTime)
			{
				j--;
			}
			if(aspList.get(lastIndex).isActivityLong.equalsIgnoreCase("Small"))
			{
				if(small == 0 && large >= 1 && lastIndex >= 1)
				{
					while(j >= 0 && aspList.get(lastIndex).isActivityLong != null && aspList.get(lastIndex).isActivityLong.equalsIgnoreCase("Long"))
						j = j--;
				}
				int output = profitArray[j][small-1][large];
				max = temp.activityWeight + output;
			}
			else if(aspList.get(lastIndex).isActivityLong.equalsIgnoreCase("Long"))
			{
				if(small >= 1 && large == 0 && lastIndex >= 1)
				{
					while(j >= 0 && aspList.get(lastIndex).isActivityLong != null && aspList.get(lastIndex).isActivityLong.equalsIgnoreCase("Small"))
						j = j--;
				}
				int output = profitArray[j][small][large-1];
				max = temp.activityWeight + output;
			}
			int	anotherResult = profitArray[lastIndex-1][small][large];
			if(internationalProfit < max && max >= anotherResult)
			{
				internationalProfit = max;
				internationalIndex = j;
				internationalSmall = small;
				internationalLarge = large;
				aspList.get(j).shouldActivityBeUsed = true;
				aspList.get(lastIndex).shouldActivityBeUsed = true;
				if(aspList.get(lastIndex).isActivityLong.equalsIgnoreCase("small"))
				{
					internationalSmall--;
					System.out.println("[S] "+ aspList.get(lastIndex).activityStartTime + " " + aspList.get(lastIndex).activityEndTime + " " + aspList.get(lastIndex).activityWeight);
				}
				if(aspList.get(lastIndex).isActivityLong.equalsIgnoreCase("Long"))
				{
					internationalLarge--;
					System.out.println("[B] "+ aspList.get(lastIndex).activityStartTime + " " + aspList.get(lastIndex).activityEndTime + " " + aspList.get(lastIndex).activityWeight);
				}
			}
			if(internationalProfit < anotherResult && anotherResult >= max)
			{
				internationalProfit = max;
				internationalIndex = lastIndex-1;
				internationalSmall = small;
				internationalLarge = large;
				aspList.get(lastIndex-1).shouldActivityBeUsed = true;
			}
			return Math.max(max, anotherResult);
		}
	}
}
