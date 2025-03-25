public class Grade {
    public double Marks;

    public enum GradeLetter {
        A_PLUS(90, 100, "A+"),
        A(80, 89, "A"),
        B(70, 79, "B"),
        C(60, 69, "C"),
        D(50, 59, "D"),
        E(30, 49, "E"),
        F(10, 29, "F"),
        U(0, 9, "U");

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

    public void SetMarks(double marks) {
        this.Marks = marks;
    }

    public String GetGrade() {
        return GradeLetter.GetGradeForMarks(Marks);
    }

    Grade(double Marks) {
        SetMarks(Marks);
    }
}