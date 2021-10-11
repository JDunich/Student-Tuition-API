package Roster;

import java.text.DecimalFormat;

/**
 * Student Class
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class Student {
    /**
     * profile for student
     */
    private Profile profile;
    /**
     * credit
     */
    private int credit;
    /**
     * tuition due
     */
    private double tuitionDue;
    /**
     * total payment
     */
    private double totalPayment;
    /**
     * date
     */
    private Date date;
    /**
     * financial aid
     */
    private double financialAid;
    /**
     * 12 credits
     */
    public static final int TWELVE_CREDITS = 12;
    /**
     * 16 credits
     */
    public static final int SIXTEEN_CREDITS = 16;
    /**
     * full time fee
     */
    public static final int FULL_TIME_FEE = 3268;
    /**
     * parttime fee
     */
    public static final double PART_TIME_FEE = FULL_TIME_FEE * .80;

    /**
     * Student constructor
     * @param profile student profile
     * @param credit credit number
     */
    public Student(Profile profile, int credit){
        this.profile = profile;
        this.credit = credit;
        totalPayment = 0;
        date = null;
        tuitionDue = 0;
        financialAid = 0;
    }

    /**
     * Student Constructor
     * @param profile student profile
     */
    public Student(Profile profile){
        this.profile = profile;
        totalPayment = 0;
        date = null;
        tuitionDue = 0;
        financialAid = 0;
    }

    /**
     * empty void
     */
    public void tuitionDue() {

    }

    /**
     * Formats string
     * @return formatted string
     */
    @Override
    public String toString(){
        String separator = ":";
        String dateString;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        if(date == null) {
            dateString = "last payment date: " + "--/--/--" + separator;
        }
        else {
            dateString = "last payment date: " + date.toString() + separator;
        }
        String profileString = profile.toString() + credit + " credit hours" + separator;
        String tuitionString = "tuition due" + separator + decimalFormat.format(tuitionDue) + separator + "total payment" +
                separator + decimalFormat.format(totalPayment) + separator;
        String result =  profileString + tuitionString + dateString;
        return result;
    }

    /**
     * getter for profile
     * @return Profile
     */
    public Profile getProfile() { return profile; }

    /**
     * getter for name
     * @return name
     */
    public String getName(){
        return profile.getName();
    }

    /**
     * getter for credits
     * @return credit number
     */
    public int getCredits() {
        return credit;
    }

    /**
     * setter for credits
     * @param credit given credit
     */
    public void setCredits(int credit) {
        this.credit = credit;
    }

    /**
     * getter for total payment
     * @return payment
     */
    public double getTotalPayment() {
        return totalPayment;
    }

    /**
     * setter for payment
     * @param payment given payment
     */
    public void setPayment(double payment) {
        totalPayment = payment;

    }

    /**
     * setter for total payment
     * @param payment given payment
     */
    public void setTotalPayment(double payment) {
        totalPayment += payment;
        tuitionDue = tuitionDue - payment;
    }

    /**
     * setter for tuition due
     * @param tuition givent tuition
     */
    public void setTuitionDue(double tuition){
        this.tuitionDue = tuition;
    }

    /**
     * getter for tuition due
     * @return tuition due
     */
    public double getTuitionDue(){
        return tuitionDue;
    }

    /**
     * setter for date
     * @param date given date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * getter for date
     * @return date
     */
    public Date getDate(){
        return date;
    }

    /**
     * check student type
     * @param credit given credit
     * @return 1 if over 16, 0 if over 12, -1 if under 12
     */
    public int studentType(int credit){
        if(credit > 16) return 1;
        if(credit >= 12) return 0;
        return -1;
    }

    /**
     * setter for aid
     * @param aid given aid
     */
    public void setAid(double aid) {
        financialAid = aid;
    }

    /**
     * getter for aid
     * @return aid
     */
    public double getAid() {
        return financialAid;
    }


}
