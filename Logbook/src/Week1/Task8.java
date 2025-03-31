package Week1;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Task8 {
    // Create a new reader variable using a new instance of Scanner
    private static final Scanner reader = new Scanner(System.in);

    // Variable to store the amount of feet in a mile
    public static int feetToMiles = 5280;

    public static void main(String[] args)
    {
        System.out.println("Distance in Feet: ");
        int distanceInFeet = reader.nextInt();
        float distanceInMiles = ((float) distanceInFeet / feetToMiles);

        DecimalFormat formatter = new DecimalFormat("#.####");

        System.out.println("This equals " + formatter.format(distanceInMiles) + " mile(s)!");
    }
}
