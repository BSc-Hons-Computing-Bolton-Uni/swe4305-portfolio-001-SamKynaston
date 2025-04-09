package objects;

import java.util.ArrayList;

public class Statistic {
    private double GetTotalMarks(String operation, ArrayList<Mark> Marks) {
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

    public double UpdateMeanMark(ArrayList<Mark> Marks) {
        double TotalMarks = GetTotalMarks(null, Marks);
        double TotalStudents = Marks.size();

        return (TotalMarks / TotalStudents);
    }

    public double UpdateMaximumMark(ArrayList<Mark> Marks) {
        return GetTotalMarks("Maximum", Marks);
    }

    public double UpdateMinimumMark(ArrayList<Mark> Marks) {
        return GetTotalMarks("Minimum", Marks);
    }
}