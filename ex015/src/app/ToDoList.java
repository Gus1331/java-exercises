package app;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ToDoList {
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    ArrayList<String> list = new ArrayList<>();
    ArrayList<Boolean> listProgression = new ArrayList<>();


    public void newTask() {
        System.out.println("type a new task: ");
        System.out.println();

        String task;
        task = sc.nextLine();

        list.add(task);
        listProgression.add(false);
    }

    public void completeTask() {

        if (list.size() == 0) {
            System.out.println("You don't have any task to complete, please create a new task using /create");

        } else {

            System.out.println("Which task would you like to mark as 'done'?");
            int n = 0;
            for (String i : list) {
                n++;
                System.out.println(n + " - " + i + ".");
            }
            String selectedTask;
            selectedTask = sc.nextLine();

            listProgression.set(Integer.parseInt(selectedTask) - 1, true);
        }
    }

    public void editTask() {

        if (list.size() == 0) {
            System.out.println("You don't have any task to edit, please create a new task using /create");

        } else {

            System.out.println("Which task would you like to edit?");
            int n = 0;
            for (String i : list) {
                n++;
                System.out.println(n + " - " + i + ".");
            }
            String selectedTask;
            selectedTask = sc.nextLine();

            System.out.println();
            System.out.println("Are you sure you want to edit: " +
                    selectedTask + " - " + list.get(Integer.parseInt(selectedTask) - 1) + "?");
            System.out.println("1 - Edit task;");

            if (listProgression.get(Integer.parseInt(selectedTask) - 1)) {
                System.out.println("2 - Mark as undone;");
            } else {
                System.out.println("2 - Mark as done;");
            }

            System.out.println("3 - Cancel;");

            String selectedOption;
            selectedOption = sc.nextLine();

            switch (selectedOption) {
                case "1":
                    System.out.println("type the task:");
                    System.out.println();
                    String updateTask;
                    updateTask = sc.nextLine();
                    list.set(Integer.parseInt(selectedTask) - 1, updateTask);
                    System.out.println("Task updated!");
                    break;
                case "2":
                    if (listProgression.get(Integer.parseInt(selectedTask) - 1)) {
                        listProgression.set(Integer.parseInt(selectedTask) - 1, false);
                    } else {
                        listProgression.set(Integer.parseInt(selectedTask) - 1, true);
                    }
                    System.out.println("Task updated!");
                    break;
                default:
                    System.out.println("cancel");
                    break;
            }
        }
    }

    public void deleteTask() {

        if (list.size() == 0) {
            System.out.println("You don't have any task to delete, please create a new task using /create");

        } else {

            System.out.println("Which task would you like to delete?");
            int n = 0;
            for (String i : list) {
                n++;
                System.out.println(n + " - " + i + ".");
            }
            String selectedTask;
            selectedTask = sc.nextLine();

            System.out.println();
            System.out.println("Are you sure you want to delete: " +
                    selectedTask + " - " + list.get(Integer.parseInt(selectedTask) - 1) + "?");
            String confirm = "";

            while (!confirm.equals("y") && !confirm.equals("n")) {
                System.out.println("press: y/n");
                confirm = sc.nextLine();
            }

            switch (confirm) {
                case "y":
                    list.remove(Integer.parseInt(selectedTask) - 1);
                    listProgression.remove(Integer.parseInt(selectedTask) - 1);
                    System.out.println("task deleted...");
                    break;
                case "n":
                    break;
            }

        }
    }

    public void clearTasks() {
        if (list.size() == 0) {
            System.out.println("Your task list is already empty, please create a new task using /create");
            System.out.println();

        } else {

            System.out.println();
            System.out.println("Are you sure you want to delete all tasks? (This action can't be undone)");
            System.out.println("type: CONFIRM");
            String confirm;
            confirm = sc.nextLine();
            if (confirm.equals("CONFIRM")) {
                list = new ArrayList<>();
                listProgression = new ArrayList<>();
                System.out.println("All tasks have benn deleted!");
            } else {
                System.out.println("Operation canceled!");
                System.out.println();
            }
        }
    }
}

