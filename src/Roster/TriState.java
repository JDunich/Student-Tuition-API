package Roster;

public class TriState extends NonResident{
    private String state;
    private static final int NY_TRI_DISCOUNT = 4000;
    private static final int CT_TRI_DISCOUNT = 5000;
    public TriState(Profile profile, int credit, String state) {
        super(profile, credit);
        this.state = state;
    }

    @Override
    public void tuitionDue() {
        super.tuitionDue();
        double tuition = super.getTuitionDue();
        switch(studentType(getCredits())){
            case 0: case 1:
                if(state.equals("NY")) {
                    setTuitionDue(tuition - NY_TRI_DISCOUNT);
                }
                else {
                    setTuitionDue(tuition - CT_TRI_DISCOUNT);
                }
                break;

            case -1:
                setTuitionDue(tuition);
                break;
        }
    }


    @Override
    public String toString(){
        String separator = ":";
        String result = super.toString();
        return result + "(tri-state)" + separator + state;
    }
}
