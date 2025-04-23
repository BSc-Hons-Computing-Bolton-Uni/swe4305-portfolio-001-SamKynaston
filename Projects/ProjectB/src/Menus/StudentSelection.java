package Menus;

import Objects.SelectionMenu;
import Objects.Student;

import java.util.ArrayList;

public class StudentSelection extends SelectionMenu<Student> {
    public StudentSelection(ArrayList<Student> options) {
        super("Select a Student", options);
    }
}
