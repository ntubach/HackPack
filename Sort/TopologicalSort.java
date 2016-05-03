import java.util.HashSet;
import java.util.*;

public class TopologicalSort
{
	public static int[] ordering;
	public static boolean[] used;
	public static int n;
	public static vertex[] useList;
	
	/*
	 * Code for dueling philosophers, utilizes topological sort
	 * Inputs of:
5 4
1 5
5 2
3 2
4 3

5 4
3 1
4 2
1 5
5 4

2 2
1 2
2 1
	 *Outputs:
2
1
0
	 *Respectively
	 */

	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		//System.out.print("n: "+n+"\t");
		int m = in.nextInt();
		//System.out.println("m: "+m);
	
		while (n != 0) 
		{
			// Set up ordering matrix.
			vertex[] List = new vertex[n];
			for (int i=0; i<n; i++)
				List[i] = new vertex();
	
			// Put in edges in both the appropriate in and out degree lists.
			for (int i=0; i<m; i++) 
			{
				int d = in.nextInt();
				int u = in.nextInt();
				List[d-1].out.add(u-1);
				List[u-1].in.add(d-1);
			}
	
			// Run a topological sort.
			System.out.println(TopoSort(List));
	
			// Get next case.
			n = in.nextInt();
			//System.out.print("n: "+n+"\t");
			m = in.nextInt();
			//System.out.println("m: "+m);
		}
	}
	public static int TopoSort(vertex[] List) 
	{
		useList = List;
		n = List.length;
		used = new boolean[n];
		ordering = new int[n];
		
		// Fill spots forward.
		int current = 0;
		int value = 1;
		while (current < n) 
		{
			int count = 0;
			int[] remove = new int[n];
			for (int i=0; i<n; i++)
				if (!used[i] && useList[i].in.size() == 0)
					remove[count++] = i;

			// If no vertices have in degree 0 at any iteration, algorithm fails.
			if (count == 0) 
				return 0;			

			// If you have more than one count, you will have more than one comparisons
			if (count > 1) 
				value = 2;

			// Delete vertices
			for (int i=0; i<count; i++) 
			{
				// Put next item in list
				ordering[current] = remove[i];
				current++;
				used[remove[i]] = true;

				// Remove edges, leaves i
				for (Integer e: useList[remove[i]].out)
					useList[e].in.remove(remove[i]);
			}
		}

		return value;
	}


}
class vertex
{
	public HashSet<Integer> in;
	public HashSet<Integer> out;

	public vertex() 
	{
		in = new HashSet<Integer>();
		out = new HashSet<Integer>();
	}
}	
