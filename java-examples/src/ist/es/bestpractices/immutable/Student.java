package ist.es.bestpractices.immutable;

public class Student {
	private final String studentName;

	Student(String name) {
		assert name != null: "Name shouldnt be null";

		studentName = name;
	}

	public String getName() {
		return studentName;
	}
};