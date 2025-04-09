package objects;

import java.util.Scanner;

public class MenuActionContext {
    private final Scanner Reader;
    private static MenuActionContext Context;

    private MenuActionContext(Scanner reader) {
        this.Reader = reader;
    }

    public static void New(Scanner reader) {
        Context = new MenuActionContext(reader);
    }

    public static MenuActionContext GetContext() {
        return Context;
    }

    public Scanner GetReader() {
        return Reader;
    }
}
