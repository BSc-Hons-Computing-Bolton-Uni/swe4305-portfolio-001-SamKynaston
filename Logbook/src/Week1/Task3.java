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

        // Calculate the area by multiplying the heightValue with the widthValue variable.
        int area = (heightValue * widthValue);

        // Calculate the perimeter by multiplying each variable by 2, and then adding them together.
        int perimeter = ((heightValue * 2) + (widthValue * 2));

        // Concatenates the area variable into the outputted string
        System.out.println("The area of this rectangle is: " + area);

        // Concatenates the perimeter variable into the outputted string
        System.out.println("The perimeter of this rectangle is: " + perimeter);
    }
}
