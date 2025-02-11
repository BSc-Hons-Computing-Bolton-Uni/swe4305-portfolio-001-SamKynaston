package Week2;

import java.util.Objects;
import java.util.Scanner;

public class Task6 {
    // Create a new reader variable using a new instance of Scanner
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        boolean execute = true;

        while (execute) {
            System.out.println("Times Table to Use: ");
            int multiplicationFactor = reader.nextInt();

            System.out.println("Multiplication to go to: ");
            int multiplyTo = reader.nextInt();

            for (int x = 0; x <= multiplyTo; x++)
            {
                System.out.println(multiplicationFactor + " x " + x + " = " + (multiplicationFactor * x));
            }

            System.out.println("Do you want to continue (yes | no)?");

            String cont = reader.next();

            if (!Objects.equals(cont, "yes")) {
                execute = false;
            }
        }
    }
}
