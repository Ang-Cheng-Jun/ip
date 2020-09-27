package ui;

import common.Messages;

import java.util.Scanner;

public class TextUi {

    public static final int DISPLAYED_INDEX_OFFSET = 1;
    private static final String LINE_PREFIX = "|| ";
    private static final String DIVIDER = "===================================================";
    private static final String LS = System.lineSeparator();

    public static void showWelcomeMessage() {
        showToUser(Messages.MESSAGE_WELCOME);
    }

    public static void showByeMessage() {
        showToUser(Messages.MESSAGE_GOODBYE);
    }

    public static void showToUser(String message) {
        System.out.println(message);
    }

    public String getUserCommand() {
        showToUser("Enter command: ");
        Scanner sc = new Scanner(System.in);
        String fullInputLine = sc.nextLine().trim();
        return fullInputLine;
    }
}
