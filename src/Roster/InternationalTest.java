package Roster;

import static org.junit.Assert.*;

import org.junit.Test;

public class InternationalTest {

    International student;
    Profile info = new Profile("John", Major.CS);
    double tuition;
    
    @Test
    public void tuitionDueSixteenCredits() {
        student = new International(info, 16, false);
        student.tuitionDue();
        tuition = 35655.00;
        assertEquals(tuition, student.getTuitionDue(), 0);
    }
    
    @Test
    public void tuitionDueTwentyCredits() {
        student = new International(info, 20, false);
        student.tuitionDue();
        tuition = 39519.00;
        assertEquals(tuition, student.getTuitionDue(), 0);
    }

    @Test
    public void tuitionDueNoAbroad() {
        student = new International(info, 12, false);
        student.tuitionDue();
        tuition = 35655.00;
        assertEquals(tuition, student.getTuitionDue(), 0);
    }

    @Test
    public void tuitionDueAbroad() {
        student = new International(info, 12, true);
        student.tuitionDue();
        tuition = 5918.00;
        assertEquals(tuition, student.getTuitionDue(), 0);
    }

}