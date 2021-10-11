package Roster;

public class NonResident extends Student {
    private static final int FULL_TIME_TUITION = 29737;
    private static final int FEE_PER_CREDIT = 966;
    
    public NonResident(Profile profile, int credit) {
        super(profile, credit);
    }

    @Override
    public void tuitionDue() {
        double tuition = 0;
        switch(studentType(getCredits())){
            case 0:
                tuition = getFullTimeFee() + FULL_TIME_TUITION;
                break;
            case 1:
                tuition = getFullTimeFee() + FULL_TIME_TUITION + ((super.getCredits() - getMaxCredits()) * FEE_PER_CREDIT);
                break;
            case -1:
                tuition = getPartTimeFee() + (super.getCredits() * FEE_PER_CREDIT);
                break;
        }
        setTuitionDue(tuition - getTotalPayment());
    }


    @Override
    public String toString(){
        String result = super.toString();
        return result + "non-resident";
    }
    
    public int getTuitionFee(){
        return FULL_TIME_TUITION;
}
}
