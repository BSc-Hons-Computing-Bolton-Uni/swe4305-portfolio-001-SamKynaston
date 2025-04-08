import java.util.Scanner;

public class MenuOption {
    private String name;
    private MenuAction action;

    public void SetName(String newName) {
        this.name = newName;
    }

    public String GetName() {
        return this.name;
    }

    public void SetAction(MenuAction action) {
        this.action = action;
    }

    public void Execute(Scanner input) {
        action.execute(input);
    }
}
