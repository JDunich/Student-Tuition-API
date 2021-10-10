package Roster;

public class International extends NonResident {
    private boolean abroad;

    public International(Profile profile, int credit, boolean abroad) {
        super(profile, credit);
        this.abroad = abroad;
    }

    @Override
    public void tuitionDue() {
    }

    @Override
    public String toString(){
        String separator = ":";
        String result = super.toString() + separator + "international";
        if(abroad) {
            return result + separator + "study aborad";
        }
        return result;
    }

    public void setStatus() {
        this.abroad = true;
        if(super.getCredits() > 12) {
            super.setCredits(12);
        }
        super.setPayment(0);
        super.setDate(null);
        tuitionDue();
    }
}
