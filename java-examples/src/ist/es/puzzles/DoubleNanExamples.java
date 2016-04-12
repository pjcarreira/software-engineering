package ist.es.puzzles;

public class DoubleNanExamples {

    /**
     * Displays how two doubles compare to each other.<code>x</code> compares to
     * <code>y</code>.
     * <p>
     * This method implementation is flawed and, for some combinations of parameters the
     * <code>else</code> part of the method implementation get executed. What is it?
     * 
     * @param x the first double
     * @param y the second double
     */
    static void compareDoubles(double x, double y) {
        if (x > y) {
            System.out.println("X greater thant Y");
        } else if (x < y) {
            System.out.println("X smaller than Y");
        } else if (x == y) {
            System.out.println("X equals Y");
        } else {
            // This message actually get printed. But how?
            System.out.println("Never gets here");
        }
    }

    /**
     * Tests if a double is NaN
     * 
     * @param d the double to be tested
     * @return <code>false
     */
    static boolean isNaN(double d) {
        return d == Double.NaN;
    }

    public static void main(String[] args) {
        compareDoubles(1.0, 0.0 / 0.0);
        compareDoubles(1.0, Double.NaN);
    }
}
