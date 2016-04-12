package ist.es.puzzles.misleadingexception;

/**
 * Misleading exception.
 * 
 * What does this program print?
 */
public class Test {
	private Test testInstance = new Test();
	
	public Test() throws Exception {
		throw new Exception("Daqui n‹o saio");
	}
	
	public static void main(String[] args) {
		try {
			Test t = new Test();
			System.out.println("Surpresa");
		} catch(Exception e) {
			System.out.println("Ahh poiz'e!");
		} catch(Error e2) {
			System.out.println("Isso Ž que era bom");
		}
	}
}

