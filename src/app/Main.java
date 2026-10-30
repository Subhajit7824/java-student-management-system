package app;

import java.util.Scanner;
import service.StudentManager;
import util.InputValidator;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager newManager = new StudentManager(sc);
        InputValidator validator = new InputValidator(sc);

        int ch;
        int id;

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("Press 1 to add student.");
            System.out.println("Press 2 to see student list.");
            System.out.println("Press 3 to find student.");
            System.out.println("Press 4 to update student details.");
            System.out.println("Press 5 to delete student.");
            System.out.println("Press 6 to delete all students.");
            System.out.println("Press 0 to exit.");
            System.out.println("Enter your choice: ");

            if(!sc.hasNextInt()){
                System.out.println("Invalid choice! Enter a number.");
                sc.nextLine();
                continue;
            }
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    newManager.addStudent();
                    break;

                case 2:
                    newManager.seeStudentList();
                    break;

                case 3:
                    id = validator.getValidateInteger("Enter student ID: ");
                    newManager.findStudent(id);
                    break;

                case 4:
                    id = validator.getValidateInteger("Enter student ID: ");
                    newManager.updateStudentDetails(id);
                    break;

                case 5:
                    id = validator.getValidateInteger("Enter student ID: ");
                    newManager.deleteStudent(id);
                    break;

                case 6:
                    newManager.deleteAllStudent();
                    break;

                case 0:
                    sc.close();
                    return;

                default:
                    System.out.println("You have entered a wrong choice!");
                    break;
            }
        }
    }
}
