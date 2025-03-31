package Week1;

import java.util.Scanner;

public class Task5 {
    // Create a new reader variable using a new instance of Scanner
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        // Allow the user to input an integer and assign it to the numberOne variable.
        int numberOne = reader.nextInt();

        // Then allow them to input a second integer and assign it to the numberTwo variable.
        int numberTwo = reader.nextInt();

        // Output in the order they were inserted
        System.out.println(numberOne + " " + numberTwo);

        // Output in the opposite order from how they were inserted
        System.out.println(numberTwo + " " + numberOne);
    }
}
