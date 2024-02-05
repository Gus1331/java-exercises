import dom.Account;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        System.out.println("Nome do dono: ");
        String dono = sc.nextLine();

        System.out.println("Numero da conta: ");
        int numConta = Integer.parseInt(sc.nextLine());

        System.out.println("Conta corrente (cc) ou conta poupança (cp)?");
        String tipo = sc.nextLine();

        Account c1 = new Account(dono, numConta, tipo);

        while (true) {
            System.out.println("1 - Abrir conta");
            System.out.println("2 - Fechar conta");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Aplicar mensalidade");
            System.out.println("6 - Status");

            int com = Integer.parseInt(sc.nextLine());

            switch (com) {
                case 1:
                        c1.abrirConta();
                    break;
                case 2:
                        c1.fecharConta();
                    break;
                case 3:
                        System.out.println("Quantia a depositar");
                        double din = Double.parseDouble(sc.nextLine());
                        c1.depositar(din);
                    break;
                case 4:
                        System.out.println("Quantia a sacar");
                        double dinh = Double.parseDouble(sc.nextLine());
                        c1.sacar(dinh);
                    break;
                case 5:
                        c1.pagarMensal();
                    break;
                case 6:
                    System.out.println();
                    System.out.println("Sobre a conta:");
                    System.out.println(c1.getDono());
                    System.out.println(c1.getNumConta());
                    System.out.println(c1.getTipo());
                    System.out.println(c1.getSaldo());
                    System.out.println(c1.getStatus());
                    System.out.println();
            }

        }
    }
}
