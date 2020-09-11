public class Event extends Task {

    protected String at;
    protected boolean isDone;
    protected String category;

    public Event(String description, String at) {
        super(description);
        this.at = at;
        isDone = false;
        category = "[E]";
    }

    @Override
    public String toString() {
        return this.category + super.toString() + " (at: " + at + ")";
    }
}