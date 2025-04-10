package menus;

import actions.AddStudentAction;
import actions.StudentManagerAction;
import objects.*;
import objects.Module;

import java.util.Scanner;

import static core.Main.Modules;

public class ModuleListMenu extends AbstractMenu {
    public ModuleListMenu(Scanner Input) {
        super(Input, "Manage a Module");

        for (Module module : Modules) {
            MenuOption ModuleHandler = new MenuOption(module.GetCode() + " (" + module.GetCourse().GetCode() + ")", null);
            AddOption(ModuleHandler);
        }
    }
}
