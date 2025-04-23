package Objects;

import Interfaces.ExtendedT;

public class Mark implements ExtendedT {
    private Student Student;
    private Module Module;
    private double Mark;
    private String Grade;

    public enum GradeLetter {
        FIRST_CLASS(70, 100, "First Class"),
        UPPER_SECOND_CLASS(60, 69, "Upper Second Class"),
        LOWER_SECOND_CLASS(50, 59, "Lower Second Class"),
        THIRD_CLASS(40, 49, "Third Class"),
        FAIL(0, 39, "Fail");

        private final double MinMarks;
        private final double MaxMarks;
        private final String Grade;

        GradeLetter(double minMarks, double maxMarks, String grade) {
            this.MinMarks = minMarks;
            this.MaxMarks = maxMarks;
            this.Grade = grade;
        }

        public static String GetGradeForMarks(double marks) {
            for (GradeLetter grade : values()) {
                if (marks >= grade.MinMarks && marks <= grade.MaxMarks) {
                    return grade.Grade;
                }
            }

            return "Invalid";
        }
    }

    public Mark(Module module, Student student, Double mark) {
        SetModule(module);
        SetStudent(student);
        SetMark(mark);
    }

    // Functions to set class attributes
    public boolean SetMark(double mark) {
        if (mark <= 0 || mark >= 100) { return false; } // If a value less than 0 or greater than 100 is submitted, then end the function and return false

        this.Mark = mark; // Set the student's mark
        this.Grade = GradeLetter.GetGradeForMarks(mark); // Set the student's grade

        return true; // Return true to signify completion
    }

    public boolean SetModule(Module module) {
        if (this.Module != null) { return false; } // If there's already a set module, then end the function

        this.Module = module; // Set the module

        return true; // Return true to signify completion
    }

    public boolean SetStudent(Student student) {
        if (this.Student != null) { return false; } // If there's already a student, then end the function

        student.AddMark(this);
        this.Student = student; // Set the student

        return true; // Return true to signify completion
    }

    public String GetGrade() { return this.Grade; }

    public Student GetStudent() {
        return this.Student; // Return the associated student
    }

    public Module GetModule() {
        return this.Module; // Return the associated module
    }

    public Double GetMark() {
        return this.Mark; // Return the student's mark
    }

    public void PrintStatistics() {}

    public String Print() {
        return Student.GetForename() + " " + Student.GetSurname() + "'s Marks";
    }
}
