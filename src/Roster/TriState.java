package Roster;

public class TriState extends NonResident{
    private String state;
    private final int TRI_DISCOUNT = 4000;
    public TriState(Profile profile, int credit, String state) {
        super(profile, credit);
        this.state = state;
    }

    @Override
    public void tuitionDue() {
        setTuitionDue(getTuitionDue()-TRI_DISCOUNT);
    }

    @Override
    public String toString(){
        String separator = ":";
        String result = super.toString();
        return result + "(tri-state)" + separator + state;
    }
}
