package Roster;

public class NonResident extends Student {
    private final int minCredits = 12;
    private final int maxCredits = 16;
    private static final int TUITION_FEE = 29737;
    private static final int FEE_PER_CREDIT = 966;
    private static final int FULL_TIME_FEE = 3268;
    private static final double PART_TIME_FEE = FULL_TIME_FEE * .80;

    public NonResident(Profile profile, int credit) {
        super(profile, credit);
    }

    @Override
    public void tuitionDue() {
        double tuition;
        if(getCredits() >= minCredits){
            if(getCredits() > maxCredits) tuition = FULL_TIME_FEE + TUITION_FEE + ((getCredits() - maxCredits) * FEE_PER_CREDIT);
            else tuition = FULL_TIME_FEE + TUITION_FEE;
        }else tuition = PART_TIME_FEE + (getCredits() * FEE_PER_CREDIT);

        setTuitionDue(tuition);
    }

    @Override
    public String toString(){
        String result = super.toString();
        return result + "non-resident";
    }
}
