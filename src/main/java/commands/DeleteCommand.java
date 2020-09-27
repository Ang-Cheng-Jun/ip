package commands;

import static ui.TextUi.showToUser;

public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    private final int targetedIndex;

    public DeleteCommand(String targetedIndex) {
        this.targetedIndex = Integer.parseInt(targetedIndex) - 1;
    }
    //Delete the task
    public void execute() {
        try {
            if (targetedIndex >= taskList.getListSize()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            showToUser("Noted. I've removed this task: ");
            showToUser(" " +  taskList.getTask(targetedIndex));
            taskList.removeTask(targetedIndex);
            showToUser("Now you have " + taskList.getListSize() + " tasks in the list.");
        } catch (ArrayIndexOutOfBoundsException e) {
            showToUser("\u2639 The number is not in the list");
        }
    }
}
