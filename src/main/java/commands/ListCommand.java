package commands;

import data.duke.Task;

import static ui.TextUi.showToUser;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public void execute() {
        showToUser("Here are the tasks in your list:");
        int i = 1;
        for (Task t : taskList.getAllTasks()) {
            showToUser(i + "." +  t);
            i++;
        }
    }
}
