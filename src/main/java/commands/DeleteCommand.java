package commands;

import data.TaskList;
import data.duke.Task;

import java.util.ArrayList;

public class DeleteCommand {
    public static final String COMMAND_WORD = "delete";

    //Delete the task
    public static int deleteTask(ArrayList<Task> list, String command, int num) {
        try {
            String[] word = command.split(" ");
            int index = Integer.parseInt(word[1]) - 1;
            if (index >= num) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.out.println("Noted. I've removed this task: ");
            System.out.println(" " + list.get(index));
            list.remove(index);
            num--;
            System.out.println("Now you have " + num + " tasks in the list.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u2639 The number is not in the list");
        }
        return num;
    }
}
