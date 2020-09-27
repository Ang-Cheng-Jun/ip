package commands;


import static ui.TextUi.showToUser;

public class DoneCommand extends Command {
    public static final String COMMAND_WORD = "done";
    private final int targetedIndex;

    public DoneCommand(String targetedIndex) {
        this.targetedIndex = Integer.parseInt(targetedIndex) - 1;
    }
    //Put a tick in the task
    public void execute() {
        try {
            if (targetedIndex >= taskList.getListSize()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            taskList.getTask(targetedIndex).putTick();
            showToUser("Nice! I've marked this task as done:");
            showToUser(" " +  taskList.getTask(targetedIndex));
        } catch (ArrayIndexOutOfBoundsException e) {
            showToUser("\u2639 The number is not in the list");
        }
    }
}
