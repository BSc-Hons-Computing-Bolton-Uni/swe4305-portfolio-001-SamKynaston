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

        System.out.println("Student has been removed from the system.");
    }
}
