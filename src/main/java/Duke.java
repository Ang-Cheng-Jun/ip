import common.Messages;
import data.duke.Task;
import parser.Parser;
import storage.Storage;
import ui.TextUi;

import java.util.ArrayList;

public class Duke {

    private static int num;
    private TextUi ui;
    private ArrayList<Task> list = new ArrayList<>();

    public static void main(String[] args) {
        new Duke().run();
    }

    public void run() {
        start();
        Parser.runCommandLoopUntilByeCommand(list, num);
        exit();
    }

    private void start() {
        this.ui = new TextUi();
        num = initialise();
        ui.showWelcomeMessage();
    }

    private void exit() {
        ui.showByeMessage();
        System.exit(0);
    }

    private int initialise() {
        ui.showToUser(Messages.MESSAGE_INITIALISE);
        num = Storage.importFileContents(list);
        return num;
    }

}
