import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilhaObj pilha = new PilhaObj<Operacao>(10);
        FilaObj fila = new FilaObj<Operacao>(10);

        int operacoesRealizadas = 0;

        ContaBancaria a = new ContaBancaria(1, 1000.0);
        ContaBancaria b = new ContaBancaria(2, 10000.0);

        int escolha = 0;
        do {
            System.out.println("Escolha um numero:\n" +
                    "1- Debitar valor\n" +
                    "2- Creditar (Depositar) valor\n" +
                    "3- Desfazer operação\n" +
                    "4- Agendar operação\n" +
                    "5- Executar operações agendadas\n" +
                    "6- Sair\n");
            escolha = sc.nextInt();

            switch (escolha) {
                case 6:
                    break;
                case 5:
                    break;
                case 4:
                    break;
                case 3:
                    break;
                case 2:
                    break;
                case 1:
                    System.out.println("Numero da conta");

                    System.out.println("Valor para debitar:");

                    break;
                default:
                    System.out.println("Numero inválido");
            }
        } while (escolha != 6);
    }
}
