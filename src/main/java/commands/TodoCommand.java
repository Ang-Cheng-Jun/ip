package commands;

import common.Messages;
import data.TaskList;
import data.duke.Task;
import data.duke.Todo;
import ui.TextUi;

import java.util.ArrayList;

public class TodoCommand {
    public static final String COMMAND_WORD = "todo";

    //Add task under the "td" category
    public static int storeTodo(ArrayList<Task> list, String command, int num) {
        try {
            String description = command.substring(5);
            list.add(new Todo(description));
            System.out.println("Got it. I've added this task:");
            System.out.println(" " + list.get(num));
            num++;
            System.out.println("Now you have " + num + " tasks in the list.");
        } catch (StringIndexOutOfBoundsException e) {
            TextUi.showToUser(Messages.MESSAGE_DESCRIPTION_EMPTY);
        }

        return num;
    }
}
