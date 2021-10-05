package Roster;

public class Student {
        private String name;
        private Major major;
        private int credit;
        public Student(String name, Major major, int credit){
                this.name = name;
                this.major = major;
                this.credit = credit;
        }
        public void tuitionDue() {
        }

        @Override
        public String toString(){
        }
}
