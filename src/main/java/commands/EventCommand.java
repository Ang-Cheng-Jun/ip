package commands;

import data.duke.Event;

import static ui.TextUi.showToUser;

public class EventCommand extends Command {
    public static final String COMMAND_WORD = "event";

    private final String description;
    private final String at;

    public EventCommand(String description, String at) {
        this.description = description;
        this.at = at;
    }

    //Add task under the "event" category
    public void execute() {
        taskList.addTask(new Event(description, at));
        showToUser("Got it. I've added this task:");
        showToUser(" " +  taskList.getTask(taskList.getListSize()- 1));
        showToUser("Now you have " + taskList.getListSize() + " tasks in the list.");
    }
}
