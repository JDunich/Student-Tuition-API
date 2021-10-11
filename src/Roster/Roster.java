package Roster;

public class Roster {
    private Student[] roster;
    private int size; //keep track of the number of students in the roster

    private int find(Student student) {
        if (size == 0) grow();
        for(int i = 0; i < size; i++)
            if (roster[i].getProfile().equals(student.getProfile())) return i;
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
            System.out.println("Student roster is empty!");
        } else {
            System.out.println("* list of students in the roster **");
            for (int i = 0; i < size; i++) {
                System.out.println(roster[i].toString());
            }
            System.out.println("* end of roster **");
        }
    }
    
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
    
    public boolean setStatus(Student student) {
        int index = find(student);
        if(index == -1 || !(roster[index] instanceof International)){
            System.out.println("here");
            return false;
        }
        International temp = (International)roster[index];
        temp.setStatus();
        roster[index] = temp;
        return true;
    }
    
    public boolean financialAid(Student student) {
        int index = find(student);
        if(index == -1 ){
            System.out.println("Student not in the roster.");
            return false;
        }
        if(!(roster[index] instanceof Resident)) {
            System.out.println("Not a resident student.");
            return false;
        }
        if(roster[index].getCredits() < roster[index].getMinCredits()) {
            System.out.println("Parttime student doesn't qualify for the award");
            return false;
        }
        if(roster[index].getAid() != 0) {
            System.out.println("Awarded once already");
            return false;
        }
        if(student.getAid() > 10000 || student.getAid() < 0) {
            System.out.println("Invalid amount.");
            return false;
        }
        roster[index].setAid(student.getAid());
        return true;
    }
    
    public boolean pay(Student student) {
        int index = find(student);
        if(index == -1 ){
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

    private Student[] orderPayment(){
        Student[] arr = new Student[size];
        int count = 0;
        int k = 0;
        while(k != size){
            if(roster[k].getTotalPayment() != 0){
                arr[count] = roster[k];
                count++;
                k++;
                continue;
            }
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
        for(int i = 0; i < count; i++) temp[i] = arr[i];
        return temp;
    }
}
