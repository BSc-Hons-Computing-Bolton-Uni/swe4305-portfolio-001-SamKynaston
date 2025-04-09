package menus;

import actions.MainMenuAction;
import objects.*;

import static core.Main.Students;

public class MainMenu extends AbstractMenu {
    public MainMenu() {
        super(MenuActionContext.GetContext().GetReader(), "University Manager");

        // Manage Students Option
        MenuOption ManageStudents = new MenuOption("Manage a Student");
        MainMenuAction ManageStudentsAction = new MainMenuAction("MANAGE_STUDENTS");
        ManageStudents.SetAction(ManageStudentsAction);

        AddOption(ManageStudents);
    }
}
