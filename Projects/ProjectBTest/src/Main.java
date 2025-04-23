import Objects.Course;
import Objects.Module;
import Objects.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Main {
    @Test
    void CreateStudentAndTestID() {
        Student student = new Student(1);
        assertEquals(1, student.GetID());
    }

    @Test
    void CreateStudentAndTestIDOverwrite() {
        Student student = new Student(1);

        student.SetID(2);

        assertEquals(1, student.GetID());
    }

    @Test
    void CreateStudentAndTestForename() {
        Student student = new Student(1);
        student.SetForename("John");

        assertEquals("John", student.GetForename());
    }

    @Test
    void CreateStudentAndTestSurname() {
        Student student = new Student(1);
        student.SetSurname("Smith");

        assertEquals("Smith", student.GetSurname());
    }

    @Test
    void CreateStudentAndCourseAndTestAddition() {
        Student student = new Student(1);
        Course course = new Course("C001");

        assertTrue(student.AddCourse(course));
    }

    @Test
    void CreateStudentAndCourseAndTestItContains() {
        Student student = new Student(1);
        Course course = new Course("C001");

        student.AddCourse(course);
        assertTrue(student.GetCourses().contains(course));
    }

    @Test
    void CreateStudentAndCourseAndTestRemoval() {
        Student student = new Student(1);
        Course course = new Course("C001");

        student.AddCourse(course);
        assertTrue(student.RemoveCourse(course));
    }

    @Test
    void CreateCourseAndTestModuleAddition() {
        Course course = new Course("C001");
        Module module = new Module("CM001", true);

        assertTrue(course.AddModule(module));
    }

    @Test
    void CreateCourseAndAddModuleAndTestItContains() {
        Course course = new Course("C001");
        Module module = new Module("CM001", true);

        course.AddModule(module);
        assertTrue(course.GetModules().contains(module));
    }

    @Test
    void CreateCourseAndTestModuleRemoval() {
        Course course = new Course("C001");
        Module module = new Module("CM001", true);

        course.AddModule(module);
        assertTrue(course.RemoveModule(module));
    }
}