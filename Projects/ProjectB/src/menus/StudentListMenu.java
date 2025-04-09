package menus;

import actions.InitialStudentAction;
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

            MenuAction StudentAction = new InitialStudentAction(student);
            StudentHandler.SetAction(StudentAction);

            AddOption(StudentHandler);
        }
    }
}
