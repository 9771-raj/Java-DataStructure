package Arrays_problem;
import java.util.*;
public class assignment {
    private static final double stoping_criteria = 0.000001;
    public static void main(String[] args) {
        findIntersection(3.0, 0.0, 3.0,
                -1.0, -1.0, Math.sqrt(2),
                1.0, 1.0, Math.sqrt(2));
    }
    public static boolean findIntersection(double x0, double y0, double
            r0, double x1, double y1, double r1, double x2, double y2, double r2)
    {
        double a, deltaX, deltaY, d, h, rx, ry;
        double p2X, p2Y;
        deltaX = x1 - x0;
        deltaY = y1 - y0;
        d = Math.sqrt((deltaY*deltaY) + (deltaX*deltaX));
        if (d > (r0 + r1))
        {
            return false;
        }
        if (d < Math.abs(r0 - r1))
        {
            return false;
        }
        a = ((r0*r0) - (r1*r1) + (d*d)) / (2.0 * d) ;
        p2X = x0 + (deltaX * a/d);
        p2Y = y0 + (deltaY * a/d);
        h = Math.sqrt((r0*r0) - (a*a));
        rx = -deltaY * (h/d);
        ry = deltaX * (h/d);
        double interP1X = p2X + rx;
        double interP2X = p2X - rx;
        double interP1Y = p2Y + ry;
        double interP2Y = p2Y - ry;deltaX = interP1X - x2;
        deltaY = interP1Y - y2;
        double d1 = Math.sqrt((deltaY*deltaY) + (deltaX*deltaX));
        deltaX = interP2X - x2;
        deltaY = interP2Y - y2;
        double d2 = Math.sqrt((deltaY*deltaY) + (deltaX*deltaX));
        if(Math.abs(d1 - r2) < stoping_criteria) {
            System.out.println("Intersection point: " + "(" + interP1X + "," +
                    interP1Y + ")");
        }
        else if(Math.abs(d2 - r2) < stoping_criteria) {
            System.out.println("Intersection point:" + "(" + interP2X + "," +
                    interP2Y + ")");
        }
        else {
            System.out.println("No intersection point");
        }
        return true;
    }
}
