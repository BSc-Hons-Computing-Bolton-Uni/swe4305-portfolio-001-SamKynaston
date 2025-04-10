package actions;

import core.MenuManager;
import objects.Course;
import objects.MenuAction;
import objects.MenuActionContext;
import objects.Student;

import static core.Main.Courses;
import static core.Main.Students;

public class AddCourseAction implements MenuAction {

    @Override
    public void Execute() {
        MenuActionContext Context = GetContext();

        System.out.print("Course Code: ");
        String CourseCode = Context.GetReader().next();

        System.out.print("Course Name: ");
        String CourseName = Context.GetReader().next();

        Course newCourse = new Course(CourseCode);
        newCourse.SetName(CourseName);

        System.out.println("Student added to system.");
        MenuManager.GoToFirstPage();
    }
}
