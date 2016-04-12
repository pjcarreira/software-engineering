package ist.es.eclipsetasks;

// TODO: Auto-generated Javadoc
/**
 * Quickly creating a class.
 */
public class QuickClass {

    private static final int AGE_LIMIT = 65;

    /** The age. */
    int age;

    /** The name. */
    int name;

    /**
     * Gets the age.
     *
     * @return the age
     */
    public int getAge2() {
        return age;
    }

    /**
     * Checks if is old.
     *
     * @return true, if is old
     */
    boolean isOld() {
        return age > AGE_LIMIT;
    }

    /**
     * Sets the age.
     *
     * @param age the new age
     */
    public void setAge(int age) {
        checkAge(null, age);
        this.age = age;
    }

    /**
     * Checks the age.
     * <p>
     * This method should called after calling {@link #getAge2()}.
     * 
     * @param height the height of
     * @param width the withf lksdfj. Cannot be <code>null</code>.
     * @return alsjdjk if <code>true</code> 
     */
    private boolean checkAge(int height, int width) {
        if (age > 18) {
            this.age = 25;
        }
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public int getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(int name) {
        this.name = name;
    }


}
