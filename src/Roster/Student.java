package Roster;

public class Student {
        private Profile profile;
        private int credit;
        private double tuitionDue;
        private double totalPayment;
        private Date date;
        private static final int TWELVE_CREDITS = 12;
        private static final int SIXTEEN_CREDITS = 16;
        private static final int FULL_TIME_FEE = 3268;
        private static final double PART_TIME_FEE = FULL_TIME_FEE * .80;

        public Student(Profile profile, int credit){
                this.profile = profile;
                this.credit = credit;
                totalPayment = 0;
                date = null;
                tuitionDue = 0;
        }

        public Student(Profile profile){
                this.profile = profile;
                totalPayment = 0;
                date = null;
                tuitionDue = 0;
        }

        public void tuitionDue() {
                
        }

        @Override
        public String toString(){
                String separator = ":";
                String profileString = profile.toString() + credit + " credit hours" + separator;
                String tuitionString = "tuition due" + separator + tuitionDue + separator + "total payment" +
                        separator + totalPayment + separator + "last payment date " + date.toString() + separator;
                String result =  profileString + tuitionString;
                return result;
        }

        public String getName(){
                return profile.getName();
        }

        public int getCredits() {
                return credit;
        }

        public void setCredits(int credit) {
                this.credit = credit;
        }

        public double getTotalPayment() {
                return totalPayment;
        }

        public void setPayment(int payment) {
                this.totalPayment += payment;
                tuitionDue = tuitionDue - payment;
        }

        public void setTuitionDue(double tuition){
                this.tuitionDue = tuition;
        }

        public double getTuitionDue(){
                return tuitionDue;
        }

        public void setDate(Date date) {
                this.date = date;
        }

        public Date getDate(){
                return date;
        }

        public int studentType(int credit){
                if(credit > 16) return 1;
                if(credit >= 12) return 0;
                return -1;
        }

        public int getMinCredits(){
                return TWELVE_CREDITS;
        }

        public int getMaxCredits(){
                return SIXTEEN_CREDITS;
        }

        public int getFullTimeFee(){
                return FULL_TIME_FEE;
        }

        public double getPartTimeFee(){
                return PART_TIME_FEE;
        }
}
