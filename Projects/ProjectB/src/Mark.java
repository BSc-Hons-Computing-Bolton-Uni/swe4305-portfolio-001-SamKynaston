public class Mark {
    private Student Student;
    private double Mark;

    public Mark(Student student, Double mark) {
        SetStudent(student);
        SetMark(mark);
    }

    // Functions to set class attributes
    public boolean SetMark(double mark) {
        if (mark < 0 || mark > 100) { return false; } // If a value less than 0 or greater than 100 is submitted, then end the function and return false

        this.Mark = mark; // Set the student's mark

        return true; // Return true to signify completion
    }
    public boolean SetStudent(Student student) {
        if (student == null) { return false; } // If no student is provided, end the function
        if (this.Student != null) { return false; } // If there's already a student, then end the function

        this.Student = student; // Set the student

        return true; // Return true to signify completion
    }

    public Student GetStudent() {
        return this.Student; // Return the associated student
    }

    public Double GetMark() {
        return this.Mark; // Return the student's mark
    }

    public void PrintStatistics() {}
}
