package model;

public class Student {
    private int id;
    private String name;
    private double marks;
    private String grade;

    public Student(int id, String name, double marks, String grade) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.grade = grade;
    }

    public int get_id() {
        return id;
    }

    public String get_name() {
        return name;
    }

    public double get_marks() {
        return marks;
    }

    public String get_grade() {
        return grade;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void set_marks(double marks) {
        this.marks = marks;
    }

    public void set_grade(String grade) {
        this.grade = grade;
    }
}