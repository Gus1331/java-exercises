import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = scanner.next();

        System.out.println("How old are you?");
        int age = scanner.nextInt();

        System.out.println("Hello "+ name + " " + age);
    }
}