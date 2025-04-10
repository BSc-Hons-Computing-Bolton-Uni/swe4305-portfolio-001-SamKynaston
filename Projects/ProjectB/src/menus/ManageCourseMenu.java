package menus;

import actions.ManageCourseAction;
import objects.*;

import java.util.Scanner;

public class ManageCourseMenu extends AbstractMenu {
    public ManageCourseMenu(Scanner Input, String name, Course course) {
        super(Input, name);

        System.out.println("Registered Students: " + course.GetStudents().size());

        MenuOption ModifyCourseName = new MenuOption("Modify course name", new ManageCourseAction(course));

        // Add Options
        AddOption(ModifyCourseName);
    }
}
