import java.util.Scanner;

public class Input {
    public static final Scanner reader = new Scanner(System.in);

    public static int ReadInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = reader.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Input type error. This may be because:");
                System.out.println("- You used a character in your input");
                System.out.println("- You didn't input anything");
                System.out.println("- You didn't input a number");
                System.out.println();
            }
        }
    }

    public static int ReadIntInRange(String prompt, int minimum, int maximum) {
        while (true) {
            System.out.print(prompt);
            String input = reader.nextLine();

            try {
                int selection = Integer.parseInt(input);

                if (selection >= minimum && selection <= maximum) {
                    return selection;
                } else {
                    System.out.println("Your selection is out of range. Select a number between " + minimum + " and " + maximum);
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Input type error. This may be because:");
                System.out.println("- You used a character in your input");
                System.out.println("- You didn't input anything");
                System.out.println("- You didn't input a number");
                System.out.println();
            }
        }
    }
}
