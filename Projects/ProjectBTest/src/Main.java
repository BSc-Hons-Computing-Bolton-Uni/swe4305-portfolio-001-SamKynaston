import Objects.Course;
import Objects.Module;
import Objects.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Main {
    @Test
    void CreateStudentAndTestID() {
        Student student = new Student();

        student.SetID(1);

        assertEquals(1000, student.GetID());
    }

    @Test
    void CreateStudentAndTestIDOverwrite() {
        Student student = new Student();

        assertEquals(1002, student.GetID());

        student.SetID(2);

        assertEquals(1002, student.GetID());
    }

    @Test
    void CreateStudentAndTestForename() {
        Student student = new Student();
        student.SetForename("John");

        assertEquals("John", student.GetForename());
    }

    @Test
    void CreateStudentAndTestSurname() {
        Student student = new Student();
        student.SetSurname("Smith");

        assertEquals("Smith", student.GetSurname());
    }

    @Test
    void CreateStudentAndCourseAndTestAddition() {
        Student student = new Student();
        Course course = new Course("C001");

        assertTrue(student.AddCourse(course));
    }

    @Test
    void CreateStudentAndCourseAndTestItContains() {
        Student student = new Student();
        Course course = new Course("C001");

        student.AddCourse(course);
        assertTrue(student.GetCourses().contains(course));
    }

    @Test
    void CreateStudentAndCourseAndTestRemoval() {
        Student student = new Student();
        Course course = new Course("C001");

        student.AddCourse(course);
        assertTrue(student.RemoveCourse(course));
    }

    @Test
    void CreateCourseAndTestModuleAddition() {
        Course course = new Course("C001");
        Module module = new Module("CM001", "TEST", true);

        assertTrue(course.AddModule(module));
    }

    @Test
    void CreateCourseAndAddModuleAndTestItContains() {
        Course course = new Course("C001");
        Module module = new Module("CM001", "TEST", true);

        course.AddModule(module);
        assertTrue(course.GetModules().contains(module));
    }

    @Test
    void CreateCourseAndTestModuleRemoval() {
        Course course = new Course("C001");
        Module module = new Module("CM001", "TEST", true);

        course.AddModule(module);
        assertTrue(course.RemoveModule(module));
    }

    @Test
    void CreateCourseAndTestGrades() {
        Course course = new Course("C001");
        Module module = new Module("CM001", "TEST", true);
        Student student = new Student();
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();

        course.AddModule(module);

        student.AddCourse(course);
        student1.AddCourse(course);
        student2.AddCourse(course);
        student3.AddCourse(course);

        module.SetMark(student, 100);
        module.SetMark(student1, 75);
        module.SetMark(student2, 50);
        module.SetMark(student3, 25);

        module.UpdateGradeStatistics();

        assertEquals(module.GetAverageMark(), 62.5);
        assertEquals(module.GetHighestMark(), 100);
        assertEquals(module.GetLowestMark(), 25);
        assertEquals(module.GetAverageGrade(), "Upper Second Class");
    }
}