package Roster;

public class Student {
        private Profile profile;
        private int credit;
        private double tuitionDue;
        private double payment;
        private Date date;
        private static final int FULL_TIME_FEE = 3268;
        private static final double PART_TIME_FEE = FULL_TIME_FEE * .80;

        public Student(Profile profile, int credit){
                this.profile = profile;
                this.credit = credit;
                payment = 0;
                date = null;
                tuitionDue = 0;
        }

        public Student(Profile profile){
                this.profile = profile;
                payment = 0;
                date = null;
                tuitionDue = 0;
        }

        public void tuitionDue() {
                if (credit >= 12) {
                        tuitionDue = FULL_TIME_FEE;
                }
                else {
                        tuitionDue = PART_TIME_FEE;
                }
        }

        @Override
        public String toString(){
                String separator = ":";
                String profileString = profile.toString() + credit + " credit hours" + separator;
                String tuitionString = "tuition due" + separator + tuitionDue + separator + "total payment" +
                        separator + payment + separator + "last payment date " + date.toString() + separator;
                String result =  profileString + tuitionString;
                return result;
        }

        public int getCredits() {
                return credit;
        }

        public void setCredits(int credit) {
                this.credit = credit;
        }

        public void setPayment(int payment) {
                this.payment = payment;
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
}
