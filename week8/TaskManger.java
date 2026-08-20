import java.util.ArrayList;

public class TaskManager {
    public static void main(String[] args) {
        // Creating an ArrayList to store tasks
        ArrayList<String> tasks = new ArrayList<>();

        // Adding tasks
        tasks.add("Drink water");
        tasks.add("Complete AI course");
        tasks.add("Review OOP concepts");

        System.out.println("====== TASK LIST ======");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}
