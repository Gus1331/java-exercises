import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        iniciar();

    }
    public static void soma(double n1, double n2) {
        System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
    }
    public static  void subracao(double n1, double n2){
        System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));
    }
    public static  void multiplicacao(double n1, double n2){
        System.out.println(n1 + " x " + n2 + " = " + (n1 * n2));
    }
    public static  void divisao(double n1, double n2){
        System.out.println(n1 + " / " + n2 + " = " + (n1 / n2));
    }

    public static void iniciar(){
        System.out.println("Seja bem vindo\n Selecione a operação desejada:\n1-Adição\n2-Subtração\n3-Multiplicação\n4-Divisão");
        Scanner scan = new Scanner(System.in);
        int op = scan.nextInt();
        System.out.println("Agora digite o primeiro numero:");
        double number1 = scan.nextDouble();
        System.out.println("Agora digite o segundo numero:");
        double number2 = scan.nextDouble();

        switch (op){
            case 1:
                soma(number1 ,number2);
                break;
            case 2:
                subracao(number1, number2);
                break;
            case 3:
                multiplicacao(number1, number2);
                break;
            case 4:
                divisao(number1, number2);
                break;
            default:
                System.out.println("ERRO");
                break;
        }
    iniciar();
    }
}
