package commands;

import common.Messages;
import data.duke.Task;
import static ui.TextUi.showToUser;

/**
 * Lists all tasks in the TaskList to the user.
 */
public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public void execute() {
        showToUser(Messages.MESSAGE_LIST);
        int i = 1;
        for (Task t : taskList.getAllTasks()) {
            showToUser(i + "." +  t);
            i++;
        }
    }
}
