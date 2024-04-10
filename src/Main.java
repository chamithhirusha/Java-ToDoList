import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n[1] New Task");
            System.out.println("[2] View Task");
            System.out.println("[3] Mark as done");
            System.out.println("[4] Delete Task");
            System.out.println("[0] Exit\n");

            switch (input.nextLine()) {
                case "0":
                    System.err.println("Exiting...");
                    System.exit(0);
                    break;

                case "1":
                    System.out.println("Enter task desciption : ");
                    tasks.add(new Task(input.nextLine()));
                    System.out.println("New task created!");
                    break;

                case "2":
                    System.err.println("Tasks List");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i).getDescription() + " [" + tasks.get(i).isCompleted() + "]");
                    }
                    break;

                case "3":
                    System.out.println("Enter task index to mark : ");
                    try {
                        tasks.get(Integer.valueOf(input.nextLine()) - 1).markAsCompleted();
                        System.out.println("Marked as completed!");
                    } catch (NumberFormatException e) {
                        System.err.println("Please enter a number");
                    } catch (Exception e) {
                        System.err.println("Invalid Number");
                    }
                    break;

                case "4":
                    System.out.println("Enter task index to remove : ");
                    try {
                        tasks.remove(Integer.valueOf(input.nextLine()) - 1);
                        System.out.println("Task Removed!");
                    } catch (NumberFormatException e) {
                        System.err.println("Please enter a number");
                    } catch (Exception e) {
                        System.err.println("Invalid Number");
                    }
                    break;

                default:
                    System.err.println("Please select item");
            }
        }
    }
}