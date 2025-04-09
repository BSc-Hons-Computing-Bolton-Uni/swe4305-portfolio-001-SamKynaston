package actions;

import core.Main;
import objects.MenuAction;
import objects.MenuActionContext;
import objects.Student;

import core.MenuManager;

public class RemoveStudentAction implements MenuAction {
    Student Student;

    public RemoveStudentAction(Student student) {
        this.Student = student;
    }

    @Override
    public void Execute() {
        MenuActionContext Context = GetContext();

        Main.Students.remove(Student);

        MenuManager.GoBack();
        MenuManager.GoBack();
        MenuManager.SetMenu(new menus.StudentListMenu(Context.GetReader()));

        System.out.println("Student has been removed from the system.");
    }
}
