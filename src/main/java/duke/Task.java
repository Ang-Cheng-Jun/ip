package duke;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String category;
    protected String at;
    protected String by;

    public Task(String description) {
        this.description = description;
        category = "";
        isDone = false;
        at = "";
        by = "";
    }

    //Get a icon for the task
    public String getStatusIcon() {
        if(!isDone) {
            return ("\u2718");
        } else {
            return ("\u2713");
        }
    }

    //Get a icon for the task
    public String getDescription() {
        return description;
    }

    //Get a icon for the task
    public String getIsDone() {
        if(!isDone) {
            return ("0");
        } else {
            return ("1");
        }
    }

    //Get a icon for the task
    public String getCategory() {
        return category;
    }

    public String getBy() {
        return by;
    }

    public String getAt() {
        return at;
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

