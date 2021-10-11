package Roster;

public class Resident extends Student {
    private static final int FULL_TIME_FEE = 12536;
    public Resident(Profile profile, int credit) {
        super(profile, credit);
    }

    @Override
    public void tuitionDue() {
        double tuition = 0;
        switch(studentType(getCredits())){
            case 0:
                tuition = getFullTimeFee() + getTuitionFee();
                break;
            case 1:
                tuition = getFullTimeFee() + getTuitionFee() + ((super.getCredits() - getMaxCredits()) * getFeePerCredit());
                break;
            case -1:
                tuition = getPartTimeFee() + (super.getCredits() * getFeePerCredit());
                break;
        }
        setTuitionDue(tuition);
    }


    @Override
    public String toString(){
        String result = super.toString();
        return result + "resident";
    }
}
