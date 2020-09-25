package commands;

import common.Messages;
import data.TaskList;
import data.duke.Event;
import data.duke.Task;
import data.exception.DukeException;
import ui.TextUi;

import java.util.ArrayList;

public class EventCommand {
    public static final String COMMAND_WORD = "event";

    //Add task under the "event" category
    public static int storeEvent(ArrayList<Task> list, String command, int num) {
        try {
            String description = command.substring(6, command.indexOf(" /"));
            String at = command.substring(command.indexOf("/") + 3);
            if(at.trim().isEmpty()) {
                throw new DukeException();
            }
            list.add(new Event(description, at));
            System.out.println("Got it. I've added this task:");
            System.out.println(" " + list.get(num));
            num++;
            System.out.println("Now you have " + num + " tasks in the list.");
        } catch (StringIndexOutOfBoundsException e) {
            TextUi.showToUser(Messages.MESSAGE_DESCRIPTION_EMPTY);
        } catch (DukeException e) {
            System.out.println("\u2639 The date/time of a event cannot be empty.");
        }
        return num;
    }
}
