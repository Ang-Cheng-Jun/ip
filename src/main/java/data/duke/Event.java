package data.duke;

/**
 * Represents a Event_Task in the TaskList.
 */
public class Event extends Task {

    public static final String TYPE_WORD = "E";
    protected String at;

    /**
     * Convenience constructor using raw values.
     * Assumption: Every field must be present and not null.
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Returns Category Type.
     */
    public String getCategory() {
        return TYPE_WORD;
    }

    /**
     * Returns At(the location).
     */
    public String getAt() {
        return at;
    }

    /**
     * Return the string to display in command prompt
     */
    @Override
    public String toString() {
        return "[" + TYPE_WORD + "]" + super.toString() + " (at:" + at + ")";
    }
}