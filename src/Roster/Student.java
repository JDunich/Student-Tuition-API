package Roster;

public class Student {
        private Profile profile;
        private int credit;
        private double tuitionDue;
        private double payment;
        private double totalPayment;
        private Date date;
        private final int minCredits = 12;
        private final int maxCredits = 16;
        private static final int TUITION_FEE = 29737;
        private static final int FEE_PER_CREDIT = 966;
        private static final int FULL_TIME_FEE = 3268;
        private static final double PART_TIME_FEE = FULL_TIME_FEE * .80;
        private static final int ADDITIONAL_FEE = 2650;

        public Student(Profile profile, int credit){
                this.profile = profile;
                this.credit = credit;
                totalPayment = 0;
                payment = 0;
                date = null;
                tuitionDue = 0;
        }

        public Student(Profile profile){
                this.profile = profile;
                totalPayment = 0;
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

        public Date getDate(){
                return date;
        }

        public int studentType(int credit){
                if(credit > 16) return 1;
                if(credit >= 12) return 0;
                return -1;
        }

        public int getMinCredits(){
                return minCredits;
        }

        public int getMaxCredits(){
                return maxCredits;
        }

        public int getTuitionFee(){
                return TUITION_FEE;
        }

        public int getFeePerCredit(){
               return FEE_PER_CREDIT;
        }

        public int getFullTimeFee(){
                return FULL_TIME_FEE;
        }

        public double getPartTimeFee(){
                return PART_TIME_FEE;
        }

        public int getAdditionalFee(){
                return ADDITIONAL_FEE;
        }
}
