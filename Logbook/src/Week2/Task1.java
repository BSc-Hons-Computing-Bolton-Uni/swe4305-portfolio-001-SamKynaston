package Week2;

// Import the Year Module
import java.time.Year;
import java.util.Scanner;

public class Task1 {
    // Create a new reader variable using a new instance of Scanner
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        int currentYear = Year.now().getValue();
        int userAge = reader.nextInt();
        int yearOfBirth = (currentYear - userAge);

        if (userAge >= 18)
        {
            System.out.println("Your birth year is: " + yearOfBirth);
        }
    }
}
