package menus;

import actions.RemoveFromCourseAction;
import objects.AbstractMenu;
import objects.Course;
import objects.MenuOption;
import objects.Student;

import java.util.Scanner;

public class RemoveStudentFromCourseMenu extends AbstractMenu {
    public RemoveStudentFromCourseMenu(Scanner Input, Course course) {
        super(Input, "Remove a Student");

        for (Student student : course.GetStudents()) {
            MenuOption StudentHandler = new MenuOption(student.GetForename() + " " + student.GetSurname() + " (" + student.GetID() + ")", new RemoveFromCourseAction(course, student));
            AddOption(StudentHandler);
        }
    }
}
