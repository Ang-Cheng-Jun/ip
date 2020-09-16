package duke;

public class Deadline extends Task {

    protected String by;
    protected boolean isDone;
    protected String category;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        isDone = false;
        category = "[D]";
    }

    public String getCategory() {
        return "D";
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return this.category + super.toString() + " (by:" + by + ")";
    }
}