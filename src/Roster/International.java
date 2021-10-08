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
    }
    
    public void setStatus() {
        this.abroad = true;
        super.setCredits(12);
    }
}
