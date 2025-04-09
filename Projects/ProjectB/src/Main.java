import menus.*;
import objects.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final Scanner reader = new Scanner(System.in);
    private static final ArrayList<Student> Students = new ArrayList<>();
    private static final ArrayList<Student> Modules = new ArrayList<>();
    private static final ArrayList<Student> Courses = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize menus.Menu Context
        MenuActionContext.New(reader);

        // Just testing new menu class
        Menu BaseMenu = new MainMenu(reader);

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

        BaseMenu.Display();
    }
}