package Week3;

class Student {
    public int ID;
    public String Name;
    public Course Course;

    public Student(int ID, String name) {
        this.ID = ID;
        this.Name = name;
    }

    public void enrol(Course course) {
        this.Course = course;
    };

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
    };

    public void printCourse() {
        System.out.println("Course ID: " + Course);
        System.out.println("Course Name: " + Name);
    }
}

public class Task1 {
    public static void main(String[] args)
    {
        // Course Objects
        Course course1 = new Course("C001", "Computing");
        Course course2 = new Course("S001", "Science");
        Course course3 = new Course("H001", "History");

        // Student Objects
        Student student0 = new Student(100165217, "Winston Smith"); // Create Student0
        student0.enrol(course1); // Enrol Student0 into Course1

        Student student1 = new Student(100165218, "Sam Kynaston");
        student1.enrol(course1);

        Student student2 = new Student(100165219, "Melissa Anderson");
        student2.enrol(course3);

        student0.printDetails();
        System.out.println();
        student1.printDetails();
        System.out.println();
        student2.printDetails();
    }
}