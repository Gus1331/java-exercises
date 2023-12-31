package app;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ToDoList {
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    ArrayList<String> list = new ArrayList<>();
    ArrayList<Boolean> listProgression = new ArrayList<>();


    public void newTask(){
        System.out.println("type a new task: ");
        System.out.println();

        String task;
        task = sc.next();

        list.add(task);
        listProgression.add(false);
    }

    public void completeTask(){
        System.out.println("Witch task do you'd like to mark as 'done'?");
        int n = 0;
        for(String i : list) {
            n++;
            System.out.println(n+" - " + i + ".");
        }
        String selectedTask;
        selectedTask = sc.next();

        listProgression.set(Integer.parseInt(selectedTask) - 1, true);
    }

}
