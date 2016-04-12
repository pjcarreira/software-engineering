
package ist.es.puzzles;

/**
 * This example silently inserts a cast to short actually printing (short)123456.
 */
public class SilentCastOperator {
	public static void main(String[] args) {
		short x = 0;
		int i = 123456;
		
		x += i;
		

		
		System.out.println(x); // O que  que eu imprimo e porqu�?
	}
}
