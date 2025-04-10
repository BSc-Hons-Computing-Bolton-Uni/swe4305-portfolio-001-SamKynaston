package actions;

import core.MenuManager;
import menus.CourseListMenu;
import menus.ModuleListMenu;
import menus.StudentListMenu;
import objects.MenuAction;

import java.util.Objects;

public class MainMenuAction implements MenuAction {
    private String Action;

    public MainMenuAction(String action) {
        this.Action = action;
    }

    @Override
    public void Execute() {
        if (Objects.equals(Action, "MANAGE_STUDENTS")) {
            new StudentListMenu(Context.GetReader());
        } else if (Objects.equals(Action, "MANAGE_COURSES")) {
            new CourseListMenu(Context.GetReader());
        } else if (Objects.equals(Action, "MANAGE_MODULES")) {
            new ModuleListMenu(Context.GetReader());
        }
    }
}
