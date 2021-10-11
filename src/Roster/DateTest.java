package Roster;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateTest {
    
    Date date;

    @Test
    public void checkInvalidFormat() {
        date = new Date("2021/9/28");
        assertEquals(false, date.isValid());
    }
    
    @Test
    public void monthUpperLimit() {
        date = new Date("14/15/2021");
        assertEquals(false, date.isValid());
    }
    
    @Test
    public void monthLowerLimit() {
        date = new Date("0/15/2021");
        assertEquals(false, date.isValid());
    }
    
    @Test
    public void monthWithinLimits() {
        date = new Date("5/15/2021");
        assertEquals(true, date.isValid());
    }
    
    @Test
    public void yearLowerLimit() {
        date = new Date("3/20/2020");
        assertEquals(false, date.isValid());
    }
    
    @Test
    public void yearWithinLimit() {
        date = new Date("3/20/2021");
        assertEquals(true, date.isValid());
    }
    
    @Test
    public void pastCurrentDate() {
        date = new Date("11/20/2021");
        assertEquals(false, date.isValid());
    }
    
    @Test
    public void beforeCurrentDate() {
        date = new Date("10/10/2021");
        assertEquals(true, date.isValid());
    }
    
    @Test
    public void checkLeapYear() {
        date = new Date("2/29/2021");
        assertEquals(false, date.isValid());
    }
    
    @Test
    public void checkNotLeapYear() {
        date = new Date("2/28/2021");
        assertEquals(true, date.isValid());
    }
    
    @Test
    public void thirtyIncorrectDays() {
        date = new Date("2/30/2021");
        assertEquals(false, date.isValid());
    }
    
    @Test
    public void thirtyCorrectDays() {
        date = new Date("4/30/2021");
        assertEquals(true, date.isValid());
    }
    
    @Test
    public void thirtyOneIncorrectDays() {
        date = new Date("9/31/2021");
        assertEquals(false, date.isValid());
    }
    
    @Test
    public void thirtyOneCorrectDays() {
        date = new Date("1/31/2021");
        assertEquals(true, date.isValid());
    }
    
    @Test
    public void invalidDays() {
        date = new Date("8/32/2021");
        assertEquals(false, date.isValid());
    }
    
}