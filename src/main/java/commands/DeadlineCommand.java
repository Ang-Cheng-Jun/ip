package commands;

import common.Messages;
import data.duke.Deadline;
import data.duke.Task;
import data.exception.DukeException;
import ui.TextUi;

import java.util.ArrayList;

public class DeadlineCommand {
    public static final String COMMAND_WORD = "deadline";

    //Add task under the "deadline" category
    public static int storeDeadline(ArrayList<Task> list, String command, int num) {
        try {
            String description = command.substring(9, command.indexOf(" /"));
            String by = command.substring(command.indexOf("/") + 3);
            if (by.trim().isEmpty()) {
                throw new DukeException();
            }
            list.add(new Deadline(description, by));
            System.out.println("Got it. I've added this task:");
            System.out.println(" " + list.get(num));
            num++;
            System.out.println("Now you have " + num + " tasks in the list.");
        } catch (StringIndexOutOfBoundsException e) {
            TextUi.showToUser(Messages.MESSAGE_DESCRIPTION_EMPTY);
        } catch (DukeException e) {
            System.out.println("\u2639 The date/time of a deadline cannot be empty.");
        }
        return num;
    }
}
