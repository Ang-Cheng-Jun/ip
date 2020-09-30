package commands;


import common.Messages;
import static ui.TextUi.showToUser;

/**
 * Mark a Task from the TaskList to be done.
 */
public class DoneCommand extends Command {
    public static final String COMMAND_WORD = "done";
    private final int targetedIndex;

    public DoneCommand(String targetedIndex) {
        this.targetedIndex = Integer.parseInt(targetedIndex) - 1;
    }


    public void execute() {
        try {
            if (targetedIndex >= taskList.getListSize()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            taskList.getTask(targetedIndex).putTick();
            showToUser(Messages.MESSAGE_DONE);
            showToUser(Messages.SPACE +  taskList.getTask(targetedIndex));
        } catch (ArrayIndexOutOfBoundsException e) {
            showToUser(Messages.MESSAGE_NUM_NOT_IN_LIST);
        }
    }
}
