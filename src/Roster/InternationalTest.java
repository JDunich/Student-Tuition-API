package Roster;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternationalTest {

    International student;
    Profile info = new Profile("John", Major.CS);

    @Test
    void tuitionDueNoAbroad() {
        student = new International(info, 12, false);
        student.tuitionDue();
        assertEquals(35655, student.getTuitionDue());
    }

    @Test
    void tuitionDueAbroad() {
        student = new International(info, 12, true);
        student.tuitionDue();
        assertEquals(5918, student.getTuitionDue());
    }

}