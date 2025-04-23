package Core;

import Menus.MainMenu;
import Objects.*;
import Objects.Module;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final ArrayList<Student> Students = new ArrayList<>();
    public static final ArrayList<Module> Modules = new ArrayList<>();
    public static final ArrayList<Course> Courses = new ArrayList<>();

    public static void ClearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

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
        course1.AddModule(new Module("COM4301")); // Maths for Computing
        course1.AddModule(new Module("COM4302")); // Computer Science Fundamentals
        course1.AddModule(new Module("SWE4303")); // Computing Infrastructure
        course1.AddModule(new Module("SWE4304")); // Databases
        course1.AddModule(new Module("SWE4305")); // Object Oriented Programming
        course1.AddModule(new Module("SWE5306")); // Systems Analysis and Design
        course1.AddModule(new Module("SWE5307")); // Web Design and Programming
        course1.AddModule(new Module("SWE5308")); // Cloud Technologies
        course1.AddModule(new Module("COM6300")); // Research and Professional Issues
        course1.AddModule(new Module("COM6301")); // Undergraduate Project
        course1.AddModule(new Module("SWE6304")); // Emerging Technologies

        // Optional modules (O)
        course1.AddModule(new Module("SWE5304")); // Advanced Databases and Big Data
        course1.AddModule(new Module("SEC5304")); // Advanced Operating Systems
        course1.AddModule(new Module("AIN5301")); // Introduction to AI
        course1.AddModule(new Module("AIN6301")); // Natural Language Processing
        course1.AddModule(new Module("SEC6302")); // Information Security Management
        course1.AddModule(new Module("SEC6305")); // Operations Management
        course1.AddModule(new Module("SWE6302")); // Applied Machine Learning
        course1.AddModule(new Module("SWE6303")); // Software Quality Management
    }

    public static void main(String[] args) {
        DeploySampleData();

        // Test Option Menu
        OptionMenu<Action> menu = new MainMenu();

        while (true) {
            ClearScreen();
            System.out.println();
            System.out.println("- " + Students.size() + " University Students");
            System.out.println("- " + Courses.size() + " University Courses");
            System.out.println("- " + Modules.size() + " Total University Modules");
            System.out.println();

            Action result = menu.Execute(); // menu.Execute() runs once

            if (result == null) {
                break;
            }
        }
    }
}