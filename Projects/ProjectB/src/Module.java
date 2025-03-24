import java.util.ArrayList;

public class Module {
    private String Code;
    private ArrayList<Mark> Marks;

    public Module() {}
    public void SetCode(String code) {}
    public void DisplayGradeProfile() {}
    public void DisplayGradeStatistics() {}
    public Mark AddMark(Student student, double mark) {}
    public Mark UdpateMark(Student student, double mark) {}
    public void RemoveMark(Student student) {}
}
