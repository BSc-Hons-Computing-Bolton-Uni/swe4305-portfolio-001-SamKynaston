package core;

import objects.Menu;
import java.util.Stack;

public class MenuManager {
    private static final Stack<Menu> Menus = new Stack<>();

    public static void AddMenu(Menu menu) {
       Menus.push(menu);
    }

    public static void GoToFirstPage() {
        Menu MainMenu = Menus.firstElement();

        Clear();
        AddMenu(MainMenu);

        Start();
    }

    public static void GoBack() {
        if (!Menus.isEmpty()) {
            Menus.pop();
        }
    }

    public static void Start() {
        while (!Menus.isEmpty()) {
            Menu currentMenu = Menus.peek();
            currentMenu.Display();
        }
    }

    public static void Clear() {
        Menus.clear();
    }
}
