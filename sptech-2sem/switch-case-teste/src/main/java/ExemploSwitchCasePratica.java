import java.util.Scanner;

public class ExemploSwitchCasePratica {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Integer comando;
        do {
            System.out.println("""
                    1 - Somar
                    2 - Subtrair
                    3 - Multiplicar
                    """);
            comando = sc.nextInt();
        } while (comando != 1 && comando != 2 && comando != 3);


        Integer n1 = sc.nextInt();
        Integer n2 = sc.nextInt();

        switch (comando) {
            case 1:
                System.out.println(n1 + n2);
                break;
            case 2:
                System.out.println(n1 - n2);
                break;
            case 3:
                System.out.println(n1 * n2);
                break;
        }


    }
}
