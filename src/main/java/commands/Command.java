package commands;

import data.TaskList;

/**
 * Represents an executable command.
 */
public class Command {
    protected TaskList taskList;

    protected Command() {
    }

    /**
     * Supplies the data the command will operate on.
     */
    public void setData(TaskList tasks) {
        this.taskList = tasks;
    }

    /**
     * Executes the command and returns the result.
     */
    public void execute() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }
}
