package menus;

import actions.RemoveStudentAction;
import objects.AbstractMenu;
import objects.MenuAction;
import objects.MenuOption;
import objects.Student;

import java.util.Scanner;

public class ManageStudentMenu extends AbstractMenu {
    public ManageStudentMenu(Scanner Input, Student student, String name) {
        super(Input, name);

        MenuOption RemoveStudentOption = new MenuOption("Remove this Student");
        MenuAction RemoveStudentAction = new RemoveStudentAction(student);
        RemoveStudentOption.SetAction(RemoveStudentAction);

        AddOption(RemoveStudentOption);
    }
}
