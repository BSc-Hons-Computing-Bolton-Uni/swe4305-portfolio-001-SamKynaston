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
        Student student1 = new Student();
        student1.SetForename("Sam");
        student1.SetSurname("Kynaston");

        // Student 2
        Student student2 = new Student();
        student2.SetForename("Melissa");
        student2.SetSurname("Stephens");

        // Courses
        // Computing (G400)
        Course course1 = new Course("G400");
        course1.SetName("BSc (Hons) Computing");

        // Computing (G400) Modules
        course1.AddModule(new Module("COM4301", true)); // Maths for Computing
        course1.AddModule(new Module("COM4302", true)); // Computer Science Fundamentals
        course1.AddModule(new Module("SWE4303", true)); // Computing Infrastructure
        course1.AddModule(new Module("SWE4304", true)); // Databases
        course1.AddModule(new Module("SWE4305", true)); // Object Oriented Programming
        course1.AddModule(new Module("SWE5306", true)); // Systems Analysis and Design
        course1.AddModule(new Module("SWE5307", true)); // Web Design and Programming
        course1.AddModule(new Module("SWE5308", true)); // Cloud Technologies
        course1.AddModule(new Module("COM6300", true)); // Research and Professional Issues
        course1.AddModule(new Module("COM6301", true)); // Undergraduate Project
        course1.AddModule(new Module("SWE6304", true)); // Emerging Technologies

        // Optional modules (O)
        course1.AddModule(new Module("SWE5304", false)); // Advanced Databases and Big Data
        course1.AddModule(new Module("SEC5304", false)); // Advanced Operating Systems
        course1.AddModule(new Module("AIN5301", false)); // Introduction to AI
        course1.AddModule(new Module("AIN6301", false)); // Natural Language Processing
        course1.AddModule(new Module("SEC6302", false)); // Information Security Management
        course1.AddModule(new Module("SEC6305", false)); // Operations Management
        course1.AddModule(new Module("SWE6302", false)); // Applied Machine Learning
        course1.AddModule(new Module("SWE6303", false)); // Software Quality Management

        // Add Students to Course
        student1.AddCourse(course1);
        student2.AddCourse(course1);
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