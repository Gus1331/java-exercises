package app;

import java.util.Locale;
import java.util.Scanner;

import command.Help;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        String[] commands = {"/help", "/create", "/update", "/delete", "/complete"};

        Help comHelp = new Help();
        ToDoList comToDoList = new ToDoList();


        while (true) {
            System.out.println("To do-list");
            System.out.println();

            System.out.println("type /help to see all interactions");
            String interaction;
            interaction = sc.next();

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
                case "/update":
                    break;
                case "/delete":
                    break;
                case "/complete":
                    comToDoList.completeTask();
                    break;
                default:
                    System.out.println(interaction);
            }
            System.out.println();

            int n = 0;
            for (String i : comToDoList.list) {
                n++;
                String completion = "Não completada";
                if (comToDoList.listProgression.get(n - 1)) {
                    completion = "Completada!";
                }
                System.out.println(n + " - " + i + " . (" + completion + ")");
            }

            System.out.println();
        }
    }
}
