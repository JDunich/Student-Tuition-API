package Roster;

public class Student {
        private Profile profile;
        private int credit;
        private int tuitionDue;
        
        public Student(Profile profile, int credit){
                this.profile = profile;
                this.credit = credit;
                tuitionDue();
        }
        
        public Student(Profile profile){
                this.profile = profile;
        }
        
        public void tuitionDue() {
        }
        
        //Finish this method
        @Override
        public String toString(){
            
            String separator = ":";
            String profileString = profile.getName() + separator + profile.getMajor() + separator + credit + " credit hours" + separator;
            String tuitionString = "tuition due" + separator + separator + "total payment" + separator + separator + "last payment date";
            System.out.println(profileString);
            String result =  profileString + tuitionString;
            return result;
        }
        
        public static void main(String[] args) {
            
            Profile person1 = new Profile("Hannah", Major.valueOf("EE"));
            Student stud1 = new Student(person1, 12);
            stud1.toString();
            
        }
}
