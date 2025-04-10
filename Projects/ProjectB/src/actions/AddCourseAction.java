package actions;

import core.MenuManager;
import objects.Course;
import objects.MenuAction;
import objects.MenuActionContext;

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

        System.out.println("Course added to system.");
        MenuManager.GoToFirstPage();
    }
}
