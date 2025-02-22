package Week4;

import java.util.ArrayList;

class Module {
    public String ModuleName;
    public String ModuleCode;

    public Module(String name, String code) {
        this.ModuleName = name;
        this.ModuleCode = code;
    }

    public void printModule() {
        System.out.println("Name:" + ModuleName);
        System.out.println("Code: " + ModuleCode);
    }
}

class Student {
    public int ID;
    public String Name;
    public Course Course;
    public ArrayList<Module> Modules = new ArrayList<Module>();

    public Student(int ID, String name, Module module1, Module module2, Module module3, Module module4) {
        this.ID = ID;
        this.Name = name;

        // Add the Modules that get passed into the constructor
        // Could maybe use an array instead of this? -- SK
        this.Modules.add(module1);
        this.Modules.add(module2);
        this.Modules.add(module3);
        this.Modules.add(module4);
    }

    public void enrol(Course course) {
        this.Course = course;
    }

    public void printDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + Name);

        // Use a for loop to pass all of course's modules
        for (Module Module: Modules) {
            Module.printModule();
        }

        Course.printCourse();
    }
}

class Course {
    public String Course;
    public String Name;

    public Course(String course, String name) {
        this.Course = course;
        this.Name = name;
    }

    public void printCourse() {
        System.out.println("Course ID: " + Course);
        System.out.println("Course Name: " + Name);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
