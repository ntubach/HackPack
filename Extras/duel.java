import java.util.*;

/**
 * Created by Mitchell Findley on 2/12/16.
 * Student at University of Central Florida
 * Project/Class: COP4516IC
 */
public class duel
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        while (n != 0 && m != 0)
        {
            int possibleArrangments = 1;
            Vertex[] essays = new Vertex[n];
            Edge[] terms = new Edge[m];
            boolean[] targets = new boolean[n];
            LinkedList<Vertex> q = new LinkedList<>();

            for (int i = 0; i < essays.length; i++)
            {
                essays[i] = new Vertex(i);
            }

            for (int i = 0; i < m; i++)
            {
                int d = in.nextInt() - 1;
                int u = in.nextInt() - 1;
                targets[u] = true;
                terms[i] = new Edge(essays[d], essays[u], 0);
                essays[d].addEdge(terms[i]);
                essays[u].needs++;
            }

            for (int i = 0; i < targets.length; i++)
            {
                if (!targets[i])
                {
                    q.add(essays[i]);
                }
            }

            possibleArrangments = q.size();

            for (int i = 0; i < essays.length; i++)
            {
                if (q.isEmpty())
                {
                    possibleArrangments = 0;
                    break;
                }
                Vertex essay = q.poll();
                for (Edge edge : essay.edges)
                {
                    edge.t.needs--;
                    if (edge.t.needs == 0)
                    {
                        q.add(edge.t);
                    }
                }
            }

            System.out.println((possibleArrangments > 0 ?
                    possibleArrangments > 2 ? 2 : possibleArrangments : 0));

            n = in.nextInt();
            m = in.nextInt();
        }
    }

    public static class Edge implements Comparable<Edge>
    {
        public Vertex v;
        public Vertex t;
        public int w;

        public Edge(Vertex v, Vertex t, int w)
        {
            this.v = v;
            this.t = t;
            this.w = w;
        }

        @Override
        public int compareTo(Edge edge)
        {
            return this.w - edge.w;
        }
    }



    public static class Vertex
    {
        public boolean used = false;
        public int needs = 0;
        int id;
        //HashMap<Integer, Edge> edges = new HashMap<>();
        ArrayList<Edge> edges = new ArrayList<>();

        public Vertex(int id)
        {
            this.id = id;
        }

        public void addEdge(Edge edge)
        {
            this.edges.add(edge);
        }

        public void addEdge(Vertex target)
        {
            this.edges.add(new Edge(this, target, 0));
        }
    }
}
