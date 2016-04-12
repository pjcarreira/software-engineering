package ist.es.bestpractices.immutable;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class SelectiveStudent3 extends Student {
	private final List<Student> favoriteFriends = new LinkedList<Student>();

	/**
	 * Avoid relying on a reference to an external list
	 */
	public SelectiveStudent3(String name, final List<Student> highSchoolMates) {
		super(name);

		for (Student mate : highSchoolMates) {
			this.addFriend(mate);
		}
		
	}

	public void addFriend(final Student friend) {
		if (friend.getName().startsWith("Ana")) {
			favoriteFriends.add(friend);
		}
	}

	/**
	 * Avoid returning collections that expose the internal state of the class
	 * 
	 * @return the immutable version
	 */
	public List<Student> getFriends() {
		return Collections.unmodifiableList(favoriteFriends);
	}

	public void printFriends() {
		System.out.println(getName() + "'s friends:");
		for (Student f : favoriteFriends) {
			System.out.println(f.getName());
		}
		System.out.println();
	}

	public static void main(String[] args) {
		final List<Student> highSchoolFriends = new LinkedList<Student>();
		highSchoolFriends.add(new Student("Anacleto"));
		highSchoolFriends.add(new Student("Anastacio"));

		// create joao with the high school friends
		final SelectiveStudent3 joao = new SelectiveStudent3("Joao",
				highSchoolFriends);
		highSchoolFriends.add(new Student("Anabela"));
		joao.printFriends();

		// Create joana
		final List<Student> joaoFriends = joao.getFriends();
		final SelectiveStudent3 joana = new SelectiveStudent3("Joana",
				joaoFriends);

		// add joana's new friends
		// we are adding to joao's list! This will fail.
		joana.addFriend(new Student("Ana Nas"));
		joana.addFriend(new Student("Ana Stesia"));
		joana.addFriend(new Student("Ana Cronica"));
		joana.addFriend(new Student("Ana Lize"));
		joana.printFriends();

		// return to joao's friends again
		joao.printFriends();
		
		// looks ok now!

	}
};
