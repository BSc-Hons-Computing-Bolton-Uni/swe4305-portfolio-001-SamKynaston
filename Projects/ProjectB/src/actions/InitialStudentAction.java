package actions;

import menus.ManageStudentMenu;
import objects.*;

public class InitialStudentAction implements MenuAction {
    Student Student;

    public InitialStudentAction(Student student) {
        this.Student = student;
    }

    @Override
    public void Execute() {
        MenuActionContext Context = GetContext();
        new ManageStudentMenu(Context.GetReader(), Student, "Manage Student " + Student.GetForename() + " " + Student.GetSurname() + "(" + Student.GetID() + ")").Display();
    }
}
