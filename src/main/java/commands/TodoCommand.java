package commands;

import data.duke.Todo;

public class TodoCommand extends Command {
    public static final String COMMAND_WORD = "todo";

    private final String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    //Add task under the "td" category
    public void execute() {
        tasks.addTask(new Todo(description));
        System.out.println("Got it. I've added this task:");
        System.out.println(" " + tasks.getTask(tasks.getListSize()- 1));
        System.out.println("Now you have " + tasks.getListSize() + " tasks in the list.");
    }
}
