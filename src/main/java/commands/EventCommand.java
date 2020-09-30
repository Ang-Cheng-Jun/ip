package commands;

import common.Messages;
import data.duke.Event;
import static ui.TextUi.showToUser;

/**
 * Add a Event_Task to the TaskList
 */
public class EventCommand extends Command {

    public static final String COMMAND_WORD = "event";
    private final String description;
    private final String at;

    public EventCommand(String description, String at) {
        this.description = description;
        this.at = at;
    }

    public void execute() {
        taskList.addTask(new Event(description, at));
        showToUser(Messages.MESSAGE_ADDED);
        showToUser(Messages.SPACE +  taskList.getTask(taskList.getListSize() - 1));
        showToUser("Now you have " + taskList.getListSize() + " tasks in the list.");
    }

}
