package actions;

import menus.ManageCourseMenu;
import objects.MenuAction;
import objects.MenuActionContext;
import objects.Course;

public class CourseManagerAction implements MenuAction {
    Course Course;

    public CourseManagerAction(Course course) {
        this.Course = course;
    }

    @Override
    public void Execute() {
        MenuActionContext Context = GetContext();
        new ManageCourseMenu(Context.GetReader(), "Manage " + Course.GetName() + " (" + Course.GetCode() + ")", Course);
    }
}
