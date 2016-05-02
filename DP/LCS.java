import java.util.*;

public class LCS 
{
	public static void main(String[] args)
	{
		String a = "bhUzTeLXsfLmfFiVIq0vejvSc2hAeZXbuE2jO487RqpX3KGlScrJN849h1CDxQOJou4noa1FjB2nDNq5iQuTlDjsAZl93WZng5uS";
		String b = "F7tH1h0T72GfGlyKhi1JfNYF2gVPEpFBkkc8i9JD09awOhsHhNLHW16P3oErphjOIJjXwfnQPtG7kzDBeftQ6uGKZMgrk4Ke1olq";
	
		System.out.println(doLCS(a,b));
	}
	public static String doLCS(String a, String b)
	{
		int[][] dp = new int[a.length()+1][b.length()+1];
		
		//Find out where in each sequence the strings are equal
		//and build dp for reference
		for(int i=0; i<a.length(); i++)
		{
			for(int j=0; j<b.length(); j++)
			{
				if(a.charAt(i) == b.charAt(j))
					dp[i+1][j+1] = dp[i][j]+1;
				else
				{
					dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		//StringBuffer is better for building strings
		StringBuffer sb = new StringBuffer();
		int i = a.length();
		int j = b.length();
		//While you still have characters left in both
		while(i!=0 && j!=0)
		{
			//First string mismatch, reduce first string
			if(dp[i][j] == dp[i-1][j])
				i--;
			//Second string mismatch, reduce second string
			else if  (dp[i][j] == dp[i][j-1])
				j--;
			//Both strings equal, add to stringbuilder and reduce both
			else
			{
				sb.append(a.charAt(i-1));
				i--;
				j--;
			}
		}
		//Stringbuilder is built in reverse, undo and tostring
		return sb.reverse().toString();
	}
}
