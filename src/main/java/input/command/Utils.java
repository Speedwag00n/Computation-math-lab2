package input.command;

import java.util.Scanner;

public class Utils {

    private static Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }

    public static boolean isReturnCommand(String line) {
        line = line.trim().toLowerCase();
        if (line.equals("return") || line.equals("вернуться")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isInterruptCommand(String line) {
        line = line.trim().toLowerCase();
        if (line.equals("cancel") || line.equals("отменить")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isExitCommand(String line) {
        line = line.trim().toLowerCase();
        if (line.equals("exit") || line.equals("выйти")) {
            return true;
        } else {
            return false;
        }
    }

}
