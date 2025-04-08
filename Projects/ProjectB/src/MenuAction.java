import java.util.Scanner;

@FunctionalInterface
public interface MenuAction {
    void execute(Scanner input);
}
