package Objects;

import Core.Main;
import Core.Repository;
import Interfaces.ExtendedT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Module implements ExtendedT {
    private String Code;
    public String Name;
    private ArrayList<Mark> Marks;
    private Course AssociatedCourse;
    private boolean isMandatory;

    // mark statistics
    private double AverageMark = 0.00;
    private String AverageGrade = "UNKNOWN";
    private double LowestMark = 0.00;
    private double HighestMark = 0.00;

    public Module(String code, String name, boolean isMandatory) {
        this.Marks = new ArrayList<>();

        SetMandatoryStatus(isMandatory);
        SetCode(code);
        SetName(name);

        // Add to the main Modules ArrayList
        Repository.AddModule(this);
    }


    public void SetMandatoryStatus(boolean newStatus) {
        this.isMandatory = newStatus;
    }

    public boolean GetMandatoryStatus() {
        return this.isMandatory;
    }

    public void SetName(String name) { this.Name = name; }
    public void SetCode(String code) {
        this.Code = code;
    }

    public String GetName() { return this.Name; }
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
        int i = 0;

        for (Mark mark : Marks) {
            if (mark.GetMark() > this.HighestMark) { // If the mark is higher than the highest mark
                this.HighestMark = mark.GetMark(); // Set the highest mark to this mark
            }

            if (mark.GetMark() < this.LowestMark || this.LowestMark == 0 && i <= 0) { // If the mark is lower than the lowest mark
                this.LowestMark = mark.GetMark(); // Set the lowest mark to this mark
            }

            this.AverageMark += mark.GetMark(); // Add the mark to the average
        }

        // Divide the average mark by how many marks there are
        this.AverageMark = this.AverageMark / Marks.size();
        this.AverageGrade = Mark.GradeLetter.GetGradeForMarks(this.AverageMark);

        i = i + 1;
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

    public void RemoveMark(Student student) {
        for (Mark currentMark: Marks) { // Go through all marks in a for-each loop
            if (currentMark.GetStudent().equals(student)) {  // If the mark's student matches the student provided, then run the following logic
                Marks.remove(currentMark);

                return;
                
            }
        }
    }

    public void DisplayGradeProfile() {
        System.out.println("Grade Statistics: ");
        System.out.println("- Average Grade: " + GetAverageGrade());
        System.out.println("- Average Mark: " + GetAverageMark());
        System.out.println("- Highest Mark: " + GetHighestMark());
        System.out.println("- Lowest Mark: " + GetLowestMark());

        System.out.println(" ");
        System.out.println("Grade Profile:");
        Map<String, Integer> gradeProfile = new HashMap<>();

        for (Mark mark: Marks) {
            int count = gradeProfile.getOrDefault(mark.GetGrade(), 0);
            gradeProfile.put(mark.GetGrade(), count + 1);
        }

        for (Map.Entry<String, Integer> individualGradeProfile : gradeProfile.entrySet()) {
            double percentage = (individualGradeProfile.getValue()*100) / Marks.size();
            System.out.println("- " + individualGradeProfile.getKey() + ": " + percentage + "% of registered marks");
        }
    }

    public String Print() {
        return this.GetName() + " (" + this.GetCode() + ")";
    }
}
