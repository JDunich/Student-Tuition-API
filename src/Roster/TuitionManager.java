package Roster;

import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TuitionManager {
    Roster arr = new Roster();

    public void run(){
        System.out.println("Tuition Manager starts running.");
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.nextLine();
            StringTokenizer input = new StringTokenizer(s, ",");
            if(notValid(s)){
                System.out.println("Command '" + s + "' not supported!");
                continue;
            }

            String command = input.nextToken();
            if(isPrint(command)) continue;
            else{
                if(badInfo) continue;
                else task(command, input);
            }

        }
    }
    
    private Student task(String command, StringTokenizer input){
        String name = input.nextToken();
        Major major = Major.valueOf((input.nextToken()).toUpperCase());
        Profile profile = null;
        Student student = null;
        if(command.matches("AR|AN|AT|AI")) {
            int credit = Integer.parseInt(input.nextToken());
            if(command.matches("AR")){
                profile = new Profile(name, major);
                student = new Resident(profile, credit);
            }
            if(command.matches("AN")){
                profile = new Profile(name, major);
                student = new NonResident(profile, credit);
            }
            if(command.matches("AT")){
                String city = input.nextToken();
                profile = new Profile(name, major);
                student = new TriState(profile, credit, city);
            }
            if(command.matches("AI")){
                boolean abroad = false;
                if(input.nextToken().equalsIgnoreCase("true")) abroad = true; 
                profile = new Profile(name, major);
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
                double payment = Double.parseDouble(input.nextToken());
                Date date = new Date(input.nextToken());
                
                //find student, if not found, exit and print failure method
                //check if date valid, if date invalid, exit and print 
                //use setDate method
                //use setPayment method
                //print tuition updated
                

            }else if(command.matches("S")){
                //find international student
                
                //implement setStatus() method

            }else if(command.matches("F")){
                

            }
        }



    }
}
