package Week1;

// Import the Clock Module
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Task7 {
    // Create a new reader variable using a new instance of Scanner
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Day of Birth: ");
        int dayOfBirth = reader.nextInt();

        System.out.println("Month of Birth (1-12): ");
        int monthOfBirth = reader.nextInt();

        System.out.println("Year of Birth: ");
        int yearOfBirth = reader.nextInt();

        LocalDate dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        LocalDate currentDate = LocalDate.now();

        long daysBetween = ChronoUnit.DAYS.between(dateOfBirth, currentDate);

        System.out.println(daysBetween + " days have elapsed since your birth!");
    }
}
