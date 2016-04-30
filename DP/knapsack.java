public class knapsack 
{
	public static void main(String[] args)
	{	
		int money = 100;
		int[] values = {2,4,5,10,1};
		int[] costs = {2,8,3,6,3};
		
		System.out.println(doKnapsack(money, values, costs));
	}
	
	public static int doKnapsack (int money, int[] values, int[] costs)
	{
		int[] comparing = new int[money+1];
		
		for(int i=0; i<values.length; i++)
		{
			int Value = values[i];
			int Cost = costs[i];	
			
			for (int j=Cost; j<comparing.length; j++)
			{
				comparing[j] = Math.max(comparing[j], comparing[j-Cost]+Value);
			}					
		}			
	
		return comparing[comparing.length-1];
	}
}