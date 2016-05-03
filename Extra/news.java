import java.util.*;
/*
 * Contest code for news
 * Input of:
1
50
0 0 1 2 4 5 6 0 8 1 7 7 9 5 4 9 0 13 2 12 15 21 12 2 8 22 3 9 5 29 28 7 9 8 2 13 35 12 24 34 3 31 25 35 26 22 23 0 28
 * Outputs:
9
 */
public class news 
{
	public static void main (String[] args)
	{
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);
		int cases = stdin.nextInt();
		List<Integer> hold = new LinkedList<Integer>();
		
		for (int count=0; count<cases; count++)
		{
			int numEmploy = stdin.nextInt();
			hold.add(-1);
			for(int i=1; i<numEmploy; i++)
			{			
				int id = stdin.nextInt();
				hold.add(id);
			}		
			System.out.println(sizet(0, hold));
			hold.clear();
		}
	}
	public static int sizet (int val, List<Integer> hold)
	{
		List <Integer> temp = new LinkedList<Integer>();
		
		for(int i=val+1; i<hold.size(); i++)
			if(hold.get(i) == val)
				temp.add(sizet(i, hold));
		
		Collections.sort(temp, Collections.reverseOrder());
		
		int result=0;
		for (int i=0; i<temp.size(); i++)
		{
			result = Math.max(result, i+1+temp.get(i));
		}
		return result;
	}
}