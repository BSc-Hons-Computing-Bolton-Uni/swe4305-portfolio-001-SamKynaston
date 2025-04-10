package actions;

import menus.ManageModuleMenu;
import objects.MenuAction;
import objects.MenuActionContext;
import objects.Module;

public class ModuleManagerAction implements MenuAction {
    Module Module;

    public ModuleManagerAction(Module module) {
        this.Module = module;
    }

    @Override
    public void Execute() {
        MenuActionContext Context = GetContext();
        new ManageModuleMenu(Context.GetReader(), "Manage " + Module.GetCode() + " (Course: " + Module.GetCourse().GetCode() + " )", Module);
    }
}
