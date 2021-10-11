package Roster;

public class International extends NonResident {
    private boolean abroad;
    private static final int ADDITIONAL_FEE = 2650;

    public International(Profile profile, int credit, boolean abroad) {
        super(profile, credit);
        this.abroad = abroad;
    }

    @Override
    public void tuitionDue() {
        super.tuitionDue();
        double tuition = super.getTuitionDue() + ADDITIONAL_FEE;
        if(abroad) tuition = tuition - getTuitionFee();
        setTuitionDue(tuition);
    }

    @Override
    public String toString(){
        String separator = ":";
        String result = super.toString() + separator + "international";
        if(abroad) {
            return result + separator + "study abroad";
        }
        return result;
    }

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
