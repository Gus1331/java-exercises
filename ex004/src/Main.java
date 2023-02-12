import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("enter 0 on name to stop; ");

        while(true) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Name: ");
            String name = scan.next();

            if(name.equals("0")) break; //break while cycle

            System.out.println("Age: ");
            int age = scan.nextInt();

            System.out.println("Welcome: " + name + ", " + age + " years old.");
        }
        System.out.println("Thank you for answering our questions!!!");
    }
}