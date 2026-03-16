package TodoApp;

import java.util.Scanner;
import java.util.ArrayList;

public class TodoApp {
    private ArrayList<String> tasks;
    public TodoApp() {tasks = new ArrayList<>();}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TodoApp app = new TodoApp();

        boolean running = true;

        while(running) {
            app.printMenu();
            int choice = input.nextInt();
            input.nextLine();

            switch(choice) {
                case 1 -> app.addTask(input);
                case 2 -> app.viewTask();
                case 3 -> app.deleteTask(input);
                case 4 -> {
                    System.out.println("Exiting....Goodbye");
                    running = false;
                }
                default -> System.out.println("Invalid Option");
            }
        }
        input.close();
    }

    public void printMenu() {
        System.out.println("-------Todo App Menu------");
        System.out.println("1. Add Task");
        System.out.println("2. View Task");
        System.out.println("3. Delete Task");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }

    public void addTask(Scanner input) {
        System.out.print("Enter a task: ");
        String task = input.nextLine();
        tasks.add(task);
        System.out.println("Task added!");
    }

    public void viewTask() {
        if(tasks.isEmpty()){
            System.out.println("No tasks to view");
        } else {
            System.out.println("Your Tasks (" + tasks.size() + "):");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + 1 + ". " + tasks.get(i));
            }
        }
        System.out.println();
    }

    public void deleteTask(Scanner input) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to delete");
        } else {
            System.out.println("Enter the number of the task you want to delete: ");
            int index = input.nextInt();
            input.nextLine();
            if (index > 0 && index <= tasks.size()) {
                String removed = tasks.remove(index - 1);
                System.out.println("Deleted: " + removed);
            } else {
                System.out.println("Invalid task number");
            }
        }
    }
}
