public class line_plane_intersect_3D {

	public static void main(String[] args) {
		//Points describing the line
		int x1=1, y1=1, z1=1;
		int x2=8, y2=-7, z2=1;
		//Points describing the plane
		int x3=3, y3=9, z3=0;
		int x4=-1, y4=3, z4=0;
		int x5=4, y5=5, z5=0;
		//No intersection with this co-ords
		intersect(x1,y1,z1,x2,y2,z2,x3,y3,z3,x4,y4,z4,x5,y5,z5);
	}
	public static void intersect (int x1, int y1, int z1, int x2, int y2, int z2, int x3, int y3, int z3, int x4, int y4, int z4, int x5, int y5, int z5)
	{
		int xlv = x1 - x2;
		int ylv = y1 - y2;
		int zlv = z1 - z2; // direction vector of a line
				
		int a = x3 - x4;
		int b = y3 - y4;
		int c = z3 - z4;
		int d = x3 - x5;
		int e = y3 - y5;
		int f = z3 - z5; // cross product
				
		int xp = (b*f) - (e*c);
		int yp = (c*d) - (f*a);
		int zp = (a*e) - (d*b); // cross product result			
			
		int Dp = (xp*x3) + (yp*y3) + (zp*z3); //
				
		double rhs = Dp - xp*x1 - yp*y1 - zp*z1;
		int coeff = xp*xlv + yp*ylv + zp*zlv;
		
		if(coeff == 0){
			if( ((xp*x1)+(yp*y1)+(zp*z1)) == Dp){
				System.out.println("The line lies on the plane.");
			}
			else{
				System.out.println("There is no intersection.");
			}
		}
		else{
			double lam = rhs/coeff;
					
			double xans = x1 + ((double)Math.round(lam*xlv*10))/10;
			double yans = y1 + ((double)Math.round(lam*ylv*10))/10;
			double zans = z1 + ((double)Math.round(lam*zlv*10))/10;
			System.out.println("The intersection is the point ("+xans+", "+yans+", "+zans+").");
		}			
	}
}

