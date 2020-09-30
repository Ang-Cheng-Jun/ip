package data.duke;

/**
 * Represents a Task in the TaskList.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Task {

    protected String description;
    protected boolean isDone;
    private static final String TICK_SYMBOL = "\u2713";
    private static final String CROSS_SYMBOL = "\u2718";
    private static final String TICK_NUM = "1";
    private static final String CROSS_NUM = "0";

    /**
     * Assumption: Every field must be present and not null.
     */
    public Task(String description) {
        this.description = description;
        isDone = false;
    }

    /**
     * Returns TICK_SYMBOL if tasks is completed for command prompt display.
     */
    public String getStatusIcon() {
        if(isDone) {
            return TICK_SYMBOL;
        } else {
            return CROSS_SYMBOL;
        }
    }

    /**
     * Returns description of the Task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns TICK_NUM if tasks is completed for txt.file.
     */
    public String getIsDone() {
        if(isDone) {
            return TICK_NUM;
        } else {
            return CROSS_NUM;
        }
    }

    /**
     * Copy constructor.
     */
    public String getCategory() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }

    public String getBy() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }

    public String getAt() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }

    /**
     * Change the isDone to true once markToDone is executed.
     */
    public void putTick() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}

