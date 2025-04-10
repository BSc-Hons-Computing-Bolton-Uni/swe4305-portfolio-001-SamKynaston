package objects;

import core.Main;

import java.util.ArrayList;

public class Module {
    private String Code;
    private ArrayList<Mark> Marks;
    private Course AssociatedCourse;

    public Module(String code) {
        this.Marks = new ArrayList<>();
        SetCode(code);

        // Add to the main Modules ArrayList
        Main.Modules.add(this);
    }

    public void SetCode(String code) {
        this.Code = code;
    }

    public String GetCode() {
        return Code;
    }

    public void SetCourse(Course course) {
        this.AssociatedCourse = course;
    }

    public Course GetCourse() {
        return AssociatedCourse;
    }

    public void DisplayGradeProfile() {}
    public void DisplayGradeStatistics() {}

    public boolean AddMark(Student student, double mark) {
        return false; // TO BE REWRITTEN
    }

    public ArrayList<Mark> GetMarks() {
        return this.Marks;
    }

    public Mark UpdateMark(Student student, double mark) {
        for (Mark currentMark: Marks) { // Go through all marks in a for-each loop
            if (currentMark.GetStudent().equals(student)) {  // If the mark's student matches the student provided, then run the following logic
                currentMark.SetMark(mark); // Set the new mark for the student

                return currentMark; // Return the mark
            }
        }

        return null; // Return null if mark is not found
    }

    public void RemoveMark(Student student) {
        for (Mark currentMark: Marks) { // Go through all marks in a for-each loop
            if (currentMark.GetStudent().equals(student)) {  // If the mark's student matches the student provided, then run the following logic
                Marks.remove(currentMark);

                return;
            }
        }
    }
}
