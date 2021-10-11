package Roster;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RosterTest {

    Roster arr = new Roster();

    @Test
    void addStudent() {
        Profile info = new Profile("John", Major.CS);
        Student student = new Student(info, 10);
        assertEquals(true, arr.add(student));
    }

    @Test
    void addResident() {
        Profile info = new Profile("John", Major.CS);
        Resident student = new Resident(info, 10);
        assertEquals(true, arr.add(student));
    }

    @Test
    void addNonResident() {
        Profile info = new Profile("John", Major.CS);
        NonResident student = new NonResident(info, 10);
        assertEquals(true, arr.add(student));
    }

    @Test
    void addTriState() {
        Profile info = new Profile("John", Major.CS);
        TriState student = new TriState(info, 10, "NY");
        assertEquals(true, arr.add(student));
    }

    @Test
    void addInternational() {
        Profile info = new Profile("John", Major.CS);
        International student = new International(info, 10, false);
        assertEquals(true, arr.add(student));
    }

    @Test
    void addSame() {
        Profile info = new Profile("John", Major.CS);
        Student student1 = new Student(info, 10);
        Student student2 = new Student(info, 10);
        arr.add(student1);
        assertEquals(false, arr.add(student2));
    }

    @Test
    void addFive() {
        Profile info1 = new Profile("John1", Major.CS);
        Profile info2 = new Profile("John2", Major.CS);
        Profile info3 = new Profile("John3", Major.CS);
        Profile info4 = new Profile("John4", Major.CS);
        Profile info5 = new Profile("John5", Major.CS);
        Student student1 = new Student(info1, 10);
        Student student2 = new Student(info2, 10);
        Student student3 = new Student(info3, 10);
        Student student4 = new Student(info4, 10);
        Student student5 = new Student(info5, 10);
        arr.add(student1);
        arr.add(student2);
        arr.add(student3);
        arr.add(student4);
        assertEquals(true, arr.add(student5));
    }

    @Test
    void removeStudent() {
        Profile info = new Profile("John", Major.CS);
        Student student = new Student(info, 10);
        arr.add(student);
        assertEquals(true, arr.remove(student));
    }

    @Test
    void removeResident() {
        Profile info = new Profile("John", Major.CS);
        Resident student = new Resident(info, 10);
        arr.add(student);
        assertEquals(true, arr.remove(student));
    }

    @Test
    void removeNonResident() {
        Profile info = new Profile("John", Major.CS);
        NonResident student = new NonResident(info, 10);
        arr.add(student);
        assertEquals(true, arr.remove(student));
    }

    @Test
    void removeStudentNotIn() {
        Profile info = new Profile("John", Major.CS);
        Student student = new Student(info, 10);
        assertEquals(false, arr.remove(student));
    }


}