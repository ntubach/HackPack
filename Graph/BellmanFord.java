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
        Vertex[] vertices = new Vertex[10];
        vertices[0] = new Vertex(0);
        vertices[1] = new Vertex(1);
        vertices[2] = new Vertex(2);
        vertices[3] = new Vertex(3);
        vertices[4] = new Vertex(4);
        vertices[5] = new Vertex(5);
        vertices[6] = new Vertex(6);
        vertices[7] = new Vertex(7);
        vertices[8] = new Vertex(8);
        vertices[9] = new Vertex(9);
        Edge[] e = new Edge[20];

        e[0] = (new Edge(vertices[0],vertices[4],1));
        e[1] = (new Edge(vertices[0],vertices[7],8));
        e[2] = (new Edge(vertices[0],vertices[8],6));

        e[3] = (new Edge(vertices[1],vertices[5],44));
        e[4] = (new Edge(vertices[1],vertices[7],2));

        e[5] = (new Edge(vertices[2],vertices[3],4));

        e[6] = (new Edge(vertices[3],vertices[2],7));
        e[7] = (new Edge(vertices[3],vertices[8],9));

        e[8] = (new Edge(vertices[4],vertices[0],10));
        e[9] = (new Edge(vertices[4],vertices[9],5));

        e[10] = (new Edge(vertices[5],vertices[1],6));
        e[11] = (new Edge(vertices[5],vertices[6],1));
        e[12] = (new Edge(vertices[5],vertices[9],20));

        e[13] = (new Edge(vertices[6],vertices[5],30));

        e[14] = (new Edge(vertices[7],vertices[0],2));
        e[15] = (new Edge(vertices[7],vertices[1],5));

        e[16] = (new Edge(vertices[8],vertices[0],3));
        e[17] = (new Edge(vertices[8],vertices[3],2));

        e[18] = (new Edge(vertices[9],vertices[4],21));
        e[19] = (new Edge(vertices[9],vertices[5],1));

        BellmanFord bf = new BellmanFord(vertices, 0, e);
    }

    public static class Graph
    {
        ArrayList<Vertex> vertices = new ArrayList<>();

        public void setDisToMax()
        {
            for (Vertex v : vertices)
            {
                v.dis = MAX;
            }
        }
    }

    public static class Vertex
    {
        ArrayList<Edge> edges = new ArrayList<>();
        int val;
        int dis = MAX;
        Vertex(int val)
        {
            this.val = val;
        }
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

    BellmanFord(Vertex[] vertices, int startIndex, Edge[] edges)
    {
        for (Vertex v : vertices)
        {
            v.dis = MAX;
        }

        vertices[startIndex].dis = 0;

        for (int i = 0; i < vertices.length - 1; i++)
        {
            for (int j =0; j < edges.length; j++)
            {
                int dis = edges[j].origin.dis + edges[j].val;

                edges[j].dest.dis = dis < edges[j].dest.dis ? dis : edges[j].dest.dis;
            }
        }

        for(Vertex v : vertices)
        {
            System.out.println(v.val +": " + v.dis);
        }
    }
}
