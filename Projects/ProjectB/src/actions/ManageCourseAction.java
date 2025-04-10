package actions;

import core.MenuManager;
import objects.Course;
import objects.MenuAction;
import objects.MenuActionContext;

public class ManageCourseAction implements MenuAction {
    private Course Course;

    public ManageCourseAction(Course course) {
        if (course != null) {
            this.Course = course;
        }
    }

    @Override
    public void Execute() {
        MenuActionContext Context = GetContext();
        Course course;
        boolean CoursePreviouslyExisted = false;

        if (Course == null) {
            System.out.print("Course Code: ");
            String CourseCode = Context.GetReader().next();
            course = new Course(CourseCode);
        } else {
            course = Course;
            CoursePreviouslyExisted = true;
        }

        System.out.print("Course Name: ");
        String CourseName = Context.GetReader().next();
        course.SetName(CourseName);

        if (CoursePreviouslyExisted) {
            System.out.println("Course modified.");
        } else {
            System.out.println("Course added to system.");
        }

        MenuManager.GoToFirstPage();
    }
}
