import java.util.*;

public class walking {

    // Everyone has access to these.
    static int oo = (int) 1e9;
    static int n;
    static ArrayList<Edge>[] g;

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

        int C = sc.nextInt(); // number of test cases

        for(int i = 0; i < C; i++){

            int N = sc.nextInt(); // number of locations in the neighborhood
            n = N;
            g = new ArrayList[n];

            // read in elevation data
            int[] elevation = new int[N];
            for(int j = 0; j < N; j++){
                int currElevation = sc.nextInt();
                elevation[j] = currElevation;
                g[j] = new ArrayList<Edge>();
            }

            int M = sc.nextInt(); // number of paths (edges to add)
            String str = sc.nextLine();
            for(int j = 0; j < M; j++){
                str = sc.nextLine();
                StringTokenizer st = new StringTokenizer(str);
                int start = Integer.parseInt(st.nextToken("(), "))-1;
                int end = Integer.parseInt(st.nextToken("(), "))-1;

                // edges are undirected and weight is the difference in elevation (up or down doesn't matter)
                g[start].add(new Edge(end, Math.abs(elevation[start] - elevation[end])));
                g[end].add(new Edge(start, Math.abs(elevation[start] - elevation[end])));
            }

            int K = sc.nextInt(); // number of locations to visit
            int sum = 0;
            int last = 0;
            for(int j = 0; j < K; j++){ // step through each target destination in order
                int next = sc.nextInt()-1;
                int minWork = dijkstras(last,next); // get the min work from where we are to the next dest
                last = next;
                sum += minWork;
            }

            System.out.println("The least amount of work on trip "+(i+1)+" is: "+sum);
        }
    }

    public static int dijkstras(int s, int d) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

        pq.add(new Edge(s, 0)); // add an edge from s to itself to have a place to start

        while (!pq.isEmpty()) {
            Edge at = pq.poll(); // try the shortest edge

            if (visited[at.e]) continue;
            visited[at.e] = true;

            // We made it, return the distance.
            if (at.e == d) return at.w;

            // We didn't make it, enqueue all the neighboring edges and try the next shortest one.
            for (Edge adj : g[at.e])
                if (!visited[adj.e]) pq.add(new Edge(adj.e, adj.w + at.w));
        }
        return oo;
    }

    // Stores where an edge is going to and its weight, compareTo added for priority queue.
    static class Edge implements Comparable<Edge> {
        int e, w;

        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }

        public int compareTo(Edge o) {
            return w - o.w;
        }
    }

}
