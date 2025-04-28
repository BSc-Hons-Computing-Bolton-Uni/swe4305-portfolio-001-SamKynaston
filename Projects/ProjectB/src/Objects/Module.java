package Objects;

import Core.Main;
import Core.Repository;
import Interfaces.ExtendedT;

import java.util.ArrayList;

public class Module implements ExtendedT {
    private String Code;
    private ArrayList<Mark> Marks;
    private Course AssociatedCourse;
    private boolean isMandatory;

    // mark statistics
    private double AverageMark = 0.00;
    private String AverageGrade = "UNKNOWN";
    private double LowestMark = 0.00;
    private double HighestMark = 0.00;

    public Module(String code, boolean isMandatory) {
        this.Marks = new ArrayList<>();

        SetMandatoryStatus(isMandatory);
        SetCode(code);

        // Add to the main Modules ArrayList
        Repository.AddModule(this);
    }


    public void SetMandatoryStatus(boolean newStatus) {
        this.isMandatory = newStatus;
    }

    public boolean GetMandatoryStatus() {
        return this.isMandatory;
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

    public String GetAverageGrade() {
        return this.AverageGrade;
    }

    public Double GetAverageMark() {
        return this.AverageMark;
    }

    public Double GetHighestMark() {
        return this.HighestMark;
    }

    public Double GetLowestMark() {
        return this.LowestMark;
    }

    public void UpdateGradeStatistics() {
        for (Mark mark : Marks) {
            if (mark.GetMark() > this.HighestMark) { // If the mark is higher than the highest mark
                this.HighestMark = mark.GetMark(); // Set the highest mark to this mark
            }

            if (mark.GetMark() < this.LowestMark) { // If the mark is lower than the lowest mark
                this.LowestMark = mark.GetMark(); // Set the lowest mark to this mark
            }

            this.AverageMark += mark.GetMark(); // Add the mark to the average
        }

        // Divide the average mark by how many marks there are
        System.out.println(Marks.size());
        this.AverageMark = this.AverageMark / Marks.size();
        this.AverageGrade = Mark.GradeLetter.GetGradeForMarks(this.AverageMark);
    }

    public boolean SetMark(Student student, double mark) {
        boolean markExists = false;

        for (Mark markObject: Marks) {
            if (markObject.GetStudent().equals(student)) {
                markObject.SetMark(mark);
                markExists = true;
                break;
            }
        }

        if (!markExists) {
            Marks.add(new Mark(this, student, mark));
        }

        return true;
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

    public String Print() {
        return Code;
    }
}
