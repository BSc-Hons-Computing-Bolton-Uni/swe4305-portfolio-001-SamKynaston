package menus;

import actions.ManageStudentAction;
import actions.RemoveStudentAction;
import objects.AbstractMenu;
import objects.MenuOption;
import objects.Student;

import java.util.Scanner;

public class ManageStudentMenu extends AbstractMenu {
    public ManageStudentMenu(Scanner Input, Student student, String name) {
        super(Input, name);

        MenuOption ModifyStudentName = new MenuOption("Modify student's name", new ManageStudentAction(student));
        MenuOption AddStudentToCourse = new MenuOption("Register student to course", null);
        MenuOption AddMarkToStudent = new MenuOption("Register student grade", null);
        MenuOption RemoveStudentOption = new MenuOption("Remove this Student", new RemoveStudentAction(student));

        // Add Options
        AddOption(ModifyStudentName);
        AddOption(AddStudentToCourse);
        AddOption(AddMarkToStudent);
        AddOption(RemoveStudentOption);
    }
}
