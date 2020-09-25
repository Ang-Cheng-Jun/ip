package data.duke;

public class Event extends Task {

    public static final String TYPE_WORD = "E";
    protected String at;
    protected boolean isDone;

    public Event(String description, String at) {
        super(description);
        this.at = at;
        isDone = false;
    }

    public String getCategory() {
        return TYPE_WORD;
    }

    public String getAt() {
        return at;
    }

    @Override
    public String toString() {
        return "[" + TYPE_WORD + "]" + super.toString() + " (at:" + at + ")";
    }
}