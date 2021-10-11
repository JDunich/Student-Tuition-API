package Roster;

public class International extends NonResident {
    private boolean abroad;
    public International(String name, Major major, int credit, boolean abroad) {
        super(name, major, credit);
        this.abroad = abroad;
    }

    @Override
    public String toString(){
    }
}
