import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    String description;

    Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Description: " + description;
    }
}

public class TodoListApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Task\n2. Update Task\n3. Delete Task\n4. Display Tasks\n5. Search Task\n6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    tasks.add(new Task(title, desc));
                    System.out.println("Task added!");
                    break;
                case 2:
                    System.out.print("Enter index to update: ");
                    int updIndex = sc.nextInt();
                    sc.nextLine();
                    if(updIndex >= 0 && updIndex < tasks.size()) {
                        System.out.print("Enter new title: ");
                        tasks.get(updIndex).title = sc.nextLine();
                        System.out.print("Enter new description: ");
                        tasks.get(updIndex).description = sc.nextLine();
                        System.out.println("Task updated!");
                    } else System.out.println("Invalid index!");
                    break;
                case 3:
                    System.out.print("Enter index to delete: ");
                    int delIndex = sc.nextInt();
                    sc.nextLine();
                    if(delIndex >= 0 && delIndex < tasks.size()) {
                        tasks.remove(delIndex);
                        System.out.println("Task deleted!");
                    } else System.out.println("Invalid index!");
                    break;
                case 4:
                    if(tasks.isEmpty()) System.out.println("No tasks found.");
                    else {
                        for(int i=0; i<tasks.size(); i++) {
                            System.out.println(i + ". " + tasks.get(i));
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine().toLowerCase();
                    boolean found = false;
                    for(Task t : tasks) {
                        if(t.title.toLowerCase().contains(keyword) || t.description.toLowerCase().contains(keyword)) {
                            System.out.println(t);
                            found = true;
                        }
                    }
                    if(!found) System.out.println("No matching task found.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}