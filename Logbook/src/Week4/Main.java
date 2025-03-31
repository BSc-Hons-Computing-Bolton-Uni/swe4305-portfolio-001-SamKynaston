package Week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public List<ModuleMark> Marks;

    public Student(int ID, String name) {
        this.ID = ID;
        this.Name = name;
        this.Marks = new ArrayList<>(4);

        this.Marks.add(new ModuleMark());
        this.Marks.add(new ModuleMark());
        this.Marks.add(new ModuleMark());
        this.Marks.add(new ModuleMark());
    }

    public void enrol(Course course) {
        this.Course = course;
    }

    public void printDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + Name);

        System.out.println("=====[ Marks ]=====");
        for (ModuleMark mark: Marks) {
            mark.printMarks();
        }

        System.out.println("=====[ Course ]=====");
        Course.printCourse();
    }
}

class ModuleMark {
    // Random Function
    Random random = new Random();

    public Integer Mark;

    public enum Marks {
        A_PLUS(90, 100, "A+", true),
        A(80, 89, "A", true),
        B(70, 79, "B", true),
        C(60, 69, "C", true),
        D(50, 59, "D", false),
        E(30, 49, "E", false),
        F(10, 29, "F", false),
        U(0, 9, "U", false);

        private final int minMarks;
        private final int maxMarks;
        private final String grade;
        private final boolean hasPassed;

        Marks(int minMarks, int maxMarks, String grade, boolean hasPassed) {
            this.minMarks = minMarks;
            this.maxMarks = maxMarks;
            this.grade = grade;
            this.hasPassed = hasPassed;
        }
    }

    public static void GetGradeForMarks(int studentMarks) {
        for (Marks mark : Marks.values()) {
            if (studentMarks >= mark.minMarks && studentMarks <= mark.maxMarks) {
                System.out.println("=====[ Grade Details ]=====");
                // Get the Maximum, Minimum mark based on grade
                System.out.println("Grade: " + mark.grade);
                System.out.println("Maximum Mark: " + mark.maxMarks);
                System.out.println("Minimum Mark: " + mark.minMarks);

                // Calculate the mean between the maxMarks and the minMarks
                float gradeMean = (float) (mark.minMarks + mark.maxMarks) / 2;

                System.out.println("Mean Marks Required: " + gradeMean);

                if (mark.hasPassed) {
                    System.out.println("Student has passed with grade " + mark.grade + " (" + studentMarks + ")");
                } else {
                    System.out.println("Student has failed with grade " + mark.grade + " (" + studentMarks + ")");
                }
            }
        }
    }

    public ModuleMark() {
        this.Mark = random.nextInt(100);
    }

    public void printMarks() {
        GetGradeForMarks(Mark);
    }
}

class Course {
    public String Course;
    public String Name;
    public ArrayList<Module> Modules = new ArrayList<>();

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
        System.out.println("=====[ Modules ]=====");
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
        ArrayList<Module> courseModules = new ArrayList<>();

        courseModules.add(module1);
        courseModules.add(module2);
        courseModules.add(module3);
        courseModules.add(module4);

        // Course Objects
        Course course1 = new Course("C001", "Computing", courseModules);
        Course course2 = new Course("S001", "Science", courseModules);
        Course course3 = new Course("H001", "History", courseModules);

        // Student Objects
        Student student0 = new Student(100165217, "Winston Smith"); // Create Student0
        student0.enrol(course1); // Enrol Student0 into Course1

        Student student1 = new Student(100165218, "Sam Kynaston");
        student1.enrol(course1); // Enrol Student1 into Course1

        Student student2 = new Student(100165219, "Melissa Anderson");
        student2.enrol(course3); // Enrol Student2 into Course3

        // Print Details on the Students
        student0.printDetails();
        System.out.println();
        student1.printDetails();
        System.out.println();
        student2.printDetails();
        System.out.println();

        // Print Details on Courses
        course1.printCourse();
        System.out.println();
        course2.printCourse();
        System.out.println();
        course3.printCourse();
    }
}
