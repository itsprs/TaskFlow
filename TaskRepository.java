
import java.io.*;
import java.util.*;

public class TaskRepository {

    private final String fileName;

    public TaskRepository(String fileName) {
        this.fileName = fileName;
    }

    public void save(List<Task> tasks) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Task t : tasks) {
                writer.println(t.toFileString());
            }
        } catch (IOException e) {
            System.err.println("Could not save tasks: " + e.getMessage());
        }
    }

    public List<Task> load() {
        List<Task> loadedTasks = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) {
            return loadedTasks;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] data = line.split("\\|");
                BasicTask task = new BasicTask(data[0]);
                if (Boolean.parseBoolean(data[1])) {
                    task.complete();
                }
                loadedTasks.add(task);
            }
        } catch (Exception e) {
            System.err.println("Could not load tasks.");
        }
        return loadedTasks;
    }
}
