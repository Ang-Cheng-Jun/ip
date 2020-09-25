package data.duke;

public class Task {
    protected String description;
    protected boolean isDone;
    private static final String TICK_SYMBOL = "\u2713";
    private static final String CROSS_SYMBOL = "\u2718";
    private static final String TICK_NUM = "1";
    private static final String CROSS_NUM = "0";

    public Task(String description) {
        this.description = description;
        isDone = false;
    }

    //Get a icon for the task
    public String getStatusIcon() {
        if(isDone) {
            return TICK_SYMBOL;
        } else {
            return CROSS_SYMBOL;
        }
    }

    //Get a icon for the task
    public String getDescription() {
        return description;
    }

    //Get a icon for the task
    public String getIsDone() {
        if(isDone) {
            return TICK_NUM;
        } else {
            return CROSS_NUM;
        }
    }

    //Get a icon for the task
    public String getCategory() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }

    public String getBy() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }

    public String getAt() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
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

