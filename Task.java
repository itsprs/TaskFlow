
public abstract class Task {

    protected String title;
    protected boolean isCompleted;

    public Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }

    public void complete() {
        this.isCompleted = true;
    }

    public abstract String getDetails();

    public String toFileString() {
        return title + "|" + isCompleted;
    }
}
