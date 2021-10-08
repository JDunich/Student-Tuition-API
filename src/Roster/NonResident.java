package Roster;

public class NonResident extends Student {
    
    public NonResident(Profile profile, int credit) {
        super(profile, credit);
    }

    @Override
    public void tuitionDue() {
    }
    
    @Override
    public String toString(){
    }
}
