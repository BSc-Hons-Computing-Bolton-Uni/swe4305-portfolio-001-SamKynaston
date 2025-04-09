package core;

import menus.*;
import objects.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final Scanner reader = new Scanner(System.in);
    public static final ArrayList<Student> Students = new ArrayList<>();
    public static final ArrayList<Student> Modules = new ArrayList<>();
    public static final ArrayList<Student> Courses = new ArrayList<>();
    public static AbstractMenu Menu;

    private static void DeployTestData() {
        // Student 1
        Student student1 = new Student(1001);
        student1.SetForename("Sam");
        student1.SetSurname("Kynaston");

        // Student 2
        Student student2 = new Student(1002);
        student2.SetForename("Melissa");
        student2.SetSurname("Stephens");

        Students.add(student1);
        Students.add(student2);
    }

    public static void main(String[] args) {
        DeployTestData();

        // Initialize Menu Context
        MenuActionContext.New(reader);

        MenuManager.AddMenu(new MainMenu());
        MenuManager.Start();

        /*
        // Manage objects.Student menus.Menu Option
        MenuOption ManageStudents = new MenuOption("Manage Students");
        ManageStudents.SetAction(() -> {

            // menus.Menu for objects.Student Management
            Menu ManageStudentsMenu = new Menu(reader);

            for (Student student : Students) {
                MenuOption StudentOption = new MenuOption(student.GetForename() + " " + student.GetSurname());

                StudentOption.SetAction(() -> {});

                ManageStudentsMenu.AddOption(StudentOption);
            }

            // menus.Menu Options
            MenuOption RemoveStudent = new MenuOption("Remove objects.Student");
        });

        // Manage objects.Course menus.Menu Option
        MenuOption ManageCourse = new MenuOption("Manage Courses");
        ManageCourse.SetAction(() -> {
            Menu ManageStudentsMenu = new Menu(reader);

        });

        // Manage objects.Module menus.Menu Option
        MenuOption ManageModules = new MenuOption("Manage Modules");
        ManageModules.SetAction(() -> {
            Menu ManageStudentsMenu = new Menu(reader);

        });

        BaseMenu.AddOption(ManageStudents);
        BaseMenu.AddOption(ManageCourse);
        BaseMenu.AddOption(ManageModules);*/
    }
}