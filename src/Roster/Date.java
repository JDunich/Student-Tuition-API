package Roster;

import java.util.Calendar;

/**
 * This class defines the Date abstract data type with year, month, and day
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class Date implements Comparable<Date> {
    /**
     * year global variable
     */
    private final int year;
    /**
     * month global variable
     */
    private final int month;
    /**
     * day global variable
     */
    private final int day;

    /**
     * constant for the 80s
     */
    private static final int TWENTY_TWENTY_ONE = 2021;
    /**
     * constant for quadrennial
     */
    private static final int QUADRENNIAL = 4;
    /**
     * constant for centennial
     */
    private static final int CENTENNIAL = 100;
    /**
     * constant for quatercentennial
     */
    private static final int QUATERCENTENNIAL = 400;

    /**
     * constant for January
     */
    private static final int JANUARY = 1;
    /**
     * constant for February
     */
    private static final int FEBRUARY = 2;
    /**
     * constant for March
     */
    private static final int MARCH = 3;
    /**
     * constant for April
     */
    private static final int APRIL = 4;
    /**
     * constant for May
     */
    private static final int MAY = 5;
    /**
     * constant for June
     */
    private static final int JUNE = 6;
    /**
     * constant for July
     */
    private static final int JULY = 7;
    /**
     * constant for August
     */
    private static final int AUGUST = 8;
    /**
     * constant for September
     */
    private static final int SEPTEMBER = 9;
    /**
     * constant for October
     */
    private static final int OCTOBER = 10;
    /**
     * constant for November
     */
    private static final int NOVEMBER = 11;
    /**
     * constant for December
     */
    private static final int DECEMBER = 12;

    /**
     * constant for 31 days
     */
    private static final int THIRTY_ONE_DAYS = 31;
    /**
     * constant for 30 days
     */
    private static final int THIRTY_DAYS = 30;
    /**
     * constant for 29 days
     */
    private static final int TWENTY_NINE_DAYS = 29;
    /**
     * constant for 28 days
     */
    private static final int TWENTY_EIGHT_DAYS = 28;

    /**
     * Constructor that takes a string in the form of "mm/dd/yyyy" and creates a Date object
     * @param date date input
     */
    public Date(String date) {

        //identify where each "/" is
        int first_slash, second_slash;
        first_slash = date.indexOf('/');
        second_slash = date.indexOf('/', first_slash + 1);

        String str_month = date.substring(0, first_slash);
        String str_day = date.substring(first_slash + 1, second_slash);
        String str_year = date.substring(second_slash + 1);

        this.month = Integer.parseInt(str_month);
        this.day = Integer.parseInt(str_day);
        this.year = Integer.parseInt(str_year);

    }

    /**
     * Constructor that creates a Date object with today's date using the Calendar class
     */
    public Date() {

        Calendar calendar = Calendar.getInstance();

        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);

        this.month = month;
        this.day = day;
        this.year = year;

    }

    /**
     * This method determines if the date
     * @return true if the date is valid, false if not
     */
    public boolean isValid() {

        Date curr_date = new Date();
        int max_days;

        //check if the year is invalid (before 2021 or past the current year)
        if ((year < TWENTY_TWENTY_ONE) || (year > curr_date.year)) {
            return false;
        }

        //check if the date is beyond the current date
        if (year == curr_date.year) {
            if (month > curr_date.month) {
                return false;
            } else if (month == curr_date.month) {
                if (day > curr_date.day) {
                    return false;
                }
            }
        }

        //using the month, determine the max amount of days that should be in that month
        switch (month) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                max_days = THIRTY_ONE_DAYS;
                break;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                max_days = THIRTY_DAYS;
                break;
            case FEBRUARY:
                if ((year % CENTENNIAL == 0 && year % QUATERCENTENNIAL != 0) || (year % QUADRENNIAL == 0)) {
                    max_days = TWENTY_NINE_DAYS;
                    break;
                } else {
                    max_days = TWENTY_EIGHT_DAYS;
                    break;
                }
            default:
                return false;
        }

        return max_days >= day;

    }

    /**
     * This method compares the two Date objects.
     * Returns 0 if the parameter date is equal to the other date
     * Returns -1 if the parameter date is less than the other date
     * Returns 1 if the parameter date is greater than the other date
     * @param date input
     * @return Returns 0 if the parameter date is equal to the other date, Returns -1 if the parameter date is less than the other date, Returns 1 if the parameter date is greater than the other date
     */
    @Override
    public int compareTo(Date date) {

        //checks if the years are equal
        if (date.year == year) {

            //if the years are equal, checks if the months are equal
            if (date.month == month) {

                //if the months are equal, checks if the days are equal
                if (date.day == day) {
                    return 0;
                } else if (date.day > day) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (date.month > month) {
                return 1;
            } else {
                return -1;
            }
        } else if (date.year > year) {
            return 1;
        } else {
            return -1;
        }

    }

    /**
     * Accessor method for the day field
     * @return int day of the month
     */
    public int getDay() {
        return day;
    }

    /**
     * Accessor method for the month field
     * @return int month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Accessor method for the year field
     * @return int year
     */
    public int getYear() {
        return year;
    }

    /**
     * This helper method returns a Date object back into a string in the form:
     * "mm/dd/yyyy"
     * @return string
     */
    @Override
    public String toString() {

        String separator = "/";
        String month = String.valueOf(this.month);
        String day = String.valueOf(this.day);
        String year = String.valueOf(this.year);
        String result = month + separator + day + separator + year;
        return result;
    }


}