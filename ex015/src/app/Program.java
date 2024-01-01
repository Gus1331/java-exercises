package app;

import java.util.Locale;
import java.util.Scanner;

import command.Help;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        // String[] commands = {"/help", "/create", "/update", "/delete", "/complete", "/clear"};

        Help comHelp = new Help();
        ToDoList comToDoList = new ToDoList();

        System.out.println("To do-list");
        System.out.println();
        System.out.println("type /help to see all interactions");

        while (true) {

            String interaction;
            interaction = sc.nextLine();

/*            VERIFICA SE O COMANDO EXISTE
              for (String i : commands){
                  System.out.println(i.equals(interaction));
                  //PRINTA TRUE OR FALSE
              }
*/
            switch (interaction) {
                case "/help":
                    comHelp.printDescriptions();
                    break;
                case "/create":
                    comToDoList.newTask();
                    break;
                case "/edit":
                    comToDoList.editTask();
                    break;
                case "/delete":
                    comToDoList.deleteTask();
                    break;
                case "/complete":
                    comToDoList.completeTask();
                    break;
                case "/clear":
                    comToDoList.clearTasks();
                    break;
                default:
                    System.out.println("error: " + interaction + "does not exist!");
                    System.out.println("type /help to see all interactions");
            }
            System.out.println();

            if(comToDoList.list.size() == 0){
                System.out.println("You didn't create any tasks yet!");
            } else {
                int n = 0;

                for (String i : comToDoList.list) {
                    String completion = " ";
                    if (comToDoList.listProgression.get(n)) {
                        completion = "✓";
                    }
                    System.out.println((n + 1) + " - (" + completion + ") " + " " + i + ".");
                    n++;
                }
            }


            System.out.println();
        }
    }
}
