public class line_line_intersection_3D 
{
	public static void main(String[] args) 
	{
		//Points describing the line
		int x1=1, y1=1, z1=1;
		int x2=8, y2=1, z2=1;
		//Points describing the plane
		int x3=3, y3=9, z3=0;
		int x4=-1, y4=9, z4=3;
		//No intersection with this co-ords
		System.out.println(intersect(x1,y1,z1,x2,y2,z2,x3,y3,z3,x4,y4,z4));
	}
	public static boolean intersect (int x1, int y1, int z1, int x2, int y2, int z2, int x3, int y3, int z3, int x4, int y4, int z4)
	{
		//Direction vector of line1
		int a = x1 - x2;
		int b = y1 - y2;
		int c = z1 - z2; 
		
		//Direction vector of line2
		int d = x3 - x4;
		int e = y3 - y4;
		int f = z3 - z4; 
		
		//Check if vectors are parallel before continuing
		double v1M = Math.sqrt(a*a + b*b + c*c);
		double v2M = Math.sqrt(d*d + e*e + f*f);
		double lhs = Math.abs(v1M) * Math.abs(v2M);
		double rhs = Math.abs(a*d + b*e + c*f);
		
		if(lhs-rhs <1e-8)
			return false;

		//Helper for equation, point1+2 vector
		int px = x3-x1;
		int py = y3-y1;
		int pz = z3-z1;
				
		// Cross product of vectors				
		int xp = (b*f) - (e*c);
		int yp = (c*d) - (f*a);
		int zp = (a*e) - (d*b); 
		
		//Cross product of new point with vector2
		int xppx = (py*f) - (e*pz);
		int yppy = (pz*d) - (f*px);
		int zppz = (px*e) - (d*py);
		
		//If LHS is a zero vector, no intersection
		if(xp != 0 || yp != 0 || zp != 0)
		{
			//Magnitude multiplication of new Vectors
			double ls = Math.abs(Math.sqrt(px*px+py*py+pz*pz))*
					Math.abs(Math.sqrt(xp*xp+yp*yp+zp*zp));
			//DP of new Vectors
			double rs = Math.abs(px*xppx + py*yppy + pz*zppz);
			//Check if new vectors are parallel
			if(ls-rs <1e-8)
				return false;
			//INTERSECTION!!!!
			return true;
		}
		return false;
	}
}