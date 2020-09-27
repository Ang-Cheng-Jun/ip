package commands;

import data.duke.Event;

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
        tasks.addTask(new Event(description, at));
        System.out.println("Got it. I've added this task:");
        System.out.println(" " +  tasks.getTask(tasks.getListSize()- 1));
        System.out.println("Now you have " + tasks.getListSize() + " tasks in the list.");
    }
}
