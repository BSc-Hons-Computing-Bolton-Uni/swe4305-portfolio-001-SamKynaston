package core;

import objects.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final Scanner reader = new Scanner(System.in);
    public static final ArrayList<Student> Students = new ArrayList<>();
    public static final ArrayList<objects.Module> Modules = new ArrayList<>();
    public static final ArrayList<Course> Courses = new ArrayList<>();

    private static void DeploySampleData() {
        // Student 1
        Student student1 = new Student(1001);
        student1.SetForename("Sam");
        student1.SetSurname("Kynaston");

        // Student 2
        Student student2 = new Student(1002);
        student2.SetForename("Melissa");
        student2.SetSurname("Stephens");

        // Courses
        // Computing (G400)
        Course course1 = new Course("G400");
        course1.SetName("BSc (Hons) Computing");

        student1.AddCourse(course1);
        student2.AddCourse(course1);

        // Computing (G400) Modules
        course1.AddModule(new objects.Module("COM4301")); // Maths for Computing
        course1.AddModule(new objects.Module("COM4302")); // Computer Science Fundamentals
        course1.AddModule(new objects.Module("SWE4303")); // Computing Infrastructure
        course1.AddModule(new objects.Module("SWE4304")); // Databases
        course1.AddModule(new objects.Module("SWE4305")); // Object Oriented Programming
        course1.AddModule(new objects.Module("SWE5306")); // Systems Analysis and Design
        course1.AddModule(new objects.Module("SWE5307")); // Web Design and Programming
        course1.AddModule(new objects.Module("SWE5308")); // Cloud Technologies
        course1.AddModule(new objects.Module("COM6300")); // Research and Professional Issues
        course1.AddModule(new objects.Module("COM6301")); // Undergraduate Project
        course1.AddModule(new objects.Module("SWE6304")); // Emerging Technologies

        // Optional modules (O)
        course1.AddModule(new objects.Module("SWE5304")); // Advanced Databases and Big Data
        course1.AddModule(new objects.Module("SEC5304")); // Advanced Operating Systems
        course1.AddModule(new objects.Module("AIN5301")); // Introduction to AI
        course1.AddModule(new objects.Module("AIN6301")); // Natural Language Processing
        course1.AddModule(new objects.Module("SEC6302")); // Information Security Management
        course1.AddModule(new objects.Module("SEC6305")); // Operations Management
        course1.AddModule(new objects.Module("SWE6302")); // Applied Machine Learning
        course1.AddModule(new objects.Module("SWE6303")); // Software Quality Management
    }

    public static void main(String[] args) {
        DeploySampleData();
    }
}