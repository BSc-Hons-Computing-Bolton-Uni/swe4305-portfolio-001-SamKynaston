package Week1;

import java.util.Scanner;

public class Task9 {
    // Create a new reader variable using a new instance of Scanner
    private static final Scanner reader = new Scanner(System.in);
    private static final double Interest_Rate = 0.01;

    public static void main(String[] args)
    {
        System.out.println("Deposit: ");
        double depositAmount = reader.nextDouble();
        double accumulatedInterest = (depositAmount + (depositAmount * Interest_Rate));
        double roundedInterest = (double) Math.round(accumulatedInterest * 100) / 100;

        System.out.println("You are expected to have: " + roundedInterest + " after one year.");
    }
}
