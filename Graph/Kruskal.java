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
    	Graph g = new Graph();
		Vertex v0 = new Vertex(0);
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		Vertex v7 = new Vertex(7);
		Vertex v8 = new Vertex(8);
		Vertex v9 = new Vertex(9);
		Edge[] e = new Edge[10];
		
		e[0] = (new Edge(v0,v4,1));
		e[0] = (new Edge(v0,v7,8));
		e[0] = (new Edge(v0,v8,6));
		g.vertices.add(v0);
		
		e[1] = (new Edge(v1,v5,44));
		e[1] = (new Edge(v1,v7,2));
		g.vertices.add(v1);
		
		e[2] = (new Edge(v2,v3,4));
		g.vertices.add(v2);
		
		e[3] = (new Edge(v3,v2,7));
		e[3] = (new Edge(v3,v8,9));
		g.vertices.add(v3);
		
		e[4] = (new Edge(v4,v0,10));
		e[4] = (new Edge(v4,v9,5));
		g.vertices.add(v4);
		
		e[5] = (new Edge(v5,v1,6));
		e[5] = (new Edge(v5,v6,1));
		e[5] = (new Edge(v5,v9,20));
		g.vertices.add(v5);
		
		e[6] = (new Edge(v6,v5,30));
		g.vertices.add(v6);
		
		e[7] = (new Edge(v7,v0,2));
		e[7] = (new Edge(v7,v1,5));
		g.vertices.add(v7);
		
		e[8] = (new Edge(v8,v0,3));
		e[8] = (new Edge(v8,v3,2));
		g.vertices.add(v8);
		
		e[9] = (new Edge(v9,v4,21));
		e[9] = (new Edge(v9,v5,1));
		g.vertices.add(v9);
		
		Kruskal k = new Kruskal(e);
    }

    public static class Graph
    {
        ArrayList<Vertex> vertices = new ArrayList<>();
    }

    public static class Vertex
    {
        ArrayList<Edge> edges = new ArrayList<>();
        int val;
        public Vertex(int val)
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

    Kruskal(Edge[] edges)
    {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        int i = 1;
        for (Edge e : edges)
        {
            q.add(e);
        }

        while (!q.isEmpty())
        {
            Edge e = q.poll();

            if (contains(e.origin, e.dest)) continue;

            e.origin.edges.add(e);
            System.out.println((i++)+": "+e.origin.val+" "+e.dest.val);
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
