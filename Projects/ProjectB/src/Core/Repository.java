package Core;

import Objects.Course;
import Objects.Module;
import Objects.Student;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Repository {
    private static final ArrayList<Student> Students = new ArrayList<>();
    private static final ArrayList<Module> Modules = new ArrayList<>();
    private static final ArrayList<Course> Courses = new ArrayList<>();

    public static void AddStudent(Student student) {
        if (Students.contains(student)) { return; }

        Students.add(student);
    }

    public static void AddModule(Module module) {
        if (Modules.contains(module)) { return; }

        Modules.add(module);
    }

    public static void AddCourse(Course course) {
        if (Courses.contains(course)) { return; }

        Courses.add(course);
    }

    public static void RemoveStudent(Student student) {
        if (!Students.contains(student)) { return; }

        Students.remove(student);
    }

    public static void RemoveModule(Module module) {
        if (!Modules.contains(module)) { return; }

        Modules.remove(module);
    }

    public static void RemoveCourse(Course course) {
        if (!Courses.contains(course)) { return; }

        Courses.remove(course);
    }

    public static ArrayList<Student> GetStudents() {
        return Students;
    }

    public static ArrayList<Module> GetModules() {
        return Modules;
    }

    public static ArrayList<Course> GetCourses() {
        return Courses;
    }
}
