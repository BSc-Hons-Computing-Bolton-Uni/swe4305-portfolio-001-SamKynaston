package Objects;

import Core.Main;
import Core.Repository;
import Interfaces.ExtendedT;

import java.util.ArrayList;
import java.util.Random;

public class Course implements ExtendedT {
    private String Code;
    public boolean HasCodeBeenSet = false;
    private String Name;
    private ArrayList<Module> Modules;
    private ArrayList<Student> Students;

    public Course(String code) {
        SetCode(code);

        this.Modules = new ArrayList<>();
        this.Students = new ArrayList<>();

        // Add to the main Courses ArrayList
        Repository.AddCourse(this);
    }

    public void SetCode(String code) {
        if (this.HasCodeBeenSet) { return; } // If the code has already been set, then do not allow it to be changed

        this.Code = code; // Set the objects.Course's code
        this.HasCodeBeenSet = true; // Set the HasCodeBeenSet flag to true
    }

    public void SetName(String name) {
        this.Name = name; // Set the class's name
    }

    public String GetCode() {
        return this.Code; // Return the class's code
    }

    public String GetName() {
        return this.Name; // Return the class's name
    }

    public boolean SetModules(ArrayList<Module> modules) {
        this.Modules = modules;

        return true;
    }

    public boolean AddStudent(Student student) {
        if (this.Students.contains(student)) { System.out.println("Student is already registered on this course!"); return false; }

        for (Module module : Modules) {
            if (!module.GetMandatoryStatus()) { continue; } // If it's not a mandatory module, then do not create a mark for student onto it by default

            module.SetMark(student, 0);
        }

        this.Students.add(student);

        return true;
    }

    public boolean RemoveStudent(Student student) {
        if (!this.Students.contains(student)) { System.out.println("Student is not registered on this course!"); return false; }

        student.RemoveCourse(this);
        this.Students.remove(student);

        return true;
    }

    public ArrayList<Student> GetStudents() {
        return Students;
    }

    public boolean AddModule(Module module) {
        if (Modules.contains(module)) { return false; } // If the course already has the provided module, then return false

        module.SetCourse(this);
        this.Modules.add(module); // Add the module to the course

        if (module.GetMandatoryStatus()) { // If the new module is a mandatory module
            for (Student student: Students) { // Go through all students
                module.SetMark(student, new Random().nextInt(0, 100)); // Set their default mark to 0
            }
        }

        return true; // Return true once complete
    }

    public boolean RemoveModule(Module module) {
        if (!Modules.contains(module)) { return false; } // If the course already doesn't have the course, or it's been deleted, then return false

        this.Modules.remove(module); // Remove the module

        return true; // Return true
    }

    public ArrayList<Module> GetModules() {
        return this.Modules;
    }

    public int GetMandatoryModuleCount() {
        int valueToReturn = 0;

        for (Module module : Modules) {
            if (!module.GetMandatoryStatus()) { continue; }
            valueToReturn += 1;
        }

        return valueToReturn;
    }

    public String Print() {
        return this.Name + "(" + this.Code + ")";
    }
}
