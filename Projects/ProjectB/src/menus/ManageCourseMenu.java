package menus;

import objects.*;

import java.util.Scanner;

public class ManageCourseMenu extends AbstractMenu {
    public ManageCourseMenu(Scanner Input, String name, Course course) {
        super(Input, name);

        System.out.println("Registered Students: " + course.GetStudents().size());
    }
}
