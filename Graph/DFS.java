import java.util.*;

public class DFS 
{
	public static void main (String[] args)
	{
		//Arraylist of arraylists for hold the graph
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		int size = 10;
		for(int i=0; i<size; i++)
		{
			//Add new arraylist for size
			adj.add(new ArrayList<Integer>());
		}
		//Create the graph
		adj.get(0).add(4);
		adj.get(0).add(7);
		adj.get(0).add(8);
		
		adj.get(1).add(5);
		adj.get(1).add(7);
		
		adj.get(2).add(3);
		
		adj.get(3).add(2);
		adj.get(3).add(8);
		
		adj.get(4).add(0);
		adj.get(4).add(9);
		
		adj.get(5).add(1);
		adj.get(5).add(6);		
		adj.get(5).add(9);
		
		adj.get(6).add(5);
		
		adj.get(7).add(0);
		adj.get(7).add(1);
		
		adj.get(8).add(0);
		adj.get(8).add(3);
		
		adj.get(9).add(4);
		adj.get(9).add(5);
		
		int startNode = 0;
		//Call dfs
		doDFS(adj, startNode);
	}
	
	public static void doDFS(ArrayList<ArrayList<Integer>> adj, int start)
	{
		boolean[] visited = new boolean [adj.size()];
		Stack<Integer> track = new Stack<Integer>();
		track.push(start);
		
		while( !track.isEmpty() )
		{
			int visit = track.pop();
			if( !visited[visit] )
			{
				visited[visit] = true;
				System.out.print(visit + " ");
				
				Stack<Integer> track2 = new Stack<Integer>();
				for (int i : adj.get(visit))
				{
					if( !visited[i] )
					{
						track2.push(i);
					}
				}
				while ( !track2.isEmpty())
				{
					track.push(track2.pop());
				}
			}
		}
	}
}