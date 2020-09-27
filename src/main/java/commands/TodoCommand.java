package commands;

import data.duke.Todo;

import static ui.TextUi.showToUser;

public class TodoCommand extends Command {
    public static final String COMMAND_WORD = "todo";

    private final String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    //Add task under the "td" category
    public void execute() {
        taskList.addTask(new Todo(description));
        showToUser("Got it. I've added this task:");
        showToUser(" " + taskList.getTask(taskList.getListSize()- 1));
        showToUser("Now you have " + taskList.getListSize() + " tasks in the list.");
    }
}
