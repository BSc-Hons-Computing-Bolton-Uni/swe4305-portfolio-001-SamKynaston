import java.text.DecimalFormat;

class Colours {
    // Colours
    public static final String ANSI_RESET = "\u001B[0m"; // Resets any colouring. Must be called after any println function with a colour to prevent it from colouring the entire terminal.
    public static final String RED_BACKGROUND = "\u001B[41m"; // Display a red background behind console text
    public static final String YELLOW_BACKGROUND = "\u001B[43m"; // Displays a yellow background behind console text
    public static final String GREEN_BACKGROUND = "\u001B[42m"; // Displays a green background behind console text
    public static final String PURPLE_BACKGROUND = "\u001B[45m"; // Displays a purple background behind console text
}

class Formatter {
    // Formatting for Large Numbers
    public static String Number(int toFormat) {
        DecimalFormat newFormat = new DecimalFormat("###,###");
        return newFormat.format(toFormat);
    }
}