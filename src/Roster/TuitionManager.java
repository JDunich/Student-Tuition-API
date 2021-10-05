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
        Major major = Major.valueOf(input.nextToken());
        Student student;
        if(command.matches("AR|AN|AT|AI")) {
            int credit = Integer.parseInt(input.nextToken());
            if(command.matches("AR")){
                return student = new Resident(name, major, credit);
            }
            if(command.matches("AN")){
                return student = new NonResident(name, major, credit);
            }
            if(command.matches("AT")){
                String city = input.nextToken();
                return student = new TriState(name, major, credit, city);
            }
            if(command.matches("AT")){
                if(input.nextToken().equalsIgnoreCase("true"))
                return student = new TriState(name, major, credit, city);
            }
        }



    }
}
