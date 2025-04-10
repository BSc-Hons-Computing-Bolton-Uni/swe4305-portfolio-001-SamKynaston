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

        System.out.print("First Name: ");
        String Forename = Context.GetReader().next();

        System.out.print("Second Name: ");
        String Surname = Context.GetReader().next();

        int latestStudentID = 999;

        if (!Students.isEmpty()) {
            latestStudentID = Students.getLast().GetID();
        }

        Student newStudent = new Student(latestStudentID+1);
        newStudent.SetForename(Forename);
        newStudent.SetSurname(Surname);

        System.out.println("Student added to system.");
        MenuManager.GoToFirstPage();
    }
}
