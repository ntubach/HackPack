public class max_flow
{
    public static void main(String[] args)
    {
        int nodes = 8;
        int source = 0;
        int sink = 7;
        int[][] graph = new int[nodes][nodes];
        // just an example graph, read in this based on the problem
        graph = new int[][]{
                {0,8,7,4,0,0,0,0},
                {0,0,2,0,3,9,0,0},
                {0,0,0,5,0,6,0,0},
                {0,0,0,0,0,7,2,0},
                {0,0,0,0,0,0,0,9},
                {0,0,0,0,3,0,4,5},
                {0,0,0,0,0,0,0,8},
                {0,0,0,0,0,0,0,0}
        };

        // F is a new graph we will augment flow with, using DFS
        // if we need to retain capacity for some reason, make a copy before passing in
        int[][] F = new int[nodes][nodes];
        flow(graph,source,sink,F);

        int tot = 0;
        for (int x=0; x < nodes; x++) {
            tot += F[source][x];
        } // tot is the sum of the flow out of the source node, which is our max (since where else would flow come from)

        System.out.println("max flow is "+tot);
    }

    private static void flow(int[][] C, int s, int t, int[][] F)
    {
        // just setup for our dfs
        boolean[] visited = new boolean[C.length];

        while (dfs(C,F,s,t, visited, Integer.MAX_VALUE)>0) {
            for (int i=0; i < C.length; i++)
                visited[i] = false;
        }
    }

    private static int dfs(int[][] C, int[][] F, int i, int t, boolean[] visited, int min)
    {
        if (i==t) { // if we've successfully traveled to the sink, return the possible flow on this path
            return min;
        }

        visited[i] = true;
        for (int j=0; j < C.length; j++) {
            if (C[i][j] > 0 && !visited[j]) {

                int v = dfs(C, F, j, t, visited, Math.min(min, C[i][j]));

                // if we get to the end of a DFS (returns at the sink) and v > 0 then the flow can be augmented
                // subtract v from capacity (original graph)
                // add v to our new flow graph
                // future DFS recursions will use the new capacity data and act accordingly
                if (v > 0) {
                    C[i][j] = C[i][j]-v;
                    F[i][j] = F[i][j]+v;
                    C[j][i] = C[j][i]+v;
                    F[j][i] = F[j][i]-v;
                    return v;
                }
            }
        }

        return 0;
    }
}