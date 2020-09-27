package commands;

public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    private final int targetedindex;

    public DeleteCommand(String targetedindex) {
        this.targetedindex = Integer.parseInt(targetedindex) - 1;
    }
    //Delete the task
    public void execute() {
        try {
            if (targetedindex >= tasks.getListSize()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.out.println("Noted. I've removed this task: ");
            System.out.println(" " +  tasks.getTask(targetedindex));
            tasks.removeTask(targetedindex);
            System.out.println("Now you have " + tasks.getListSize() + " tasks in the list.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u2639 The number is not in the list");
        }
    }
}
