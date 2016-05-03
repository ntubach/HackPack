import java.awt.geom.Line2D;

public class line_line_intersection_2D 
{
	static public void main (String[] args)
	{
		//Line1
		int x1=2,y1=809,x2=5,y2=-12;
		//Line2
		int x3=5,y3=64,x4=-777,y4=0;
		
		System.out.println(intersect(x1,y1,x2,y2,x3,y3,x4,y4));
	}
	public static boolean intersect(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4)
	{
		return Line2D.linesIntersect(x1,y1,x2,y2,x3,y3,x4,y4);
	}
}