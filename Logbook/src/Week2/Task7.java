package Week2;

import java.util.Scanner;

public class Task7 {
    // Create a new reader variable using a new instance of Scanner
    private static final Scanner reader = new Scanner(System.in);

    // Create a new Enum Variable containing all marks
    public enum Marks {
        A_PLUS(90, 100, "A+", true),
        A(80, 89, "A", true),
        B(70, 79, "B", true),
        C(60, 69, "C", true),
        D(50, 59, "D", false),
        E(30, 49, "E", false),
        F(10, 29, "F", false),
        U(0, 9, "U", false);

        private final int minMarks;
        private final int maxMarks;
        private final String grade;
        private final boolean hasPassed;

        Marks(int minMarks, int maxMarks, String grade, boolean hasPassed) {
            this.minMarks = minMarks;
            this.maxMarks = maxMarks;
            this.grade = grade;
            this.hasPassed = hasPassed;
        }
    }

    public static void GetGradeForMarks(int studentMarks) {
        for (Marks mark : Marks.values()) {
            if (studentMarks >= mark.minMarks && studentMarks <= mark.maxMarks) {
                if (mark.hasPassed) {
                    System.out.println("Student has passed with grade " + mark.grade);
                } else {
                    System.out.println("Student has failed with grade " + mark.grade);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int marks = reader.nextInt();
        GetGradeForMarks(marks);
    }
}
