import java.util.*;

public class GCD-LCM
{
	public static void main (String[] args)
	{
		int[] arry = {1,2,3,4,5,6,7,8,9,10};		
		doLCM(arry);
	}
	public static int doGCD(int a, int b)
	{
		return b == 0 ? a : doGCD(b, a%b);
	}
	public static int doLCM(int[] arry)
	{
		int LCM = 1;
		for (int i=0; i<arry.length(); i++)
		{
			LCM += (LCM*arry[i])/doGCD(LCM, arry[i]);
		}
		return LCM;
	}
}