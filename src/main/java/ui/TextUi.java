package ui;

import common.Messages;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TextUi {

    private static final String LINE_PREFIX = "|| ";
    private static final String DIVIDER = "===================================================";
    private static final String LS = System.lineSeparator();

    private static Scanner in;
    private static PrintStream out;

    public TextUi() {
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public void showWelcomeMessage() {
        showToUser(Messages.MESSAGE_WELCOME);
    }

    public void showByeMessage() {
        showToUser(Messages.MESSAGE_GOODBYE);
    }

    public static void showToUser(String message) {
        out.println(message);
    }



    public String getUserCommand() {
        out.print("Enter command: ");
        String fullInputLine = in.nextLine();

        return fullInputLine.trim();
    }
}
