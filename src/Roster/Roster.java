package Roster;

public class Roster {
    private Student[] roster;
    private int size; //keep track of the number of students in the roster

    private int find(Student student) {
        if (size == 0) grow();
        for(int i = 0; i < size; i++)
            if (roster[i].equals(student)) return i;
        return -1;
    }

    private void grow() {
        Student[] arr = new Student[size+4];
        for(int i = 0; i < size; i++) arr[i] = roster[i];
        roster = arr;
    }

    public boolean add(Student student) {
        if(find(student) == -1){
            if(roster[roster.length - 1] == null) grow();
            roster[size] = student;
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(Student student) {
        int i = find(student);
        if(i == -1) return false;
        Student[] temp = new Student[roster.length];
        for(int j = 0; j < i; j++) temp[j] = roster[j];
        for(i = i+1; i < size; i++) temp[i-1] = roster[i];
        roster =  temp;
        size--;
        return true;
    }

    public void print() {
        if (size == 0) {
            System.out.println("Student roseter is empty!");
        } else {
            System.out.println("* list of students in the roster **");
            for (int i = 0; i < size; i++) {
                System.out.println(roster[i].toString());
            }
            System.out.println("* end of roster **");
        }
    }
    
    public void print() {
        if (size == 0) {
            System.out.println("Student roseter is empty!");
        } else {
            System.out.println("* list of students in the roster **");
            for (int i = 0; i < size; i++) {
                System.out.println(roster[i].toString());
            }
            System.out.println("* end of roster **");
        }
    }
}
