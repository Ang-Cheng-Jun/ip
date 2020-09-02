public class Task {
    protected String description;
    protected boolean isDone;
    protected String category;

    public Task(String description) {
        this.description = description;
        this.category = "";
        this.isDone = false;
    }


    public String getStatusIcon() {
        if(!isDone) {
            return ("\u2718");
        } else {
            return ("\u2713");
        }
    }

    public void markAsDone() {
        this.isDone = true;
    }


    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}

