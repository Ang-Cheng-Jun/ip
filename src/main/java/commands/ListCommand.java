package commands;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public void execute() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= tasks.getListSize(); i++) {
            System.out.println(i + "." +  tasks.getTask(i - 1));
        }
    }
}
