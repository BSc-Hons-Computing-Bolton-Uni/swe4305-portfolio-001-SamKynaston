import java.util.ArrayList;

public class Statistic {
    ArrayList<Mark> Marks;
    double MeanMark;
    double MinimumMark;
    double MaximumMark;

    private double GetTotalMarks(String operation) {
        double toReturn = 0;

        for (Mark mark : Marks) {
            if (operation.equals("Maximum") && toReturn < mark.GetMark() || operation.equals("Minimum") && toReturn > mark.GetMark()) {
                toReturn = mark.GetMark();
            } else {
                toReturn = (toReturn + mark.GetMark());
            }
        }

        return toReturn;
    }

    public double UpdateMeanMark() {
        double TotalMarks = GetTotalMarks(null);
        double TotalStudents = Marks.size();

        return (TotalMarks / TotalStudents);
    }

    public void UpdateMaximumMark() {
        this.MaximumMark = GetTotalMarks("Maximum");
    }

    public void UpdateMinimumMark() {
        this.MinimumMark = GetTotalMarks("Minimum");
    }

    public void RegisterGrade(Mark mark) {
        Marks.add(mark);
    }
}