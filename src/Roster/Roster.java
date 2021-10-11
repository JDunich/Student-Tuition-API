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
            while (j >= 0 && temp.compareTo(roster[j].getDate()) > 0) {
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
