package commands;


public class DoneCommand extends Command {
    public static final String COMMAND_WORD = "done";
    private final int targetedindex;

    public DoneCommand(String targetedindex) {
        this.targetedindex = Integer.parseInt(targetedindex) - 1;
    }
    //Put a tick in the task
    public void execute() {
        try {
            if (targetedindex >= tasks.getListSize()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            tasks.getTask(targetedindex).putTick();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(" " +  tasks.getTask(targetedindex));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u2639 The number is not in the list");
        }
    }
}
