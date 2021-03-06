package com.example.demo;

import java.text.DecimalFormat;

/**
 * Resident calculations for Students
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class Resident extends Student {
    /**
     * Tuition for Full time student
     */
    private static final int FULL_TIME_TUITION = 12536;
    /**
     * Fee per credit
     */
    private static final int FEE_PER_CREDIT = 404;

    /**
     * Constructor for Resident
     * @param profile student profile
     * @param credit credit number
     */
    public Resident(Profile profile, int credit) {
        super(profile, credit);
    }

    /**
     * tuitionDue calculator for Resident
     */
    @Override
    public void tuitionDue() {
        double tuition = 0;
        switch(studentType(getCredits())){
            case 0:
                tuition = FULL_TIME_FEE + FULL_TIME_TUITION;
                break;
            case 1:
                tuition = FULL_TIME_FEE + FULL_TIME_TUITION + ((super.getCredits() - SIXTEEN_CREDITS) * FEE_PER_CREDIT);
                break;
            case -1:
                tuition = PART_TIME_FEE + (super.getCredits() * FEE_PER_CREDIT);
                break;
        }
        setTuitionDue(tuition - getTotalPayment() - getAid());
    }

    /**
     * toString method Resident
     * @return String formatted correctly
     */
    @Override
    public String toString(){
        String result = super.toString();
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        if(getAid() != 0) return result + "resident:financial aid $" + decimalFormat.format(getAid());
        return result + "resident";
    }
}
