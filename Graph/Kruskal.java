import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by Mitchell Findley on 5/2/16.
 * Student at University of Central Florida
 * Project/Class: HackPack
 */
public class Kruskal
{

    public static void main(String[] args)
    {

    }

    public static class Graph
    {
        ArrayList<Vertex> vertices = new ArrayList<>();
    }

    public static class Vertex
    {
        ArrayList<Edge> edges = new ArrayList<>();
    }

    public static class Edge implements Comparable<Edge>
    {
        public Edge(Vertex origin, Vertex dest, int val)
        {
            this.origin = origin;
            this.dest = dest;
            this.val = val;
        }
        Vertex origin;
        Vertex dest;
        Integer val;

        @Override
        public int compareTo(Edge edge)
        {
            return val - edge.val;
        }
    }

    Kruskal(Edge[] edges)
    {
        PriorityQueue<Edge> q = new PriorityQueue<>();

        for (Edge e : edges)
        {
            q.add(e);
        }

        while (!q.isEmpty())
        {
            Edge e = q.poll();

            if (contains(e.origin, e.dest)) continue;

            e.origin.edges.add(e);
        }
    }

    public static boolean contains(Vertex start, Vertex find)
    {
        LinkedList<Vertex> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty())
        {
            Vertex v = q.poll();
            if (v == find) return true;
            for (Edge e : v.edges)
            {
                q.add(e.dest);
            }
        }
        return false;
    }
}
