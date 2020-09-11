package duke;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String category;

    public Task(String description) {
        this.description = description;
        category = "";
        isDone = false;
    }

    //Get a icon for the task
    public String getStatusIcon() {
        if(!isDone) {
            return ("\u2718");
        } else {
            return ("\u2713");
        }
    }

    //Put a tick in the task
    public void putTick() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}

