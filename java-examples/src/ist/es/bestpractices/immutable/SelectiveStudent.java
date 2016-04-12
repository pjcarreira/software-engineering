package ist.es.bestpractices.immutable;

import java.util.LinkedList;
import java.util.List;

/**
 * Selective student example accepting an external collection reference and returning a
 * collection.
 */
public final class SelectiveStudent extends
        Student {
    final List<Student> favoriteFriends;

    public SelectiveStudent(String name, final List<Student> highSchoolMates) {
        super(name);
        favoriteFriends = highSchoolMates;
    }

    public void addFriend(final Student friend) {
        if (friend.getName().startsWith("Ana")) {
            favoriteFriends.add(friend);
        }
    }

    public List<Student> getFriends() {
        return favoriteFriends;
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

        // create Joao with the high school friends
        final SelectiveStudent joao = new SelectiveStudent("Joao", highSchoolFriends);
        highSchoolFriends.add(new Student("Anabela"));
        joao.printFriends();

        // Create joana
        final List<Student> joaoFriends = joao.getFriends();
        final SelectiveStudent joana = new SelectiveStudent("Joana", joaoFriends);

        // Add joana's new friends
        joana.addFriend(new Student("Ana Nas"));
        joana.addFriend(new Student("Ana Stesia"));
        joana.addFriend(new Student("Ana Cronica"));
        joana.addFriend(new Student("Ana Lize"));

        // return to joao's friends again
        joao.printFriends();

        // Oops. What went wrong here?
    }
};
