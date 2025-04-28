package Menus;

import Core.Main;
import Core.Repository;
import Objects.*;
import Objects.Module;

import java.util.ArrayList;

public class MainMenu extends OptionMenu<Action> {
    public MainMenu() {
        super("University Manager");

        AddAction(new Action("Create a New Entity", () -> {
            OptionMenu<Action> CreationPrompt = new OptionMenu<>("Create a New Entity");

            CreationPrompt.AddAction(new Action("Create a New Student", () -> {
                String forename = Input.ReadStringWithLength("First Name: ", 0, 32);
                String surname = Input.ReadStringWithLength("Surname Name: ", 0, 32);

                Student newStudent = new Student();
                newStudent.SetForename(forename);
                newStudent.SetSurname(surname);
            }));

            CreationPrompt.AddAction(new Action("Create a New Course", () -> {
                String code = Input.ReadStringWithLength("Code: ", 0, 5);
                String name = Input.ReadStringWithLength("Course Name: ", 0, 128);

                Course newCourse = new Course(code);
                newCourse.SetName(name);
            }));

            CreationPrompt.AddAction(new Action("Create a New Module", () -> {
                Course assignedCourse = new CourseSelection(Repository.GetCourses()).Execute();
                String code = Input.ReadStringWithLength("Module Code: ", 0, 5);
                boolean isMandatory = Input.ReadYesNo("Is this module important?");

                Module newModule = new Module(code, isMandatory);
                newModule.SetCourse(assignedCourse);
            }));

            CreationPrompt.Execute();
        }));

        AddAction(new Action("Student Management", () -> {
            Student chosenStudent = new StudentSelection(Repository.GetStudents()).Execute();

            if (chosenStudent == null) {
                return;
            }

            OptionMenu<Action> studentMenu = new OptionMenu<>("Manage " + chosenStudent.GetForename() + " " + chosenStudent.GetSurname());

            studentMenu.AddAction(new Action("Change Name", () -> {
                String forename = Input.ReadStringWithLength("First Name: ", 0, 32);
                String surname = Input.ReadStringWithLength("Surname Name: ", 0, 32);

                chosenStudent.SetForename(forename);
                chosenStudent.SetSurname(surname);
            }));

            // Remove from Course Option
            studentMenu.AddAction(new Action("Remove from Course", () -> {
                Course chosenCourse = new CourseSelection(chosenStudent.GetCourses()).Execute();

                if (chosenCourse != null) {
                    chosenStudent.RemoveCourse(chosenCourse);
                }
            }));

            // Remove Student Option
            studentMenu.AddAction(new Action("Delete Entry", () -> {
                for (Course course : new ArrayList<>(chosenStudent.GetCourses())) {
                    chosenStudent.RemoveCourse(course);
                }

                Repository.RemoveStudent(chosenStudent);
            }));

            studentMenu.Execute();
        }));

        AddAction(new Action("Course Management", () -> {
            Course chosenCourse = new CourseSelection(Repository.GetCourses()).Execute();

            if (chosenCourse == null) {
                return;
            }

            OptionMenu<Action> courseMenu = new OptionMenu<>("Manage " + chosenCourse.GetName() + " (" + chosenCourse.GetCode() + ")");

            System.out.println();
            System.out.println("Course Information: ");
            System.out.println("- " + chosenCourse.GetStudents().size() + " Course Students");
            System.out.println("- Course Modules");
            System.out.println("  - Mandatory Modules: " + chosenCourse.GetMandatoryModuleCount());
            System.out.println("  - Optional Modules: " + (chosenCourse.GetModules().size() - chosenCourse.GetMandatoryModuleCount()));
            System.out.println();

            // Remove Student Option
            courseMenu.AddAction(new Action("Delete Entry", () -> {
                Repository.RemoveCourse(chosenCourse);

                for (Student student : new ArrayList<>(chosenCourse.GetStudents())) {
                    chosenCourse.RemoveStudent(student);
                }
            }));

            courseMenu.AddAction(new Action("Add a Student", () -> {
                ArrayList<Student> unregisteredStudents = new ArrayList<>(Repository.GetStudents());
                unregisteredStudents.removeAll(chosenCourse.GetStudents());

                Student chosenStudent = new StudentSelection(unregisteredStudents).Execute();

                if (chosenStudent != null) {
                    chosenStudent.AddCourse(chosenCourse);
                }
            }));

            courseMenu.AddAction(new Action("Remove a Student", () -> {
                Student chosenStudent = new StudentSelection(chosenCourse.GetStudents()).Execute();

                if (chosenStudent != null) {
                    chosenStudent.RemoveCourse(chosenCourse);
                }
            }));

            courseMenu.Execute();
        }));

        AddAction(new Action("Module Management", () -> {
            ArrayList<Module> ModulesList = new ArrayList<Module>(Repository.GetModules());
            ModulesList.removeIf(module -> module.GetMarks().isEmpty());

            Module chosenModule = new ModuleSelection(ModulesList).Execute();

            if (chosenModule == null) {
                   return;
            }

            chosenModule.UpdateGradeStatistics();

            System.out.println("- Average Grade: " + chosenModule.GetAverageGrade());
            System.out.println("- Average Mark: " + chosenModule.GetAverageMark());
            System.out.println("- Highest Mark: " + chosenModule.GetHighestMark());
            System.out.println("- Lowest Mark: " + chosenModule.GetLowestMark());
        }));
    }
}
