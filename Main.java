
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                showMenu();

                System.out.print("Enter choice: ");
                String input = scanner.nextLine();

                switch (input) {
                    case "1" ->
                        handleAddTask();
                    case "2" ->
                        handleViewTasks();
                    case "3" ->
                        handleCompleteTask();
                    case "4" ->
                        handleDeleteTask();
                    case "5" -> {
                        System.out.println("Exiting TaskFlow... 👋");
                        running = false;
                    }
                    default ->
                        System.out.println("❌ Invalid choice. Try again.");
                }
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n========== TASKFLOW ==========\n");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Complete Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.println("\n==============================\n");
    }

    // ---- Placeholder methods (we'll implement later) ----
    private static void handleAddTask() {
        System.out.println("👉 Add Task (coming next)");
    }

    private static void handleViewTasks() {
        System.out.println("📋 View Tasks (coming next)");
    }

    private static void handleCompleteTask() {
        System.out.println("✔ Complete Task (coming next)");
    }

    private static void handleDeleteTask() {
        System.out.println("🗑 Delete Task (coming next)");
    }
}
