package actions;

import core.MenuManager;
import objects.MenuAction;
import objects.MenuActionContext;
import objects.Student;

import static core.Main.Students;

public class AddStudentAction implements MenuAction {
    @Override
    public void Execute() {
        MenuActionContext Context = GetContext();

        System.out.println("What is this student's first name?");
        String Forename = Context.GetReader().next();

        System.out.println("What is this student's surname?");
        String Surname = Context.GetReader().next();

        int latestStudentID = Students.getLast().GetID();

        Student newStudent = new Student(latestStudentID+1);
        newStudent.SetForename(Forename);
        newStudent.SetSurname(Surname);

        Students.add(newStudent);
        System.out.println("Student added to system.");

        MenuManager.GoBack();
    }
}
