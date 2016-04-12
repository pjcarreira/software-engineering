
package ist.es.puzzles;

public class InfiniteLoop {
	
    public static void main(String[] args) {
		// How to initialize 'i' in a way 
	    // that makes it an infinite loop
		int i = Integer.MIN_VALUE;
		
		/*
		 * What is the initialization of 'i' that 
		 * makes this an infinite loop  
		 */
		while (i==-i && i !=0) {
			System.out.println("ciclo");
		}
	}

}
