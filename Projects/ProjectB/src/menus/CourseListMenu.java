package menus;

import actions.CourseManagerAction;
import objects.*;

import java.util.Scanner;

import static core.Main.Courses;

public class CourseListMenu extends AbstractMenu {
    public CourseListMenu(Scanner Input) {
        super(Input, "Manage a Course");

        for (Course course : Courses) {
            MenuOption CourseHandler = new MenuOption(course.GetName() + " (" + course.GetCode() + ")", new CourseManagerAction(course));
            AddOption(CourseHandler);
        }
    }
}
