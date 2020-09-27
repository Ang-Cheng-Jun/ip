package commands;

import data.duke.Deadline;

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
        tasks.addTask(new Deadline(description, by));
        System.out.println("Got it. I've added this task:");
        System.out.println(" " +  tasks.getTask(tasks.getListSize()- 1));
        System.out.println("Now you have " + tasks.getListSize() + " tasks in the list.");
    }
}
