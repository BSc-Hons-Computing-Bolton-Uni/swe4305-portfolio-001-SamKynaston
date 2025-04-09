package actions;

import core.MenuManager;
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
        }
    }
}
