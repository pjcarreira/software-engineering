package ist.es.bestpractices.inheritance;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AddCountSetDecorator implements Set {

	private final Set decoratedInstance;

	private int addCount;

	public AddCountSetDecorator(Set instance) {
		super();
		decoratedInstance = instance;
	}
	
	
	public int getAddCount() {
		return addCount;
	}

	public boolean add(Object o) {
		addCount++;
		return decoratedInstance.add(o);
	}

	public boolean addAll(Collection c) {
		
		addCount += c.size();
		return decoratedInstance.addAll(c);
	}

	

	@Override
	public void clear() {
		decoratedInstance.clear();
	}


	@Override
	public boolean contains(Object o) {
		return decoratedInstance.contains(o);
	}


	@Override
	public boolean containsAll(Collection c) {
		return decoratedInstance.containsAll(c);
	}


	@Override
	public boolean isEmpty() {
		return decoratedInstance.isEmpty();
	}


	@Override
	public Iterator iterator() {
		return decoratedInstance.iterator();
	}


	@Override
	public boolean remove(Object o) {
		return decoratedInstance.remove(o);
	}


	@Override
	public boolean removeAll(Collection c) {
		return decoratedInstance.removeAll(c);
	}


	@Override
	public boolean retainAll(Collection c) {
		return decoratedInstance.retainAll(c);
	}


	@Override
	public int size() {
		return decoratedInstance.size();
	}


	@Override
	public Object[] toArray() {
		return decoratedInstance.toArray();
	}


	@Override
	public Object[] toArray(Object[] a) {
		return decoratedInstance.toArray();
	}


	public static void main(String[] args) {
		AddCountSetDecorator s = new AddCountSetDecorator(new HashSet());

		String s1[] = new String[] { "Figo", "Ronaldo", "Mourinho" };
		s.addAll(Arrays.asList(s1));

		// Devolve 3. Correcto!
		System.out.println(s.getAddCount());
	}

}
