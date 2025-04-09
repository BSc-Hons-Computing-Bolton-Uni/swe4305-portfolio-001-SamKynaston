package objects;

import core.Main;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class AbstractMenu implements Menu {
    private final ArrayList<MenuOption> Options = new ArrayList<>();
    private String Name;
    private Scanner UserInput;
    private boolean Quit = false;
    public boolean isMain = false;

    public AbstractMenu(Scanner Input, String name) {
        this.UserInput = Input;
        this.Name = name;

        MenuOption CloseOption = new MenuOption("Exit");

        AddOption(CloseOption);
    }

    @Override
    public void AddOption(MenuOption option) {
        Options.add(option);
    }

    @Override
    public void RemoveOption(MenuOption option) {
        Options.remove(option);
    }

    @Override
    public void Display() {
        System.out.println(Name);
        System.out.println("");

        for (int choice = 1; choice < Options.size() ;choice++) {
            MenuOption Option = Options.get(choice);
            System.out.println(choice + ". " + Option.GetName());
        }

        MenuOption Close = Options.getFirst();
        System.out.println("0. " + Close.GetName());
        System.out.println("");

        InputHandler();
    }

    private boolean UserDecisionHandler(int choice) {
        if (choice > 0 && choice < Options.size()) {
            MenuOption option = Options.get(choice);
            option.ExecuteAction();
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
