package Roster;

public class Resident extends Student {
    
    private double financialAid;
    
    public Resident(Profile profile, int credit) {
        super(profile, credit);
        financialAid = 0;
    }
    
    @Override
    public void tuitionDue() {
        super.tuitionDue();
    }
    
    @Override
    public String toString(){
        String separator = ":";
        String result = super.toString() + "resident";
        if(financialAid == 0) {
            return result;
        }
        return result + separator + "financial aid " + financialAid;
    }
    
    public void setAid(double financialAid) {
        this.financialAid = financialAid;
    }
    
    public double getAid() {
        return financialAid;
    }
}
