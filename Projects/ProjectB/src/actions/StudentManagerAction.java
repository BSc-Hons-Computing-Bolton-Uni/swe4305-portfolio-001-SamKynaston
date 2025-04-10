package actions;

import core.MenuManager;
import menus.ManageStudentMenu;
import objects.*;

public class StudentManagerAction implements MenuAction {
    Student Student;

    public StudentManagerAction(Student student) {
        this.Student = student;
    }

    @Override
    public void Execute() {
        MenuActionContext Context = GetContext();
        new ManageStudentMenu(Context.GetReader(), Student, "Manage Student " + Student.GetForename() + " " + Student.GetSurname() + " (" + Student.GetID() + ")");
    }
}
