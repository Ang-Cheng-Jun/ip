package data.duke;

/**
 * Represents a Deadline_Task in the TaskList.
 */
public class Deadline extends Task {

    public static final String TYPE_WORD = "D";
    protected String by;

    /**
     * Convenience constructor using raw values.
     * Assumption: Every field must be present and not null.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns Category Type.
     */
    public String getCategory() {
        return TYPE_WORD;
    }

    /**
     * Returns By(the time).
     */
    public String getBy() {
        return by;
    }

    /**
     * Return the string to display in command prompt
     */
    @Override
    public String toString() {
        return "[" + TYPE_WORD + "]" + super.toString() + " (by:" + by + ")";
    }
}