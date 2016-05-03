import java.util.Scanner;

//Rectangle inside circle + resize to fit alongside small circle
public class mice 
{
	/*
	 * Contest code for mice
	 * Input of:
1
10000 2763 -7235 0
	 *Outputs:
OBSTRUCTION! 159998378.63	 
	*/
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int cases=1; cases<=n; cases++)
		{
			System.out.println("Pond #"+cases+":");
			int rP = in.nextInt();
			int rH = in.nextInt();
			int xH = in.nextInt();
			int yH = in.nextInt();

			double area = (2*rP/Math.sqrt(5.0d))*(4*rP/Math.sqrt(5.0d));
			double x = Math.sqrt(area/2);
			double ray = Math.sqrt(xH*xH + yH*yH) - rH;

			if(ray >= rP/(Math.sqrt(5)))
				System.out.printf("ICE CLEAR!!! %.2f%n",area);
			else
			{	
				//I hate quadratics
				double temp = (((2*ray) + Math.sqrt((4*ray*ray)-(8*(ray*ray-rP*rP))))/4);
				System.out.printf("OBSTRUCTION! %.2f%n", 2*temp*temp);
			}
			System.out.println();
		}
	}
}