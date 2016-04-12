package ist.es.puzzles;

/**
 * A utility class for mathematics. 
 * 
 * Something can go wrong with the method {@link #isOdd(int)}. What is it?
 */
public final class MathHelper {

	/**
	 * Prevent instantiation. This is a helper class.
	 */
	private MathHelper() {
	}

	/**
	 * Checks if a given number is odd
	 * 
	 * @param i the number to be checked
	 * @return <code>true</code> if the number is odd; returns
	 *         <code>false</code> otherwise.
	 */
	public static boolean isOdd(int i) {
		return i % 2 == 1;
	}
	
	public static boolean isOdd2(int i) {
		return i % 2 != 0;
	}

	public static boolean isOdd3(int i) {
		return (i & 1) != 0;
	}

}
