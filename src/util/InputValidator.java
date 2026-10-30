package util;
import java.util.Scanner;

public class InputValidator {
    private Scanner sc;
    public InputValidator(Scanner sc){
        this.sc = sc;
    }

    //Validate integer input
    public int getValidateInteger(String message){
        while(true){
            System.out.print(message);
            if(sc.hasNextInt()){
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            }
            System.out.println("Invalid input! Please enter an integer.");
            sc.nextInt();
        }
    }

    //Validate marks
    public double getValidMarks(String message){
        while(true){
            System.out.print(message);
            if(sc.hasNextDouble()){
                double marks = sc.nextDouble();
                sc.nextLine();
                if(Double.isFinite(marks) && marks >= 0 && marks <= 100){
                    return marks;
                }
                System.out.println("Marks must be between 0 and 100!");
            }
            else{
                System.out.println("Invalid input! Enter numeric marks.");
                sc.nextLine();
            }
        }
    }

    //Validate non-empty string
    public String getValidString(String message){
        while(true){
            System.out.print(message);
            String value = sc.nextLine().trim();
            if(!value.isEmpty()){
                return value;
            }
            System.out.println("Input cannot be empty!");
        }
    }
}
