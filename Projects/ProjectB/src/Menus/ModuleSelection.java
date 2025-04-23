package Menus;

import Objects.SelectionMenu;
import Objects.Module;

import java.util.ArrayList;

public class ModuleSelection extends SelectionMenu<Module> {
    public ModuleSelection(ArrayList<Module> options) {
        super("Module Selection", options);
    }
}
