package commands;

import data.TaskList;
import data.duke.Task;

import java.util.ArrayList;

public class ListCommand {
    public static final String COMMAND_WORD = "list";

    public static void printList(ArrayList<Task> list, int num) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= num; i++) {
            System.out.println(i + "." + list.get(i - 1));
        }
    }
}
