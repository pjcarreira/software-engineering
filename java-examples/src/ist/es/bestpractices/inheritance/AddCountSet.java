package ist.es.bestpractices.inheritance;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/** 
 * Inheritance sometimes breaks. Lets see why:
 */
public class AddCountSet extends HashSet {
	private int addCount;
	
	public AddCountSet() {
		super();
	}

	public boolean add(Object o) { 
	    addCount++; 
	    return super.add(o); 
	  } 

	  public boolean addAll(Collection c) { 
	    addCount += c.size(); 
	    return super.addAll(c); 
	  } 

	  public int getAddCount() { 
	    return addCount; 
	  } 

	  public static void main(String[] args) {
	    AddCountSet s = new AddCountSet();
	    
	    String s1[] = new String[] {"Figo","Ronaldo","Mourinho"};
	    s.addAll(Arrays.asList(s1));
	    
	    // Devolve 6 e n‹o 3!
	    System.out.println(s.getAddCount());
	  }

}
