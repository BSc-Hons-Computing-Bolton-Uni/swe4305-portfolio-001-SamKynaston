package menus;

import actions.AddStudentAction;
import actions.StudentManagerAction;
import objects.AbstractMenu;
import objects.MenuAction;
import objects.MenuOption;
import objects.Student;

import java.util.Scanner;

import static core.Main.Students;

public class StudentListMenu extends AbstractMenu {
    public StudentListMenu(Scanner Input) {
        super(Input, "Manage a Student");

        for (Student student : Students) {
            MenuOption StudentHandler = new MenuOption("Manage Student " + student.GetForename() + " " + student.GetSurname() + " (" + student.GetID() + ")", new StudentManagerAction(student));
            AddOption(StudentHandler);
        }

        // Add a new Student Option
        MenuOption AddStudentOption = new MenuOption("Add a New Student", new AddStudentAction());
        AddOption(AddStudentOption);
    }
}
