package Week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Module {
    public String ModuleName;
    public String ModuleCode;

    public Module(String name, String code) {
        this.ModuleName = name;
        this.ModuleCode = code;
    }

    public void printModule() {
        System.out.println("Name: " + ModuleName);
        System.out.println("Code: " + ModuleCode);
    }
}

class Student {
    public int ID;
    public String Name;
    public Course Course;
    public List<Integer> Marks = new ArrayList<Integer>(4);

    public Student(int ID, String name, List<Integer> marks) {
        this.ID = ID;
        this.Name = name;

        // Add the Modules that get passed into the constructor
        this.Marks.addAll(marks);
    }

    public void enrol(Course course) {
        this.Course = course;
    }

    public void printDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + Name);

        for (Integer mark: Marks) {
            System.out.println("Mark: " + mark);
        }

        Course.printCourse();
    }
}

class Course {
    public String Course;
    public String Name;
    public ArrayList<Module> Modules = new ArrayList<Module>();

    public Course(String course, String name, ArrayList<Module> modules) {
        this.Course = course;
        this.Name = name;

        // Add the Modules that get passed into the constructor
        this.Modules.addAll(modules);
    }

    public void printCourse() {
        System.out.println("Course ID: " + Course);
        System.out.println("Course Name: " + Name);

        // Use a for loop to pass all of course's modules
        for (Module Module: Modules) {
            Module.printModule();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Module Objects
        Module module1 = new Module("Fundamentals", "F001");
        Module module2 = new Module("Personal Development", "PPD");
        Module module3 = new Module("Advanced", "A001");
        Module module4 = new Module("Proficient", "P001");

        // Modules Object
        ArrayList<Module> courseModules = new ArrayList<Module>();

        courseModules.add(module1);
        courseModules.add(module2);
        courseModules.add(module3);
        courseModules.add(module4);

        // Course Objects
        Course course1 = new Course("C001", "Computing", courseModules);
        Course course2 = new Course("S001", "Science", courseModules);
        Course course3 = new Course("H001", "History", courseModules);

        // Student Objects
        List<Integer> student0Marks = new ArrayList<Integer>(4);
        List<Integer> student1Marks = new ArrayList<Integer>(4);
        List<Integer> student2Marks = new ArrayList<Integer>(4);

        Student student0 = new Student(100165217, "Winston Smith", student0Marks); // Create Student0
        student0.enrol(course1); // Enrol Student0 into Course1

        Student student1 = new Student(100165218, "Sam Kynaston", student1Marks);
        student1.enrol(course1); // Enrol Student1 into Course1

        Student student2 = new Student(100165219, "Melissa Anderson", student2Marks);
        student2.enrol(course3); // Enrol Student2 into Course3
    }
}
