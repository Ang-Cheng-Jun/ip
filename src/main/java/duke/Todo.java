package duke;

public class Todo extends Task {

    protected boolean isDone;
    protected String category;

    public Todo(String description) {
        super(description);
        isDone = false;
        category = "[T]";
    }

    @Override
    public String toString() {
        return this.category + super.toString();
    }
}
