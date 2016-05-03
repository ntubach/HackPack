import java.util.*;
//Prim's algorithm
public class prims 
{
	public static void main(String[] args)
	{		
		int n = 5;
		//This code uses 999 instead of 0s
		int[][] matrix = {{999, 2, 999, 6, 999},
                		  {2, 999, 3, 8, 5},
                		  {999, 3, 999, 999, 7},
                		  {6, 8, 999, 999, 9},
                		  {999, 5, 7, 9, 999},
               			 };
		doPrims(matrix,n);
	}
	public static void doPrims(int[][] matrix, int n)
	{
		int[] visited = new int[n];
		for(int i = 0; i < n; i++)	
			visited[i] = 0;					
		
		int min = 999;
		int u = 0, v = 0;
		int total = 0;	
		visited[0] = 1;		
		for(int counter = 0; counter < (n-1) ; counter++){
			
			min = 999;			
			for(int i = 0; i < n; i++){			
			if(visited[i]==1){			
				for(int j = 0; j < n; j++){				
					if(visited[j]==0){						
						if(min > matrix[i][j]){						
							min = matrix[i][j];
							u = i;
							v = j;							
						}						
					}					
				}				
			}
			
			}
			visited[v] = 1;
			total += min;
			matrix[u][v] = matrix[u][v] = 999; 
			System.out.println("Edge connected: "+u+" -> "+v+" : "+min);				
		}
		System.out.println("The total weight of the spanning tree is "+ total);	
	}
}
