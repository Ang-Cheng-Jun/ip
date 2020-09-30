package ui;

import common.Messages;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class TextUi {

    private static final String DIVIDER = "===================================================";
    private static Scanner in;
    private static PrintStream out;

    public TextUi() {
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    /**
     * Generates and prints the welcome message upon the start of the application.
     */
    public void showWelcomeMessage() {
        printDivider();
        showToUser(Messages.MESSAGE_WELCOME);
    }

    /**
     * Generates and prints the Goodbye message upon the end of the application.
     */
    public void showByeMessage() {
        showToUser(Messages.MESSAGE_GOODBYE);
    }

    /** Shows message(s) to the user */
    public static void showToUser(String message) {
        out.println(message);
    }

    /** Print a divider */
    private static void printDivider() {
        showToUser(DIVIDER);
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     * @return command (full line) entered by the user
     */
    public String getUserCommand() {
        printDivider();
        out.print("Enter command: ");
        String fullInputLine = in.nextLine();
        printDivider();
        return fullInputLine.trim();
    }
}
