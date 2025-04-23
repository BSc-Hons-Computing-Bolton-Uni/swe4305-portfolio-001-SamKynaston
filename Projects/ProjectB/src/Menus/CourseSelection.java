package Menus;

import Objects.SelectionMenu;
import Objects.Course;

import java.util.ArrayList;

public class CourseSelection extends SelectionMenu<Course> {
    public CourseSelection(ArrayList<Course> options) {
        super("Select a Course", options);
    }
}
