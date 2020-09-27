package commands;

import data.duke.Deadline;

import static ui.TextUi.showToUser;

public class DeadlineCommand extends Command {
    public static final String COMMAND_WORD = "deadline";

    private final String description;
    private final String by;

    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    //Add task under the "td" category
    public void execute() {
        taskList.addTask(new Deadline(description, by));
        showToUser("Got it. I've added this task:");
        showToUser(" " +  taskList.getTask(taskList.getListSize()- 1));
        showToUser("Now you have " + taskList.getListSize() + " tasks in the list.");
    }
}
