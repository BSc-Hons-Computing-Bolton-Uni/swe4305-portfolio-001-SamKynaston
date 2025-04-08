import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final ArrayList<MenuOption> Options = new ArrayList<>();
    private Scanner UserInput;
    private boolean Quit = false;

    public Menu(Scanner Input) {
        this.UserInput = Input;

        MenuOption CloseOption = new MenuOption();
        CloseOption.SetName("Exit");

        AddOption(CloseOption);
    }

    public void AddOption(MenuOption option) {
        Options.add(option);
    }

    public void RemoveOption(MenuOption option) {
        Options.remove(option);
    }

    public void Display() {
        for (int choice = 1; choice < Options.size() ;choice++) {
            MenuOption Option = Options.get(choice);
            System.out.println(choice + ". " + Option.GetName());
        }

        MenuOption Close = Options.getFirst();
        System.out.println("0. " + Close.GetName());

        InputHandler();
    }

    private boolean UserDecisionHandler(int choice) {
        if (choice >= 0 && choice < Options.size()) {
            MenuOption option = Options.get(choice);
            option.Execute(UserInput);
        }

        return true;
    }

    private void InputHandler() {
        while (!Quit) {
            System.out.println("Select an option from one of the choices above.");
            int choice = UserInput.nextInt();

            if (UserDecisionHandler(choice)) {
                Quit = true;
            }
        }
    }
}
