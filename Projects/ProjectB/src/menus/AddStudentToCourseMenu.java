package menus;

import actions.AddToCourseAction;
import core.Main;
import objects.AbstractMenu;
import objects.Course;
import objects.MenuOption;
import objects.Student;

import java.util.Scanner;

public class AddStudentToCourseMenu extends AbstractMenu {
    public AddStudentToCourseMenu(Scanner Input, Course course) {
        super(Input, "Add a Student");

        for (Student student : Main.Students) {
            MenuOption StudentHandler = new MenuOption(student.GetForename() + " " + student.GetSurname() + " (" + student.GetID() + ")", new AddToCourseAction(course, student));
            AddOption(StudentHandler);
        }
    }
}
