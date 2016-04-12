package ist.es.puzzles;

/**
 * Why is the compiler complaining about 2147483648?
 * 
 * Numeric constants are Integers by default.
 */
public class IntegerByDefault {
    
    /*
     * Compiles all right
     */
	long i = -2147483648;    
	
	/*
	 * Compiler error 
	 */
	long j = -(2147483648);   
	
	/*
	 * Another error
	 */
	long k = 2147483648;
	
	/*
	 * No error
	 */
	long l = 2147483648L;
}
