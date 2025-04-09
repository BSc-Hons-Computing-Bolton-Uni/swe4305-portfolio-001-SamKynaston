package objects;

import core.MenuManager;

public class MenuOption {
    private String name;
    private MenuAction action;

    public MenuOption(String name, MenuAction action) {
        SetName(name);

        if (action != null) {
            SetAction(action);
        } else {
            SetAction(new MenuAction() {
                @Override
                public void Execute() {
                    System.out.println("TO BE IMPLEMENTED");
                    MenuManager.GoToFirstPage();
                }
            });
        }
    }

    public void SetName(String newName) {
        this.name = newName;
    }

    public String GetName() {
        return this.name;
    }

    public void SetAction(MenuAction action) {
        this.action = action;
    }

    public void ExecuteAction() {
        action.Execute();
    }
}
