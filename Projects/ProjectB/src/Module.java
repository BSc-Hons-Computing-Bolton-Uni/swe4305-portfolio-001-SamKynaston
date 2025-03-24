import java.util.ArrayList;

public class Module {
    private String Code;
    private ArrayList<Mark> Marks;

    public Module(String code) {
        SetCode(code);
    }

    public void SetCode(String code) {
        this.Code = code;
    }

    public void DisplayGradeProfile() {}
    public void DisplayGradeStatistics() {}

    public Mark AddMark(Student student, double mark) {
        return new Mark(student, mark);
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
