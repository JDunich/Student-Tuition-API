package Roster;

/**
 * Makes unique student based on name and major
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class Profile {
    /**
     * name of student
     */
    private String name;
    /**
     * major of student
     */
    private Major major;

    /**
     * Constructor that makes a profile given param
     * @param name name of student
     * @param major 5 majors and 2-characters each: CS, IT, BA, EE, ME
     */
    public Profile(String name, Major major) {
        this.name = name;
        this.major = major;
    }

    /**
     * returns true or false based on if the objects are equal
     * @param obj object to be compared
     * @return true is objects are equal or false if they are not
     */
    @Override
    public boolean equals(Object obj) {
        return (name.compareTo(((Profile) obj).getName()) == 0) && (major.equals(((Profile) obj).getMajor()));
    }

    /**
     * returns string
     * @return string
     */
    @Override
    public String toString() {
        String separator = ":";
        String result = name + separator + major + separator;
        return result;
    }

    /**
     * getter for major
     * @return major
     */
    public Major getMajor() {
        return major;
    }

    /**
     * getter for name
     * @return name
     */
    public String getName() {
        return name;
    }
}
