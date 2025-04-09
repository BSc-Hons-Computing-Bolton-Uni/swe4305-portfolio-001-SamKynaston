package menus;

import actions.InitialStudentAction;
import objects.*;

import static core.Main.Students;

public class MainMenu extends AbstractMenu {
    public MainMenu() {
        super(MenuActionContext.GetContext().GetReader(), "University Manager");

        for (Student student : Students) {
            MenuOption StudentHandler = new MenuOption(student.GetForename() + " " + student.GetSurname());

            MenuAction StudentAction = new InitialStudentAction(student);
            StudentHandler.SetAction(StudentAction);

            AddOption(StudentHandler);
        }
    }
}
