
import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, Runnable> menuActions = new HashMap<>();
    private final List<Task> taskList = new ArrayList<>();

    private final TaskRepository repository = new TaskRepository("tasks.txt");

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        taskList.addAll(repository.load());

        initMenu();
        while (true) {
            System.out.print("\nChoice > ");
            String choice = scanner.nextLine();
            System.out.println();
            if (menuActions.containsKey(choice)) {
                menuActions.get(choice).run();
                repository.save(taskList);
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private void handleAddTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        taskList.add(new BasicTask(title));
        System.out.println("Task added!");
    }

    private void handleViewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i).getDetails());
        }
    }

    private void handleCompleteTask() {
        handleViewTasks();
        if (taskList.isEmpty()) {
            return;
        }

        System.out.print("Enter task number to complete: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            taskList.get(index).complete();
            System.out.println("Task marked as done!");
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Invalid input.");
        }
    }

    private void handleDeleteTask() {
        handleViewTasks();
        if (taskList.isEmpty()) {
            return;
        }

        System.out.print("Enter task number to delete: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            taskList.remove(index);
            System.out.println("Task deleted.");
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Invalid input.");
        }
    }

    private void handleExit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    private void menuItem(String key, String label, Runnable action) {
        System.out.println(key + ". " + label);
        menuActions.put(key, action);
    }

    private void initMenu() {
        System.out.println("\n--- TASK MANAGER ---\n");
        menuItem("1", "[+] Add Task", this::handleAddTask);
        menuItem("2", "[-] View Tasks", this::handleViewTasks);
        menuItem("3", "[v] Complete", this::handleCompleteTask);
        menuItem("4", "[x] Delete", this::handleDeleteTask);
        menuItem("5", "[^] Exit", this::handleExit);
        System.out.println();
    }
}
