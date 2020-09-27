package commands;

import data.TaskList;

public class Command {
    protected TaskList taskList;

    protected Command() {
    }

    public void setData(TaskList tasks) {
        this.taskList = tasks;
    }

    public void execute() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }
}
