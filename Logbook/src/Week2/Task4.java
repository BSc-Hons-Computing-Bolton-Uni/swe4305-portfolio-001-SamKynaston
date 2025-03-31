package Week2;

import java.util.Scanner;

public class Task4 {
    // Create a new reader variable using a new instance of Scanner
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Multiplication to go to: ");
        int multiplyTo = reader.nextInt();

        for (int x = 0; x <= multiplyTo; x++)
        {
            System.out.println("7 x " + x + " = " + (7 * x));
        }
    }
}
