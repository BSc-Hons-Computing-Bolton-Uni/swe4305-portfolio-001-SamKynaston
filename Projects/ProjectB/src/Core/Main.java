package Core;

import Menus.MainMenu;
import Objects.*;
import Objects.Module;

public class Main {
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
        course1.AddModule(new Module("COM4301", "Maths for Computing", true));
        course1.AddModule(new Module("COM4302", "Computer Science Fundamentals", true));
        course1.AddModule(new Module("SWE4303", "Computing Infrastructure", true));
        course1.AddModule(new Module("SWE4304", "Databases", true));
        course1.AddModule(new Module("SWE4305", "Object Oriented Programming", true));
        course1.AddModule(new Module("SWE5306", "Systems Analysis and Design", true));
        course1.AddModule(new Module("SWE5307", "Web Design and Programming", true));
        course1.AddModule(new Module("SWE5308", "Cloud Technologies", true));
        course1.AddModule(new Module("COM6300", "Research and Professional Issues", true));
        course1.AddModule(new Module("COM6301", "Undergraduate Project", true));
        course1.AddModule(new Module("SWE6304", "Emerging Technologies", true));

        // Optional modules (O)
        course1.AddModule(new Module("SWE5304", "Advanced Databases and Big Data", false));
        course1.AddModule(new Module("SEC5304", "Advanced Operating Systems", false));
        course1.AddModule(new Module("AIN5301", "Introduction to AI", false));
        course1.AddModule(new Module("AIN6301", "Natural Language Processing", false));
        course1.AddModule(new Module("SEC6302", "Information Security Management", false));
        course1.AddModule(new Module("SEC6305", "Operations Management", false));
        course1.AddModule(new Module("SWE6302", "Applied Machine Learning", false));
        course1.AddModule(new Module("SWE6303", "Software Quality Management", false));

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
            System.out.println("- " + Repository.GetStudents().size() + " University Students");
            System.out.println("- " + Repository.GetCourses().size() + " University Courses");
            System.out.println("- " + Repository.GetModules().size() + " Total University Modules");
            System.out.println();

            Action result = menu.Execute(); // menu.Execute() runs once

            if (result == null) {
                break;
            }
        }
    }
}