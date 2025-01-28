package Week1;
import java.util.Scanner;

public class Task4 {
    // Create a new reader variable using a new instance of Scanner
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        // Allows the user to input a number for variable "numberOne"
        float numberOne = reader.nextFloat();

        // Allows the user to input a number for variable "numberTwo"
        float numberTwo = reader.nextFloat();

        // Calculate the Average for numberOne and numberTwo
        float average = ((numberOne + numberTwo) / 2);

        System.out.println("The Average of these two numbers is: " + average);
    }
}
