package Roster;

/**
 * TriState extension of NonResident
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class TriState extends NonResident{
    /**
     * state
     */
    private String state;
    /**
     * New York Discount
     */
    private static final int NY_TRI_DISCOUNT = 4000;
    /**
     * Connecticut Discount
     */
    private static final int CT_TRI_DISCOUNT = 5000;

    /**
     * TriState constructor
     * @param profile student profile
     * @param credit credit number
     * @param state student state
     */
    public TriState(Profile profile, int credit, String state) {
        super(profile, credit);
        this.state = state;
    }

    /**
     * tuitionDue calculator for TriState
     */
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

    /**
     * toString method TriState
     * @return String formatted correctly
     */
    @Override
    public String toString(){
        String separator = ":";
        String result = super.toString();
        return result + "(tri-state)" + separator + state;
    }
}
