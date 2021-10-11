package Roster;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TuitionManager {
    Roster arr = new Roster();
    private boolean running = true;

    public void run(){
        System.out.println("Tuition Manager starts running.");
        Scanner sc = new Scanner(System.in);
        while(running){
            String s = sc.nextLine();
            StringTokenizer input = new StringTokenizer(s, ",");
            String command = input.nextToken();
            if(!notValid(command)){
                System.out.println("Command '" + s + "' not supported!");
                continue;
            }

            if(isPrint(command)) continue;
            task(command, input);

        }
        sc.close();
    }
    
    private void task(String command, StringTokenizer input){
        if(!input.hasMoreTokens()){
            System.out.println("Missing data in command line.");
            return;
        }
        String name = input.nextToken();
        if(!input.hasMoreTokens()){
            System.out.println("Missing data in command line.");
            return;
        }
        String major_str = input.nextToken();
        if(!validMajor(major_str)){
            System.out.println("'" + major_str + "'" + " is not a valid major.");
            return;
        }
        Major major = Major.valueOf(major_str.toUpperCase());
        Profile profile = new Profile(name, major);
        Student student = null;
        if(command.matches("AR|AN|AT|AI")) {
            int credit;

            if(!input.hasMoreTokens()){
                System.out.println("Credit hours missing.");
                return;
            }

            try {
                credit = Integer.parseInt(input.nextToken());
            }catch(Exception e) {
                System.out.println("Invalid credit hours.");
                return;
            }
            
            if(!validCredit(credit)) {
                return;
            }
            
            if(command.matches("AR")){
                student = new Resident(profile, credit);
            }
            if(command.matches("AN")){
                student = new NonResident(profile, credit);
            }
            if(command.matches("AT")){
                if(!input.hasMoreTokens()){
                    System.out.println("Missing data in command line.");
                    return;
                }
                String city = input.nextToken().toUpperCase();
                if(!city.matches("NY|CT")) {
                    System.out.println("Not part of the tri-state area.");
                    return;
                }
                student = new TriState(profile, credit, city);
            }
            if(command.matches("AI")){
                boolean abroad = false;
                if(input.nextToken().equalsIgnoreCase("true")) abroad = true;
                if(!validInternationalCredit(credit)) {
                    return;
                }
                student = new International(profile, credit, abroad);
            }
            if(arr.add(student)){
                System.out.println("Student added.");
            }else{
                System.out.println("Student is already in the roster.");
            }
        }else {
            profile = new Profile(name, major);
            student = new Student(profile);
            if (command.matches("R")){
                if(arr.remove(student)){
                    System.out.println("Student removed from the roster.");
                }else{
                    System.out.println("Student is not in the roster.");
                }
            }else if(command.matches("T")){
                if(!input.hasMoreTokens()){
                    System.out.println("Payment amount missing.");
                    return;
                }
                double payment = Double.parseDouble(input.nextToken());
                if(!input.hasMoreTokens()){
                    System.out.println("Date missing.");
                    return;
                }
                Date date = new Date(input.nextToken());
                if(!date.isValid()){
                    System.out.println("Payment date invalid.");
                    return;
                }
                student.setDate(date);
                student.setTotalPayment(payment);
                if(arr.pay(student)) {
                    System.out.println("Payment applied.");
                }

            }else if(command.matches("S")){
                if(arr.setStatus(student)) {
                    System.out.println("Tuition updated.");
                }
                else {
                    System.out.println("Couldn't find the international student.");
                }

            }else if(command.matches("F")){
                if(!input.hasMoreTokens()){
                    System.out.println("Missing the amount.");
                    return;
                }
                double aid = Double.parseDouble(input.nextToken());
                student.setAid(aid);
                if(arr.financialAid(student)) {
                    System.out.println("Tuition updated");
                }

            }
        }



    }

    private boolean notValid(String command){
        if(command.matches("AR|AN|AT|AI|R|T|S|F|P|PN|PT|C|Q")) return true;
        else return false;
    }

    private boolean isPrint(String command){
        switch(command) {
            case "P":
                arr.print();
                return true;
            case "PN":
                arr.printName();
                return true;
            case "PT":
                arr.printPaymentDate();
                return true;
            case "C":
                if(arr.calculate()) {
                    System.out.println("Calculation completed.");
                }
                else {
                    System.out.println("Student roster is empty!");
                }
                return true;
            case "Q":
                running = false;
                System.out.println("Tuition Manager terminated.");
                return true;
        }
        return false;
    }

    private boolean validMajor(String major){
        switch(major.toUpperCase()) {
            case "BA":
            case "CS":
            case "EE":
            case "IT":
            case "ME":
                return true;
        }
        return false;
    }
    
    private boolean validCredit(int credit){
        int max_credits = 24;
        int min_credits = 3;
        if(credit > max_credits) {
            System.out.println("Credit hours exceed the maximum 24.");
            return false;
        }
        else if(credit < min_credits) {
            if(credit < 0){
                System.out.println("Credit hours cannot be negative.");
            }
            else {
                System.out.println("Minimum credit hours is 3.");
            }
            return false;
        }
        return true;
    }
    
    private boolean validInternationalCredit(int credit){
        int min_credits = 12;
        if(credit < min_credits) {
            System.out.println("International students must enroll at least 12 credits.");
            return false;
        }
        return true;
    }
}
