package menus;

import actions.ModuleManagerAction;
import objects.*;
import objects.Module;

import java.util.Scanner;

import static core.Main.Modules;

public class ModuleListMenu extends AbstractMenu {
    public ModuleListMenu(Scanner Input) {
        super(Input, "Manage a Module");

        for (Module module : Modules) {
            MenuOption ModuleHandler = new MenuOption(module.GetCode() + " (" + module.GetCourse().GetCode() + ")", new ModuleManagerAction(module));
            AddOption(ModuleHandler);
        }
    }
}
