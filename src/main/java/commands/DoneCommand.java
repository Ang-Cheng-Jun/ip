package commands;


import data.TaskList;
import data.duke.Task;

import java.util.ArrayList;

public class DoneCommand {
    public static final String COMMAND_WORD = "done";

    //Put a tick in the task
    public static void markAsDone(ArrayList<Task> list, String command, int num) {
        try {
            String[] word = command.split(" ");
            int index = Integer.parseInt(word[1]) - 1;
            if (index >= num) {
                throw new ArrayIndexOutOfBoundsException();
            }
            list.get(index).putTick();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(" " + list.get(index));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u2639 The number is not in the list");
        }
    }
}
