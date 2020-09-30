package data.duke;


/**
 * Represents a Todo_Task in the TaskList.
 */
public class Todo extends Task {

    public static final String TYPE_WORD = "T";

    /**
     * Convenience constructor using raw values.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns Category Type.
     */
    public String getCategory() {
        return TYPE_WORD;
    }

    /**
     * Return the string to display in command prompt
     */
    @Override
    public String toString() {
        return "[" + TYPE_WORD + "]" + super.toString();
    }
}
