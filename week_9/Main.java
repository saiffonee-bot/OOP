import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = FileManager.loadTasks();

        System.out.println("==================================");
        System.out.println(" Welcome to Task Manager App! ");
        System.out.println("==================================");

        boolean running = true;
        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. View all tasks");
            System.out.println("2. Add a new task");
            System.out.println("3. Exit");
            System.out.print("Enter choice (1-3): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\n--- Your Tasks ---");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case "2":
                    System.out.print("\nEnter new task description: ");
                    String newTask = scanner.nextLine();
                    if (!newTask.trim().isEmpty()) {
                        tasks.add(newTask);
                        FileManager.saveTasks(tasks);
                        System.out.println("Task added and saved successfully!");
                    } else {
                        System.out.println("Task description cannot be empty.");
                    }
                    break;

                case "3":
                    running = false;
                    System.out.println("\nGoodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}
