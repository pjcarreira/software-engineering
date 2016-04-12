package ist.es.puzzles;

/**
 * Why does the cycle below fail to encounter the byte?
 */
public class FindByte {
	
    public static void main(String[] args) {		
		for(byte b = Byte.MIN_VALUE; b<Byte.MAX_VALUE; b++) {
			if (b == 0x90) {
				System.out.println("Encontrei-te!");
			}
		}
	}
    
}
