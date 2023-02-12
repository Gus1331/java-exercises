import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Type a number between 0 and 10: ");

        int cont = 1;
        int num;  //number insert

        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();

        while(num < 0 || num > 10){ //force user to use a valid number
            System.out.println("Invalid number, please try again a number between 0 and 10");
            num = scan.nextInt();
        };

        do{  // prints multiplication table
            System.out.println(num + " x " + cont + " = " + (num * cont));
            cont++;
        }while(cont <= 10);

    };
};