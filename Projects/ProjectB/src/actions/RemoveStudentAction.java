package actions;

import core.Main;
import objects.MenuAction;
import objects.MenuActionContext;
import objects.Student;

public class RemoveStudentAction implements MenuAction {
    Student Student;

    public RemoveStudentAction(Student student) {
        this.Student = student;
    }

    @Override
    public void Execute() {
        MenuActionContext Context = GetContext();

        Main.Students.remove(Student);

        core.MenuManager.GoBack();
        core.MenuManager.GoBack();
        core.MenuManager.SetMenu(new menus.StudentListMenu(Context.GetReader()));

        System.out.println("Student has been removed from the system.");
    }
}
