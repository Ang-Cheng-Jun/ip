package commands;

import data.duke.Task;
import data.exception.DukeException;

import java.util.ArrayList;

import static java.util.stream.Collectors.toList;
import static ui.TextUi.showToUser;

public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    private final String filterString;

    public FindCommand (String filterString) {
        this.filterString = filterString;
    }

    public void execute() {
        try {
            ArrayList<Task> filterTaskList = (ArrayList<Task>) taskList.getAllTasks().stream()
                .filter((s) -> s.getDescription().contains(filterString))
                .collect(toList());
            if (filterTaskList.isEmpty()){
                throw new DukeException();
            }
            showToUser("Here are the matching tasks in your list:");
            int i = 1;
            for (Task t : filterTaskList) {
                showToUser(i + "." + t);
                i++;
            }
        } catch (DukeException e) {
            showToUser("There is no matching tasks in your list:");
        }

    }
}
