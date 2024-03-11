import java.util.Scanner;

public class ExemploSwitchCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um dia da semana:");
        Integer diaDaSemana = sc.nextInt();

        switch (diaDaSemana){
            case 1:
                System.out.println("Aula de LP!!!");
                break;
            case 2:
                System.out.println("Terça");
                break;
            case 3:
                System.out.println("Quarta");
                break;
            case 4:
                System.out.println("Quinta");
                break;
            case 5:
                System.out.println("Sextou");
                break;
            default:
                System.out.println("Numero inválido!");
                break;
        }


        System.out.println("Digite uma fruta:");
        String fruta = sc.nextLine().toLowerCase();
        switch (fruta){
            case "maçã":
                System.out.println("Temos maçã no estoque!");
                break;
            case "melancia":
                System.out.println("Temos melancia no estoque!");
                break;
            case "kiwi":
                System.out.println("Não é época de kiwi, não temos!");
                break;
            default:
                System.out.println("Não identifiquei a fruta digitada");
                break;
        }
    }
}
