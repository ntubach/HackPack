import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Mitchell Findley on 5/2/16.
 * Student at University of Central Florida
 * Project/Class: HackPack
 */
public class BFS
{
    public static void main(String[] args)
    {

    }

    public static class Graph
    {
        ArrayList<Vertex> vertices = new ArrayList<>();

        public void setVisitedToFalse()
        {
            for (Vertex v: vertices)
            {
                v.visited = false;
            }
        }
    }

    public static class Vertex
    {
        ArrayList<Edge> edges = new ArrayList<>();
        boolean visited = false;
    }

    public static class Edge
    {
        public Edge(Vertex dest)
        {
            this.dest = dest;
        }

        public Edge(Vertex dest, int val)
        {
            this(dest);
            this.val = val;
        }
        Vertex dest;
        Integer val;
    }

    BFS(Graph graph, int startIndex)
    {
        graph.setVisitedToFalse();

        LinkedList<Vertex> q = new LinkedList<>();
        q.add(graph.vertices.get(startIndex));

        while (!q.isEmpty())
        {
            Vertex v = q.poll();

            if (v.visited) continue;

            v.visited = true;
            for (Edge e : v.edges)
            {
                if(!e.dest.visited)
                {
                    q.add(e.dest);
                }
            }
        }
    }
}
