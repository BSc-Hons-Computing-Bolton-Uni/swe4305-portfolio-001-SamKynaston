package Week1;
import java.util.Scanner; // Import java's scanner module

public class Task3 {
    // Create a new reader variable using a new instance of Scanner
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {

        // Allow the user to input a value indicating the height of the rectangle
        int heightValue = reader.nextInt();

        // Allow the user to input a value indicating the width of the recentangle
        int widthValue = reader.nextInt();

        int area = (heightValue * widthValue);
        int perimeter = ((heightValue * 2) + (widthValue * 2));

        System.out.println("The area of this rectangle is: , " + area);
        System.out.println("The perimeter of this rectangle is: " + perimeter);
    }
}
