import java.util.ArrayList;

/**
 * Created by Mitchell Findley on 5/2/16.
 * Student at University of Central Florida
 * Project/Class: HackPack
 */
public class BellmanFord
{
    final public static int MAX = 1000000000;

    public static void main(String[] args)
    {

    }

    public static class Graph
    {
        ArrayList<Vertex> vertices = new ArrayList<>();

        public void setDisToMax()
        {
            for (Vertex v: vertices)
            {
                v.dis = MAX;
            }
        }
    }

    public static class Vertex
    {
        ArrayList<Edge> edges = new ArrayList<>();
        Integer dis = MAX;
    }

    public static class Edge
    {
        public Edge(Vertex dest, int val)
        {
            this.dest = dest;
            this.val = val;
        }
        Vertex dest;
        Integer val;
    }

    BellmanFord(Graph graph, int startIndex)
    {
        graph.setDisToMax();
        graph.vertices.get(startIndex).dis = 0;
        for (int i = 0; i < graph.vertices.size() - 1; i++)
        {
            Vertex v = graph.vertices.get(i);
            for (Edge e : v.edges)
            {
                int dis = graph.vertices.get(i).dis + e.val;
                if (dis < e.dest.dis)
                {
                    e.dest.dis = dis;
                }
            }
        }
    }
}
