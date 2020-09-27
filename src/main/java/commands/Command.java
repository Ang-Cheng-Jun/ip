package commands;

import data.TaskList;

public class Command {
    protected TaskList tasks;

    protected Command() {
    }

    public void setData(TaskList tasks) {
        this.tasks = tasks;
    }

    public void execute() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }
}
