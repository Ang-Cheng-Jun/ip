package data.duke;

public class Deadline extends Task {

    public static final String TYPE_WORD = "D";
    protected String by;
    protected boolean isDone;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        isDone = false;
    }

    public String getCategory() {
        return TYPE_WORD;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[" + TYPE_WORD + "]" + super.toString() + " (by:" + by + ")";
    }
}