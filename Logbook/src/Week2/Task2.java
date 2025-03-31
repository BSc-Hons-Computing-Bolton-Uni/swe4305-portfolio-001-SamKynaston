package Week2;

import java.util.Scanner;

public class Task2 {
    // Create a new reader variable using a new instance of Scanner
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        String grade = reader.next();

        switch(grade) {
            case "A":
                System.out.println("You got a first!");
                break;
            case "B":
                System.out.println("You got a 2:1!");
                break;
            case "C":
                System.out.println("You got a 2:2!");
                break;
            case "D":
                System.out.println("You got a 3!");
                break;
            case "E", "F":
                System.out.println("You FAILED!");
                break;
            default:
                System.out.println("Unrecognised input.");
                break;
        }
    }
}
