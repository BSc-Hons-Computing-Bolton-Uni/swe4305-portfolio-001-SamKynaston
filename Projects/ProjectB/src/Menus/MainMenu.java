package Menus;

import Core.Main;
import Core.Repository;
import Objects.*;
import Objects.Module;

import java.util.ArrayList;

public class MainMenu extends OptionMenu<Action> {
    public MainMenu() {
        super("University Manager");

        AddAction(new Action("Create a New Student/Course/Module", () -> {
            OptionMenu<Action> CreationPrompt = new OptionMenu<>("Create a New Student/Course/Module");

            CreationPrompt.AddAction(new Action("Create a New Student", () -> {
                int amountToLoop = Input.ReadIntInRange("Amount of Student(s) to Create: ", 1, 100);
                int currentIndex = 1;

                while(amountToLoop >= currentIndex) {
                    System.out.println("Student " + currentIndex + "/" + amountToLoop);

                    String forename = Input.ReadStringWithLength("First Name: ", 1, 32);
                    String surname = Input.ReadStringWithLength("Surname: ", 1, 32);

                    Student newStudent = new Student();
                    newStudent.SetForename(forename);
                    newStudent.SetSurname(surname);

                    currentIndex += 1; // Increment Index by one
                }
            }));

            CreationPrompt.AddAction(new Action("Create a New Course", () -> {
                int amountToLoop = Input.ReadIntInRange("Amount of Course(s) to Create: ", 1, 100);
                int currentIndex = 1;

                while(amountToLoop >= currentIndex) {
                    String code = Input.ReadStringWithLength("Code: ", 0, 5);
                    String name = Input.ReadStringWithLength("Course Name: ", 0, 128);

                    Course newCourse = new Course(code);
                    newCourse.SetName(name);

                    currentIndex += 1; // Increment index by one
                }
            }));

            CreationPrompt.AddAction(new Action("Create a New Module", () -> {
                int amountToLoop = Input.ReadIntInRange("Amount of Module(s) to Create: ", 1, 100);
                int currentIndex = 1;

                while(amountToLoop >= currentIndex) {
                    Course assignedCourse = new CourseSelection(Repository.GetCourses()).Execute();
                    String code = Input.ReadStringWithLength("Module Code: ", 0, 5);
                    String name = Input.ReadStringWithLength("Module Name: ", 0, 64);
                    boolean isMandatory = Input.ReadYesNo("Is this module mandatory?");

                    Module newModule = new Module(code, name, isMandatory);
                    newModule.SetCourse(assignedCourse);
                    assignedCourse.AddModule(newModule);

                    currentIndex += 1; // Increment index by one
                }
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
                String surname = Input.ReadStringWithLength("Surname: ", 0, 32);

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

            // Rename Options
            courseMenu.AddAction(new Action("Update Course Name", () -> {
                String newName = Input.ReadStringWithLength("Proposed Name: ", 0, 64);
                chosenCourse.SetName(newName);
            }));

            courseMenu.AddAction(new Action("Update Course Code", () -> {
                String newCode = Input.ReadStringWithLength("Proposed Code: ", 0, 64);
                chosenCourse.SetCode(newCode);
            }));

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

            courseMenu.AddAction(new Action("Module Management", () -> {
                ArrayList<Module> ModulesList = new ArrayList<Module>(chosenCourse.GetModules());
                Module chosenModule = new ModuleSelection(ModulesList).Execute();

                if (chosenModule == null) { return; }

                OptionMenu<Action> moduleMenu = new OptionMenu<>("Manage " + chosenModule.GetName() + " (" + chosenModule.GetCode() + ")");

                if (!chosenModule.GetMarks().isEmpty()) {
                    chosenModule.UpdateGradeStatistics();
                    chosenModule.DisplayGradeProfile();
                }

                System.out.println(" ");

                moduleMenu.AddAction(new Action("Update Module Name", () -> {
                    String newName = Input.ReadStringWithLength("Proposed Name: ", 0, 64);
                    chosenModule.SetName(newName);
                }));

                moduleMenu.AddAction(new Action("Update Module Code", () -> {
                    String newCode = Input.ReadStringWithLength("Proposed Code: ", 0, 64);
                    chosenModule.SetCode(newCode);
                }));

                moduleMenu.AddAction(new Action("Update Module's Priority", () -> {
                    boolean newStatus = Input.ReadYesNo("Is this a mandatory subject?");
                    chosenModule.SetMandatoryStatus(newStatus);
                }));

                moduleMenu.AddAction(new Action("Set a Mark", () -> {
                    Student chosenStudent = new StudentSelection(chosenCourse.GetStudents()).Execute();
                    int mark = Input.ReadIntInRange("Mark: ", 0, 100);

                    if (chosenStudent == null) { return; }

                    chosenModule.SetMark(chosenStudent, mark);
                }));

                moduleMenu.Execute();
            }));

            courseMenu.Execute();
        }));
    }
}
