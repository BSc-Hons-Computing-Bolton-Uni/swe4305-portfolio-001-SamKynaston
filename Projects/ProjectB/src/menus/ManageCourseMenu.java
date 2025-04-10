package menus;

import actions.ManageCourseAction;
import objects.*;

import java.util.Scanner;

public class ManageCourseMenu extends AbstractMenu {
    public ManageCourseMenu(Scanner Input, String name, Course course) {
        super(Input, name);

        System.out.println("Registered Students: " + course.GetStudents().size());

        class RemoveStudentOption implements MenuAction {
            @Override
            public void Execute() {
                new RemoveStudentFromCourseMenu(Input, course);
            }
        };

        class AddStudentOption implements MenuAction {
            @Override
            public void Execute() {
                new AddStudentToCourseMenu(Input, course);
            }
        };

        MenuOption ModifyCourseName = new MenuOption("Modify course name", new ManageCourseAction(course));
        MenuOption RemoveStudentFromCourse = new MenuOption("Remove Student", new RemoveStudentOption());
        MenuOption AddStudentToCourse = new MenuOption("Add Student", new AddStudentOption());

        // Add Options
        AddOption(ModifyCourseName);
        AddOption(RemoveStudentFromCourse);
        AddOption(AddStudentToCourse);
    }
}
