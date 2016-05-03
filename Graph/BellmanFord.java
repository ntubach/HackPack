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
		
		v0.edges.add(new Edge(v4,1));
		v0.edges.add(new Edge(v7,8));
		v0.edges.add(new Edge(v8,6));
		g.vertices.add(v0);
		
		v1.edges.add(new Edge(v5,44));
		v1.edges.add(new Edge(v7,2));
		g.vertices.add(v1);
		
		v2.edges.add(new Edge(v3,4));
		g.vertices.add(v2);
		
		v3.edges.add(new Edge(v2,7));
		v3.edges.add(new Edge(v8,9));
		g.vertices.add(v3);
		
		v4.edges.add(new Edge(v0,10));
		v4.edges.add(new Edge(v9,5));
		g.vertices.add(v4);
		
		v5.edges.add(new Edge(v1,6));
		v5.edges.add(new Edge(v6,1));
		v5.edges.add(new Edge(v9,20));
		g.vertices.add(v5);
		
		v6.edges.add(new Edge(v5,30));
		g.vertices.add(v6);
		
		v7.edges.add(new Edge(v0,2));
		v7.edges.add(new Edge(v1,5));
		g.vertices.add(v7);
		
		v8.edges.add(new Edge(v0,3));
		v8.edges.add(new Edge(v3,2));
		g.vertices.add(v8);
		
		v9.edges.add(new Edge(v4,21));
		v9.edges.add(new Edge(v5,1));
		g.vertices.add(v9);
		BellmanFord bf = new BellmanFord(g, 0);
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
        int val;
        public Vertex(int val)
        {
        	this.val = val;
        }
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
                int dis = v.dis + e.val;
                if (dis < e.dest.dis)
                {
                    e.dest.dis = dis;                    
                }
            }            
        }

        for(Vertex v : graph.vertices)
        {
        	System.out.println(v.val+": "+v.dis);
        }
    }
}
