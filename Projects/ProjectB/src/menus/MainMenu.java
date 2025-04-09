package menus;

import actions.MainMenuAction;
import objects.*;

import static core.Main.Students;

public class MainMenu extends AbstractMenu {
    public MainMenu() {
        super(MenuActionContext.GetContext().GetReader(), "University Manager");

        // Manage Students Option
        MenuOption ManageStudents = new MenuOption("Manage Students", new MainMenuAction("MANAGE_STUDENTS"));

        // Manage Courses Option
        MenuOption ManageCourses = new MenuOption("Manage Courses", null);

        // Manage Modules Option
        MenuOption ManageModules = new MenuOption("Manage Modules", null);

        AddOption(ManageCourses);
        AddOption(ManageModules);
        AddOption(ManageStudents);
    }
}
