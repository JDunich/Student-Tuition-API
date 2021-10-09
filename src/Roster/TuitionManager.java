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
            String command = input.nextToken();
            if(notValid(command)){
                System.out.println("Command '" + command + "' not supported!");
                continue;
            }

            if(isPrint(command)) continue;
            else{
                if(badInfo(s)) continue;
                else task(command, input);
            }

        }
    }
    private void task(String command, StringTokenizer input){
        String name = input.nextToken();
        Major major = Major.valueOf(input.nextToken());
        Student student = null;
        if(command.matches("AR|AN|AT|AI")) {
            int credit = Integer.parseInt(input.nextToken());
            if(command.matches("AR")){
                student = new Resident(name, major, credit);
            }
            if(command.matches("AN")){
                student = new NonResident(name, major, credit);
            }
            if(command.matches("AT")){
                String city = input.nextToken();
                student = new TriState(name, major, credit, city);
            }
            if(command.matches("AI")){
                boolean abroad = false;
                if(input.nextToken().equalsIgnoreCase("true")) abroad = true; 
                student = new International(name, major, credit, abroad);
            }
            if(arr.add(student)){
                System.out.println("Student added.");
            }else{
                System.out.println("Student is already in the roster.");
            }
        }else {
            student = new Student(name, major);
            if (command.matches("R")){
                if(arr.remove(student)){
                    System.out.println("Student removed from the roster.");
                }else{
                    System.out.println("Student is not in the roster.");
                }
            }else if(command.matches("T")){

            }else if(command.matches("S")){

            }else if(command.matches("F")){

            }
        }

    }

    private boolean notValid(String s){
        StringTokenizer temp = new StringTokenizer(s, ",");
        String command = temp.nextToken();
        return command.matches("AR|AN|AT|AI|R|T|S|F|P|PN|PT");
    }

    private boolean isPrint(String command){
        switch(command){
            case("C"):
                break;
            case("P"):
                break;
            case("PN"):
                break;
            case("PT"):
                break;

            return false;
        }
    }

    private boolean badInfo(String s){
        StringTokenizer temp = new StringTokenizer(s, ",");

    }

}
