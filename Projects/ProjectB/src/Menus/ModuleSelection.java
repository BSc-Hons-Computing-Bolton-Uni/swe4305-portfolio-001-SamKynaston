package Menus;

import Objects.SelectionMenu;
import Objects.Module;

import java.util.ArrayList;

public class ModuleSelection extends SelectionMenu<Module> {
    public ModuleSelection(ArrayList<Module> options) {
        super("Module Selection", options);
    }

    public void DisplayOptions(ArrayList<Module> Options) {
        for (int option = 0; option < Options.size(); option++) {
            Module OptionClass = Options.get(option);
            System.out.println((option + 1) + ". " + OptionClass.Print() + (OptionClass.GetMandatoryStatus() ? " (*)" : ""));
        }

        System.out.println("0. Exit");
    }
}
