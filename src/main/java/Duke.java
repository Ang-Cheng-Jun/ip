import commands.ByeCommand;
import commands.Command;
import common.Messages;
import data.TaskList;
import parser.Parser;
import storage.Storage;
import ui.TextUi;

/**
 * Entry point of the Duke application.
 * Initializes the application and starts the interaction with the user.
 */

public class Duke {

    private static TextUi ui = new TextUi();
    private static TaskList taskList = new TaskList();
    private static Storage storage = new Storage(taskList);


    public static void main(String[] args) {
        new Duke().run();
    }

    /** Runs the program until termination.  */
    public void run() {
        start();
        runCommandLoopUntilByeCommand();
        exit();
    }

    /**
     * Initialise the import of data from the text file,
     * and prints the welcome message.
     *
     */
    private void start() {
        this.ui = new TextUi();
        initialise();
        ui.showWelcomeMessage();
    }

    /** Prints the Initialise message and import data*/
    private static void initialise() {
        ui.showToUser(Messages.MESSAGE_INITIALISE);
        storage.importFileContents();
    }

    /** Prints the Goodbye message and exits. */
    private static void exit() {
        ui.showByeMessage();
        System.exit(0);
    }

    /** Reads the user command and executes it, until the user issues the bye command.  */
    private static void runCommandLoopUntilByeCommand() {
        Command command;
        do {
            String userCommandText = ui.getUserCommand();
            command = Parser.parseCommand(userCommandText);
            command.setData(taskList);
            command.execute();
            storage.writeToFile();
        } while (!ByeCommand.isBye(command));
    }

}
