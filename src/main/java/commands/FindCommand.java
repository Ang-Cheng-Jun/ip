package commands;

import common.Messages;
import data.duke.Task;
import data.exception.IllegalValueException;
import java.util.ArrayList;
import static java.util.stream.Collectors.toList;
import static ui.TextUi.showToUser;

/**
 * Find a Task from the TaskList.
 */
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
                throw new IllegalValueException();
            }
            showToUser(Messages.MESSAGE_MATCH_LIST);
            int i = 1;
            for (Task t : filterTaskList) {
                showToUser(i + "." + t);
                i++;
            }
        } catch (IllegalValueException e) {
            showToUser(Messages.MESSAGE_NO_MATCH);
        }

    }
}
