package actions;

import core.Main;
import objects.Course;
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

        for (Course course : Student.GetCourses()) {
            course.RemoveStudent(Student);
        }

        MenuManager.GoBack();
        MenuManager.GoBack();
        MenuManager.AddMenu(new menus.StudentListMenu(Context.GetReader()));

        System.out.println("Student has been removed from the system.");
    }
}
