package actions;

import core.MenuManager;
import objects.*;

public class RemoveFromCourseAction implements MenuAction {
    Course Course;
    Student Student;

    public RemoveFromCourseAction(Course course, Student student) {
        this.Course = course;
        this.Student = student;
    }

    @Override
    public void Execute() {
        Course.RemoveStudent(Student);

        MenuManager.GoToFirstPage();
        System.out.println(Student.GetForename() + " " + Student.GetSurname() + " removed from course.");
    }
}
