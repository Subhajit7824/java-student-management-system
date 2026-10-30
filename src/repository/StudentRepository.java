package repository;
import java.io.*;
import java.util.ArrayList;
import model.Student;

public class StudentRepository {
    private final String FILE_NAME = "students.txt";

    //Save all students into the file
    public void saveStudents(ArrayList<Student> students){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            for(Student student : students){
                writer.write(
                    student.get_id() + "," +
                    student.get_name() + "," +
                    student.get_marks() + "," +
                    student.get_grade()
                );
                writer.newLine();
            }
            System.out.println("Student data saved successfully!");
        } catch (IOException e){
            System.err.println("Error saving student data: " + e.getMessage());
        }
    }

    //Load all students from the file
    public ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);
        if(!file.exists()){
            return students;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(",", -1);
                if(data.length == 4){
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    double marks = Double.parseDouble(data[2]);
                    String grade = data[3];

                    Student student = new Student(id, name, marks, grade);
                    students.add(student);
                }
            }
        } catch (IOException | NumberFormatException e){
            System.out.println("Error loading student data: " + e.getMessage());
        }
        return students;
    }

    //Delete all records from the file 
    public void deleteAllStudents(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            //Opening the file in write mode clears its contents.
            System.out.println("All student records removed from file!");
        } catch (IOException e){
            System.out.println("Error deleting student records: " + e.getMessage());
        }
    }
}

