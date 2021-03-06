package Roster;

/**
 * Manipulates the roster array
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class Roster {
    /**
     * Student array
     */
    private Student[] roster;
    /**
     * keep track of the number of students in the roster
     */
    private int size;
    /**
     * -1 not found
     */
    private static final int NOT_FOUND = -1;

    /**
     * finds a student in the array
     * @param student studen to find
     * @return -1 if not found, i index if found
     */
    private int find(Student student) {
        if (size == 0) grow();
        for(int i = 0; i < size; i++)
            if (roster[i].getProfile().equals(student.getProfile())) return i;
        return NOT_FOUND;
    }

    /**
     * grow array by 4
     */
    private void grow() {
        Student[] arr = new Student[size+4];
        for(int i = 0; i < size; i++) arr[i] = roster[i];
        roster = arr;
    }

    /**
     * add student to the array
     * @param student to add
     * @return true if student was added boolean, false if not
     */
    public boolean add(Student student) {
        if(find(student) == NOT_FOUND){
            if(roster[roster.length - 1] == null) grow();
            roster[size] = student;
            size++;
            return true;
        }
        return false;
    }

    /**
     * remove student from the array
     * @param student to remove
     * @return true if student was removed boolean, false if not
     */
    public boolean remove(Student student) {
        int i = find(student);
        if(i == NOT_FOUND) return false;
        Student[] temp = new Student[roster.length];
        for(int j = 0; j < i; j++) temp[j] = roster[j];
        for(i = i+1; i < size; i++) temp[i-1] = roster[i];
        roster =  temp;
        size--;
        return true;
    }

    /**
     * print the roster
     */
    public void print() {
        if (size == 0) {
            System.out.println("Student roster is empty!");
        } else {
            System.out.println("* list of students in the roster **");
            for (int i = 0; i < size; i++) {
                System.out.println(roster[i].toString());
            }
            System.out.println("* end of roster **");
        }
    }

    /**
     * print the roster by name
     */
    public void printName() {
        if (size == 0) {
            System.out.println("Student roster is empty!");
        } else {
            orderNames();
            System.out.println("* list of students ordered by name **");
            for (int i = 0; i < size; i++) {
                System.out.println(roster[i].toString());
            }
            System.out.println("* end of roster **");
        }
    }

    /**
     * print the roster by payment date
     */
    public void printPaymentDate(){
        if (size == 0) {
            System.out.println("Student roster is empty!");
        } else {
            Student[] temp = orderPayment();
            System.out.println("* list of students made payments ordered by payment date **");
            for (int i = 0; i < temp.length; i++) {
                System.out.println(temp[i].toString());
            }
            System.out.println("* end of roster **");
        }
    }

    /**
     * calculate tuition due for all students
     * @return true if there are students to calculate, false if not
     */
    public boolean calculate() {
        if (size == 0) {
            return false;
        } else {
            for (int i = 0; i < size; i++) {
                roster[i].tuitionDue();
            }
            return true;
        }
    }

    /**
     * set internation abroad status to true
     * @param student to change status
     * @return true if international student found, false if not
     */
    public boolean setStatus(Student student) {
        int index = find(student);
        if(index == NOT_FOUND || !(roster[index] instanceof International)){
            return false;
        }
        International temp = (International)roster[index];
        temp.setStatus();
        roster[index] = temp;
        return true;
    }

    /**
     * calculate financial aid for student
     * @param student to calculate financial aid
     * @return true if student is eligible, false if not
     */
    public boolean financialAid(Student student) {
        int index = find(student);
        if(index == NOT_FOUND ){
            System.out.println("Student not in the roster.");
            return false;
        }
        if(!(roster[index] instanceof Resident)) {
            System.out.println("Not a resident student.");
            return false;
        }
        if(roster[index].getCredits() < roster[index].TWELVE_CREDITS) {
            System.out.println("Parttime student doesn't qualify for the award.");
            return false;
        }
        if(roster[index].getAid() != 0) {
            System.out.println("Awarded once already.");
            return false;
        }
        if(student.getAid() > 10000 || student.getAid() < 0) {
            System.out.println("Invalid amount.");
            return false;
        }
        roster[index].setAid(student.getAid());
        return true;
    }

    /**
     * student to pay
     * @param student who is paying
     * @return true if student pays valid about and exists in roster, false if not
     */
    public boolean pay(Student student) {
        int index = find(student);
        if(index == NOT_FOUND ){
            System.out.println("Student not in the roster.");
            return false;
        }
        if(student.getTotalPayment() <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }
        if(student.getTotalPayment() > roster[index].getTuitionDue()) {
            System.out.println("Amount is greater than amount due.");
            return false;
        }
        roster[index].setTotalPayment(student.getTotalPayment());
        roster[index].setDate(student.getDate());
        return true;
    }

    /**
     * order roster by names
     */
    private void orderNames(){
        for(int i = 0; i < size; i++){
            for(int j = i+1; j < size; j++){
                if(roster[i].getName().compareTo(roster[j].getName()) > 0){
                    Student temp = roster[i];
                    roster[i] = roster[j];
                    roster[j] = temp;
                }
            }
        }
    }

    /**
     * order roster by payment date
     * @return Student array of payment ordered by date
     */
    private Student[] orderPayment(){
        Student[] arr = new Student[size];
        Student[] newRoster = new Student[size];
        int count = 0;
        int k = 0;
        int l = 0;
        while(k != size){
            if(roster[k].getTotalPayment() != 0){
                arr[count] = roster[k];
                count++;
                k++;
                continue;
            }
            newRoster[l] = roster[k];
            l++;
            k++;
        }

        for (int i = 1; i < count; i++) {
            Student key = arr[i];
            int j = i - 1;
            Date temp = key.getDate();
            while (j >= 0 && temp.compareTo(arr[j].getDate()) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        Student[] temp = new Student[count];
        for(int i = 0; i < count; i++){
            temp[i] = arr[i];
            newRoster[l+i] = arr[i];
        }
        roster = newRoster;
        return temp;

    }
}
