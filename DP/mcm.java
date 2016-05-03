import java.util.Arrays;

public class mcm 
{
	public static int[][] memo;
	public static void main(String[] args) 
	{
			int l = 4797;			
			memo = new int[l][l];
			for(int i=0; i<l; i++)
				Arrays.fill(memo[i], Integer.MAX_VALUE);
			int c = 3;
			int[] cuts = {0,1188,3004,3872,l};

			System.out.println(lumberjack(0, c+1, cuts));
	}	
	//Kinda like mcm but the value ideals are backwards, you have big, look for small
	//If something hasn't been changed, find a better value
	public static int lumberjack(int length, int cut, int[] cuts)
	{
		if(cut-length < 2) 
			memo[length][cut] = 0;
		if(memo[length][cut] == Integer.MAX_VALUE)
			for(int i= length+1; i<cut; i++)
			{
				int temp = (cuts[cut]-cuts[length]) + lumberjack(length, i, cuts) + lumberjack(i, cut, cuts);
				memo[length][cut] = Math.min(memo[length][cut], temp);
			}
		return memo[length][cut];
	}
}