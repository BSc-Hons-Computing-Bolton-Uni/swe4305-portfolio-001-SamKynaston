package Objects;

import java.util.Objects;
import java.util.Scanner;

public class Input {
    public static final Scanner reader = new Scanner(System.in);

    public static boolean ReadYesNo(String question) {
        while (true) {
            System.out.print(question + " (Y/N): ");
            String input = reader.nextLine().trim().toLowerCase(); // Trim spaces + lower case

            try {
                if (Objects.equals(input, "y") || Objects.equals(input, "yes")) {
                    return true;
                } else if (Objects.equals(input, "n") || Objects.equals(input, "no")) {
                    return false;
                } else {
                    System.out.println("Invalid input. Please enter Y/N or Yes/No.");
                }
            } catch (Exception e) {
                System.out.println("Unknown Exception. " + e.getMessage());
            }
        }
    }

    public static String ReadStringWithLength(String prompt, int MinLength, int MaxLength) {
        while(true) {
            System.out.print(prompt);
            String input = reader.nextLine();

            try {

                if (input.length() >= MinLength && input.length() <= MaxLength) {
                    return input;
                } else if (input.length() < MinLength) {
                    System.out.println("Your input is less than " + MinLength);
                } else {
                    System.out.println("Your input is greater than " + MinLength);
                }

            } catch(Exception e) {
                System.out.println("Unknown Exception. " + e.getMessage());
            }
        }
    }

    public static String ReadString(String prompt) {
        while(true) {
            System.out.print(prompt);
            String input = reader.nextLine();

            try {
                return input;
            } catch(Exception e) {
                System.out.println("Unknown Exception.");
            }
        }
    }

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
