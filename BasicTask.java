
public class BasicTask extends Task {

    public BasicTask(String title) {
        super(title);
    }

    @Override
    public String getDetails() {
        String status = isCompleted ? "[v]" : "[ ]";
        return status + " " + title;
    }
}
