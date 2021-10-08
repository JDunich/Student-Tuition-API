package Roster;

public class TriState extends NonResident{
    private String state;
    
    public TriState(Profile profile, int credit, String state) {
        super(profile, credit);
        this.state = state;
    }

    @Override
    public String toString(){
    }
}
