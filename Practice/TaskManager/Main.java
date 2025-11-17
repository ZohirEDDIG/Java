import java.util.Scanner;

import model.WorkTask;
import model.PersonalTask;
import model.TaskPriority;

import service.SimpleTaskManager;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleTaskManager manager = new SimpleTaskManager();

        while (true) {
            System.out.println("\n=== TASK MANAGER ===");
            System.out.println("1. Add task");
            System.out.println("2. List tasks");
            System.out.println("3. Mark task as done");
            System.out.println("4. Save tasks");
            System.out.println("5. Load tasks");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Work or Personal? ");
                    String type = sc.nextLine().trim().toUpperCase();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Priority: (LOW/MEDIUM/HIGH): ");
                    TaskPriority priority = TaskPriority.fromString(sc.nextLine());

                    int id = manager.getNextId();

                    if (type.equals("WORK")) {
                        System.out.print("Project: ");
                        String project = sc.nextLine();
                        WorkTask workTask = new WorkTask(id, title, priority, project);
                        manager.addTask(workTask);
                    } else {
                        System.out.print("Note: ");
                        String note = sc.nextLine();
                        PersonalTask personalTask = new PersonalTask(id, title, priority, note);
                        manager.addTask(personalTask);
                    }

                    System.out.println("Task added!");
                } 
                
                case 2 -> {
                    System.out.println("\n--- All Tasks ---");
                    for (model.Task t : manager.listTasks()) {
                        System.out.println(t.displayInfo());
                    }
                }  
                
                case 3 -> {
                    System.out.print("Task ID: ");
                    int id = sc.nextInt();
                    if (manager.markTaskDone(id)) {
                        System.out.println("Marked as done!");
                    } else {
                        System.out.println("Task not found!");
                    }
                } 
                
                case 4 -> {
                    try {
                        manager.saveToFile("tasks.txt");
                        System.out.println("Saved to tasks.txt");
                    } catch (Exception e) {
                        System.out.println("Error saving file");
                    }
                } 
                
                case 5 -> {
                    try {
                        manager.loadFromFile("tasks.txt");
                        System.out.println("Loaded from tasks.txt");
                    } catch (Exception e) {
                        System.out.println("Error loading file");
                    }
                } 
                
                case 6 -> {
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                }  default -> System.out.println("Invalid option");
            }
        }

    }
}