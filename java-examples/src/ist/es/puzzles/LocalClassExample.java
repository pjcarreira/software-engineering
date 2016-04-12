package ist.es.puzzles;

public class LocalClassExample {
	static final Integer i1 = 1;
	final Integer i2 = 2;
	Integer i3 = 3;

	public void testMe() {
		final Integer i4 = 4;
		Integer i5 = 5;
		
		class Here {
			final Integer i6 = 6;
			Integer i7 = 7;

			Here() {
				System.out.println(i1 + i2 + i3 + i4 + i5 + i6 + i7);
			}
		};
		
		
	}
}
