package commands;

import common.Messages;
import data.duke.Todo;
import static ui.TextUi.showToUser;

/**
 * Add a Todo_Task to the TaskList
 */
public class TodoCommand extends Command {

    public static final String COMMAND_WORD = "todo";
    private final String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    public void execute() {
        taskList.addTask(new Todo(description));
        showToUser(Messages.MESSAGE_ADDED);
        showToUser(Messages.SPACE + taskList.getTask(taskList.getListSize() - 1));
        showToUser("Now you have " + taskList.getListSize() + " tasks in the list.");
    }

}
