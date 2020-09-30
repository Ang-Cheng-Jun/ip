package commands;

import common.Messages;
import static ui.TextUi.showToUser;

/**
 * Deletes a Task from the TaskList.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";
    private final int targetedIndex;

    public DeleteCommand(String targetedIndex) {
        this.targetedIndex = Integer.parseInt(targetedIndex) - 1;
    }

    public void execute() {
        try {
            if (targetedIndex >= taskList.getListSize()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            showToUser(Messages.MESSAGE_DELETE);
            showToUser(Messages.SPACE +  taskList.getTask(targetedIndex));
            taskList.removeTask(targetedIndex);
            showToUser("Now you have " + taskList.getListSize() + " tasks in the list.");
        } catch (ArrayIndexOutOfBoundsException e) {
            showToUser(Messages.MESSAGE_NUM_NOT_IN_LIST);
        }
    }

}
