package faculdade;

import ist.es.puzzles.MathHelper;
import junit.framework.TestCase;

public class TestMathHelper extends TestCase {
	
	public void testIsOdd() {
		assertTrue(MathHelper.isOdd(1));
		
		assertFalse(MathHelper.isOdd(2));
		assertFalse(MathHelper.isOdd(0));
		
		assertTrue(MathHelper.isOdd(-1));
		assertFalse(MathHelper.isOdd(Integer.MIN_VALUE));	
	}
}
