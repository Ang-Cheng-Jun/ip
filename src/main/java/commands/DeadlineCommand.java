package commands;

import common.Messages;
import data.duke.Deadline;
import static ui.TextUi.showToUser;

/**
 * Add a Deadline_Task to the TaskList
 */
public class DeadlineCommand extends Command {

    public static final String COMMAND_WORD = "deadline";
    private final String description;
    private final String by;

    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    public void execute() {
        taskList.addTask(new Deadline(description, by));
        showToUser(Messages.MESSAGE_ADDED);
        showToUser(Messages.SPACE +  taskList.getTask(taskList.getListSize()- 1));
        showToUser("Now you have " + taskList.getListSize() + " tasks in the list.");
    }

}
