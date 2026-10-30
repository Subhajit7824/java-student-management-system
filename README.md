Student Management System

A simple console-based Student Management System developed using Java. This project allows users to manage student records efficiently through basic CRUD (Create, Read, Update, Delete) operations.

Features
Add new student records.
View all student details.
Search students by ID.
Update student information.
Delete individual or all student records.
Input validation to prevent invalid entries.
File handling for permanent data storage.
Technologies Used
Java
OOP Concepts
ArrayList (Java Collections)
Java File I/O
CSV-style text file storage
Project Architecture

The project follows a modular, layered structure:

model – Student data representation.
service – Business logic and student operations.
repository – File reading and writing.
util – Input validation.
app – Application entry point.
How to Run

Compile the project:

bash
javac -d out $(find src -name "*.java")


Run the application:

bash
java -cp out app.Main

Learning Objectives

This project was developed to gain practical experience with Java, object-oriented programming, collections, file handling, input validation, and layered application architecture.

Project Status: Basic implementation completed. Future improvements may include database integration, GUI development, and advanced student analytics.