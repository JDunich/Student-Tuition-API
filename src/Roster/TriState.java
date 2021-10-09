package Roster;

public class TriState extends NonResident{
    private String state;
    public TriState(String name, Major major, int credit, String state) {
        super(name, major, credit);
        this.state = state;
    }

    @Override
    public String toString(){
    }
}
