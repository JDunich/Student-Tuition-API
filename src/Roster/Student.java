package Roster;

public class Student {
        private Profile profile;
        private int credit;
        private double tuitionDue;
        private static final int FULL_TIME_FEE = 3268;
        private static final double PART_TIME_FEE = FULL_TIME_FEE * .80;
        
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
            String tuitionString = "tuition due" + separator + tuitionDue + separator + "total payment" + separator + separator + "last payment date";
            String result =  profileString + tuitionString;
            return result;
        }
        
        public void setCredits(int credit) {
            this.credit = credit;
        }
}
