package objects;

import core.Main;

import java.util.ArrayList;

public class Course {
    private String Code;
    public boolean HasCodeBeenSet = false;
    private String Name;
    private ArrayList<Module> Modules;

    public Course(String code) {
        SetCode(code);

        this.Modules = new ArrayList<>();

        // Add to the main Courses ArrayList
        Main.Courses.add(this);
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

    public boolean AddModule(Module module) {
        if (Modules.contains(module)) { return false; } // If the course already has the provided module, then return false

        module.SetCourse(this);
        this.Modules.add(module); // Add the module to the course

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
}
