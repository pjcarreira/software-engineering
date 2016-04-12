package ist.es.equals;

import java.util.HashSet;
import java.util.Set;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    public static void main(String[] args) {
        Set<Point> points = new HashSet<Point>();

        points.add(new Point(10, 20));

        final Point p = new Point(10, 20);
        if (points.contains(p)) {
            System.out.println("p does exist in the set");
        } else {
            System.out.println("p does not exist in the set");
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    @Override
    public int hashCode() {
        int result;
        result = 17 + 31 * x + 31 * y;
        return result;
    }
}
