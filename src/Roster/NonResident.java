package Roster;

/**
 * NonResident calculations for Students
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class NonResident extends Student {
    /**
     * Tuition for Full time student
     */
    public static final int FULL_TIME_TUITION = 29737;
    /**
     * Fee per credit
     */
    private static final int FEE_PER_CREDIT = 966;

    /**
     * Constructor for NonResident
     * @param profile student profile
     * @param credit credit number
     */
    public NonResident(Profile profile, int credit) {
        super(profile, credit);
    }

    /**
     * tuitionDue calculator for NonResident
     */
    @Override
    public void tuitionDue() {
        double tuition = 0;
        switch(studentType(getCredits())){
            case 0:
                tuition = FULL_TIME_FEE + FULL_TIME_TUITION;
                break;
            case 1:
                tuition = FULL_TIME_FEE + FULL_TIME_TUITION + ((super.getCredits() - SIXTEEN_CREDITS) * FEE_PER_CREDIT);
                break;
            case -1:
                tuition = PART_TIME_FEE + (super.getCredits() * FEE_PER_CREDIT);
                break;
        }
        setTuitionDue(tuition - getTotalPayment());
    }

    /**
     * toString method NonResident
     * @return String formatted correctly
     */
    @Override
    public String toString(){
        String result = super.toString();
        return result + "non-resident";
    }
}
