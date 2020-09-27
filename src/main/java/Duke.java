import commands.ByeCommand;
import commands.Command;
import common.Messages;
import data.TaskList;
import parser.Parser;
import storage.Storage;
import ui.TextUi;

public class Duke {

    private static TextUi ui = new TextUi();
    private static TaskList tasks = new TaskList();
    private static Storage storage = new Storage(tasks);


    public static void main(String[] args) {
        new Duke().run();
    }

    public void run() {
        start();
        runCommandLoopUntilByeCommand();
        exit();
    }

    private void start() {
        this.ui = new TextUi();
        initialise();
        ui.showWelcomeMessage();
    }

    private static void initialise() {
        ui.showToUser(Messages.MESSAGE_INITIALISE);
        storage.importFileContents();
    }

    private static void exit() {
        ui.showByeMessage();
        System.exit(0);
    }

    private static void runCommandLoopUntilByeCommand() {
        Command command;
        do {
            String userCommandText = ui.getUserCommand();
            command = Parser.parseCommand(userCommandText);
            command.setData(tasks);
            command.execute();
            storage.writeToFile();
        } while (!ByeCommand.isBye(command));
    }

}
