package benchmark.setup;

public abstract class Constants {

    public static final int MAX_SIZE = 999999;
    public static final String MESSAGE_FASTER_COLOR = ConsoleColors.GREEN_BRIGHT + "Faster %s -> " + ConsoleColors.BLUE_BRIGHT + "(%s)" + ConsoleColors.WHITE_BRIGHT + " : %s ns" + ConsoleColors.RESET;
    public static final String MESSAGE_ADDING_COLOR = ConsoleColors.YELLOW_BRIGHT + "%s -> " + ConsoleColors.BLUE_BRIGHT + "(%s)" + ConsoleColors.WHITE_BRIGHT + " : %s ns" + ConsoleColors.RESET;
    public static final String MESSAGE_READING_COLOR = ConsoleColors.CYAN_BRIGHT + "%s -> " + ConsoleColors.BLUE_BRIGHT + "(%s)" + ConsoleColors.WHITE_BRIGHT + " : %s ns" + ConsoleColors.RESET;
    public static final String MESSAGE_REMOVING_COLOR = ConsoleColors.RED_BRIGHT + "%s -> " + ConsoleColors.BLUE_BRIGHT + "(%s)" + ConsoleColors.WHITE_BRIGHT + " : %s ns" + ConsoleColors.RESET;
    public static final String MESSAGE_CONTAINS_COLOR = ConsoleColors.WHITE + "%s -> " + ConsoleColors.BLUE_BRIGHT + "(%s)" + ConsoleColors.WHITE_BRIGHT + " : %s ns" + ConsoleColors.RESET;
    public static final String MESSAGE_NEXT_COLOR = ConsoleColors.PURPLE_BRIGHT + "%s -> " + ConsoleColors.BLUE_BRIGHT + "(%s)" + ConsoleColors.WHITE_BRIGHT + " : %s ns" + ConsoleColors.RESET;

}
