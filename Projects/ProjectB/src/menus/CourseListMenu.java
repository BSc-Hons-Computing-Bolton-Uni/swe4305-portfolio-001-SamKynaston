package menus;

import actions.AddStudentAction;
import actions.StudentManagerAction;
import objects.*;

import java.util.Scanner;

import static core.Main.Courses;

public class CourseListMenu extends AbstractMenu {
    public CourseListMenu(Scanner Input) {
        super(Input, "Manage a Course");

        for (Course course : Courses) {
            MenuOption CourseHandler = new MenuOption(course.GetName() + " (" + course.GetCode() + ")", null);
            AddOption(CourseHandler);
        }
    }
}
