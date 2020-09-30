package commands;

/**
 * Terminates the program.
 */
public class ByeCommand extends Command {
    public static final String COMMAND_WORD = "bye";

    public static boolean isBye(Command command) {
        return command instanceof ByeCommand; // instanceof returns false if it is null
    }

    public void execute() {
    }
}
