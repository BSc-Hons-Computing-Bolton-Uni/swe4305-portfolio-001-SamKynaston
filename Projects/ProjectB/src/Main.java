import java.util.Scanner;

public class Main {
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        // Just testing new menu class
        Menu BaseMenu = new Menu(reader);

        // Debug Option 1
        MenuOption Debug1 = new MenuOption();
        Debug1.SetName("Multiply");

        Debug1.SetAction((reader) -> {
            System.out.println("DEBUG MULTIPLY MENU");

            int num1 = reader.nextInt();
            int num2 = reader.nextInt();

            System.out.println(num1 * num2);
        });

        MenuOption Debug2 = new MenuOption();
        Debug2.SetName("Divide");

        Debug2.SetAction((reader) -> {
            System.out.println("DEBUG DIVIDE MENU");

            int num1 = reader.nextInt();
            int num2 = reader.nextInt();

            System.out.println(num1 / num2);
        });

        BaseMenu.AddOption(Debug1);
        BaseMenu.AddOption(Debug2);
        BaseMenu.Display();
    }
}