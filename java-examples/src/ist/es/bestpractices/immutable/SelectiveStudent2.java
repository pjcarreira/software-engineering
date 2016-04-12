package ist.es.bestpractices.immutable;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class SelectiveStudent2 extends Student {
	final List<Student> favoriteFriends;

	public SelectiveStudent2(String name, final List<Student> highSchoolMates) {
		super(name);
		favoriteFriends = highSchoolMates;
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

		// create joAo with the high school friends
		final SelectiveStudent2 joao = new SelectiveStudent2("Jo‹o",
				highSchoolFriends);
		highSchoolFriends.add(new Student("Anabela"));
		joao.printFriends();

		// Create joana
		final List<Student> joaoFriends = joao.getFriends();
		final SelectiveStudent2 joana = new SelectiveStudent2("Joana",
				joaoFriends);

		// add joana's new friends
		// we are adding to joao's list! This will fail.
		joana.addFriend(new Student("Ana N‡s"));
		joana.addFriend(new Student("Ana Stesia"));
		joana.addFriend(new Student("Ana Cr—nica"));
		joana.addFriend(new Student("Ana Lize"));
		joana.printFriends();

		// return to joao's friends again
		joao.printFriends();
	}
};
