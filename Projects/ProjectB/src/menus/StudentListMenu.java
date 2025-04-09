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
            MenuOption StudentHandler = new MenuOption(student.GetForename() + " " + student.GetSurname());

            MenuAction StudentManagerAction = new StudentManagerAction(student);
            StudentHandler.SetAction(StudentManagerAction);

            AddOption(StudentHandler);
        }

        // Add a new Student Action
        MenuOption AddStudentOption = new MenuOption("Add a new Student");
        MenuAction AddStudentAction = new AddStudentAction();
        AddStudentOption.SetAction(AddStudentAction);

        AddOption(AddStudentOption);
    }
}
