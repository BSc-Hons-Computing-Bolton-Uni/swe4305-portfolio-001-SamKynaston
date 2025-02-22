package Week4;

import java.util.ArrayList;

class Module {
    public String ModuleName;
    public String ModuleCode;

    public Module(String name, String code) {
        this.ModuleName = name;
        this.ModuleCode = code;
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
