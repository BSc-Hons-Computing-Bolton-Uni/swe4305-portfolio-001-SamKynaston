package objects;

public class MenuOption {
    private String name;
    private MenuAction action;

    public MenuOption(String name) {
        SetName(name);
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
