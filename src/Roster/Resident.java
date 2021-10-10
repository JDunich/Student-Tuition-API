package Roster;

public class Resident extends Student {

    public Resident(Profile profile, int credit) {
        super(profile, credit);
    }

    @Override
    public void tuitionDue() {
        super.tuitionDue();
    }

    @Override
    public String toString(){
        String result = super.toString();
        return result + "resident";
    }
}
