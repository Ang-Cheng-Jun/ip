package commands;

import static ui.TextUi.showToUser;

/**
 * Represents an invalid command. Upon execution, produces some feedback to the user.
 */
public class InvalidCommand extends Command {

    public final String feedbackToUser;

    public InvalidCommand(String feedbackToUser) {
        this.feedbackToUser = feedbackToUser;
    }

    @Override
    public void execute() {
        showToUser(this.feedbackToUser);
    }

}
