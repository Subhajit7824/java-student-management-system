package service;
import java.util.ArrayList;
import java.util.Scanner;
import model.Student;
import repository.StudentRepository;
import util.InputValidator;


public class StudentManager {

    private ArrayList<Student> students;
    private Scanner sc;
    private StudentRepository repository;
    private InputValidator validator;

    public StudentManager(Scanner sc) {
        this.sc = sc;
        validator = new InputValidator(sc);
        repository = new StudentRepository();
        //Load previously saved students
        students = repository.loadStudents();
    }

    public void addStudent() {
        int id;
        //Validate unique student ID
        while(true){
            id = validator.getValidateInteger("Enter student ID: ");
            if(id <= 0){
                System.out.println("Student ID must be positive!");
                continue;
            }
            boolean exists = false;
            for(Student student : students){
                if(student.get_id() == id){
                    exists = true;
                    break;
                }
            }
            if(!exists){
                break;
            }
            System.out.println("Student ID already exits!");
        }

        String name = validator.getValidString("Enter student name: ");
        double marks = validator.getValidMarks("Enter student marks (0-100): ");
        String grade = validator.getValidString("Enter student grade: ");


        Student newStudent = new Student(id, name, marks, grade);
        students.add(newStudent);

        //Save changes to file
        repository.saveStudents(students);

        System.out.println("Student details added successfully!");
    }

    public void deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).get_id() == id) {
                students.remove(i);
                repository.saveStudents(students);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student with ID: " + id + " not found.");
    }

    public void seeStudentList() {
        System.out.println("ID\tName\t\tMarks\tGrade");

        for (int i = 0; i < students.size(); i++) {
            System.out.println(
                students.get(i).get_id() + "\t" +
                students.get(i).get_name() + "\t" +
                students.get(i).get_marks() + "\t" +
                students.get(i).get_grade()
            );
        }
    }

    public void findStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (student.get_id() == id) {
                System.out.println("Student is found");
                System.out.println("Student Details");
                System.out.println("ID: " + student.get_id());
                System.out.println("Name: " + student.get_name());
                System.out.println("Marks: " + student.get_marks());
                System.out.println("Grade: " + student.get_grade());
                return;
            }
        }

        System.out.println("Student with ID: " + id + " not found.");
    }

    public void updateStudentDetails(int id) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (student.get_id() == id) {
                System.out.println("Student found!");
                String name = validator.getValidString("Enter new name: ");
                double marks = validator.getValidMarks("Enter new marks (0-100): ");
                String grade = validator.getValidString("Enter new grade: ");

                student.set_name(name);
                student.set_marks(marks);
                student.set_grade(grade);

                //Save updated details 
                repository.saveStudents(students);

                System.out.println(
                    "Student details are updated successfully."
                );
                return;
            }
        }

        System.out.println("Student with ID: " + id + " not found.");
    }

    public void deleteAllStudent() {
        students.clear();
        repository.deleteAllStudents();
        System.out.println("Student list is deleted successfully!");
    }
}