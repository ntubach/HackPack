import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Mitchell Findley on 5/2/16.
 * Edited by Niko Tubach on 5/2/16.
 * Student at University of Central Florida
 * Project/Class: HackPack
 */
public class BFS
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
		
		v0.edges.add(new Edge(v4));
		v0.edges.add(new Edge(v7));
		v0.edges.add(new Edge(v8));
		g.vertices.add(v0);
		
		v1.edges.add(new Edge(v5));
		v1.edges.add(new Edge(v7));
		g.vertices.add(v1);
		
		v2.edges.add(new Edge(v3));
		g.vertices.add(v2);
		
		v3.edges.add(new Edge(v2));
		v3.edges.add(new Edge(v8));
		g.vertices.add(v3);
		
		v4.edges.add(new Edge(v0));
		v4.edges.add(new Edge(v9));
		g.vertices.add(v4);
		
		v5.edges.add(new Edge(v1));
		v5.edges.add(new Edge(v6));
		v5.edges.add(new Edge(v9));
		g.vertices.add(v5);
		
		v6.edges.add(new Edge(v5));
		g.vertices.add(v6);
		
		v7.edges.add(new Edge(v0));
		v7.edges.add(new Edge(v1));
		g.vertices.add(v7);
		
		v8.edges.add(new Edge(v0));
		v8.edges.add(new Edge(v3));
		g.vertices.add(v8);
		
		v9.edges.add(new Edge(v4));
		v9.edges.add(new Edge(v5));
		g.vertices.add(v9);
		BFS bfs = new BFS(g, 0);
		
		
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
        int val;
        boolean visited = false;
        
        public Vertex (int val)
        {
        	this.val = val;
        }
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

            if (v.visited) 
            	continue;

            v.visited = true;
            System.out.print(v.val+" ");
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
