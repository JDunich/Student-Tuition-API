package Roster;

/**
 * This class extends NonResident and does calculations for International Students
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class International extends NonResident {
    /**
     * boolean abroad
     */
    private boolean abroad;
    /**
     * Fee for International
     */
    private static final int ADDITIONAL_FEE = 2650;

    /**
     * constructor
     * @param profile student profile
     * @param credit credit number
     * @param abroad if student is abroad
     */
    public International(Profile profile, int credit, boolean abroad) {
        super(profile, credit);
        this.abroad = abroad;
    }

    /**
     * tuitionDue calculator for International
     */
    @Override
    public void tuitionDue() {
        super.tuitionDue();
        double tuition = super.getTuitionDue() + ADDITIONAL_FEE;
        if(abroad) tuition = tuition - FULL_TIME_TUITION;
        setTuitionDue(tuition);
    }

    /**
     * toString method international
     * @return String formatted correctly
     */
    @Override
    public String toString(){
        String separator = ":";
        String result = super.toString() + separator + "international";
        if(abroad) {
            return result + separator + "study abroad";
        }
        return result;
    }

    /**
     * setStatus and change credits to 12, date to null, payment to 0
     */
    public void setStatus() {
        this.abroad = true;
        if(super.getCredits() > 12) {
            super.setCredits(12);
        }
        setPayment(0);
        super.setDate(null);
        tuitionDue();
    }
}
