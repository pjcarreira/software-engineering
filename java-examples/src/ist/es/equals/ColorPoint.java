package ist.es.equals;

import java.awt.Color;

/**
 * Broken equality test. ColorPoint does not honor transitivity. In reality, it is not
 * possible to get this behavior correct as long as we can instantiate a superclass.
 */
public class ColorPoint extends
        Point {

    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;

        // If o is a normal Point, do a color-blind comparison
        if (!(o instanceof ColorPoint))
            return o.equals(this);

        // o is a ColorPoint; do a full comparison
        return super.equals(o) && ((ColorPoint) o).color == color;
    }


    public static void main(String[] args) {
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);

        Point p2 = new Point(1, 2);

        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);

        System.out.println(p1.equals(p2)); // true
        System.out.println(p2.equals(p3)); // true

        System.out.println(p1.equals(p3)); // false
    }
}
