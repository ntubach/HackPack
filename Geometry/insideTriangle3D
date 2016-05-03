public class insideTriangle3D {

    public static void main(String[] args) {
        double x3 = 0;
        double y3 = 0;
        double z3 = 0;

        double x4 = 0;
        double y4 = 1;
        double z4 = 0;

        double x5 = 1;
        double y5 = 0;
        double z5 = 0; // plane

        // this code assumes the point lies on the plane, likely from line/plane intersection result
        // although now that I think about it, if it's not on the plane it'll give a no answer anyway
        double xans = 0.25;
        double yans = 0.25;
        double zans = 0;

    /* Calculate area of triangle ABC */
        double A = area(x3, y3, z3, x4, y4, z4, x5, y5, z5);

    /* Calculate area of triangle PBC */
        double A1 = area(xans, yans, zans, x4, y4, z4, x5, y5, z5);

    /* Calculate area of triangle PAC */
        double A2 = area(x3, y3, z3, xans, yans, zans, x5, y5, z5);

    /* Calculate area of triangle PAB */
        double A3 = area(x3, y3, z3, x4, y4, z4, xans, yans, zans);

    /* Check if sum of A1, A2 and A3 is same as A */
        double tolerance = 0.000001;
        if(Math.abs(A-(A1+A2+A3))<tolerance)
            System.out.println("Point Inside Triangle");
        else
            System.out.println("Point Not Inside Triangle");
    }

    public static double area (double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3)
        {
        double a = x2 - x1;
        double b = y2 - y1;
        double c = z2 - z1;
        double d = x3 - x1;
        double e = y3 - y1;
        double f = z3 - z1; // cross product

        double xp = (b*f) - (e*c);
        double yp = (c*d) - (f*a);
        double zp = (a*e) - (d*b); // cross product result

        return 0.5 * Math.sqrt(Math.pow(xp, 2) + Math.pow(yp, 2) + Math.pow(zp, 2));
        }
}
