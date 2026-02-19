import java.util.Scanner;
import java.util.ArrayList;

public class TodoApp {
   public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     ArrayList<String> tasks = new ArrayList<>();

     boolean running = true;
     
     while (running) {
       printMenu();
       int choice = input.nextInt();
       input.nextLine();

       switch(choice) {
        case 1 -> addTasks(input, tasks);
        case 2 -> viewTasks(tasks);
        case 3 -> deleteTasks(input, tasks);
        case 4 -> {
           running = false;
           System.out.println("Exiting....Goodbye");
        }
        default -> System.out.print("Invalid option");
       }
     }
     input.close();
   }

   public static void printMenu() {
     System.out.println("---TO DO LIST---");
     System.out.println("1. Add Task");
     System.out.println("2. View Task");
     System.out.println("3. Delete Task");
     System.out.println("4. Exit");
     System.out.println("Choose an option from the menu");
   }
   
   public static void addTasks(Scanner input, ArrayList<String> tasks) {
      System.out.println("Enter a task: ");
      String task = input.nextLine();
      tasks.add(task);
   }
   
   public static void viewTasks(ArrayList<String> tasks) {
     System.out.println("Your Tasks: ");
     for (int i=0; i < tasks.size(); i++) {
       System.out.println(i+1 + ". " + tasks.get(i));
     }
     System.out.println();
   }

   public static void deleteTasks(Scanner input, ArrayList<String>tasks) {
     System.out.println("Enter task number to delete");
     int index = input.nextInt();
     input.nextLine();
     if (index > 0 && index <= tasks.size()) {
       tasks.remove(index-1);
       System.out.println("Deleted task");
     } else {
         System.out.println("Invalid option");
       }
   }
}