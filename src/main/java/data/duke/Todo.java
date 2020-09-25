package data.duke;

public class Todo extends Task {

    public static final String TYPE_WORD = "T";
    protected boolean isDone;

    public Todo(String description) {
        super(description);
        isDone = false;
    }

    public String getCategory() {
        return TYPE_WORD;
    }

    @Override
    public String toString() {
        return "[" + TYPE_WORD + "]" + super.toString();
    }
}
