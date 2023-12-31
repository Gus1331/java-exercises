package app;

public class Program {
    public static void main(String[] args) {
        String name = "God Gus";
        System.out.println("Nome = " + name);

        int age = 20;
        boolean isDeveloper = false;
        double moneyAccont = 13.99;

        System.out.println(age + " Anos");


        if (isDeveloper) {
            System.out.println("Desenvolvedor");
        } else {
            System.out.println("Não programa");
        }

        String msg = "Tem ".concat(String.valueOf(moneyAccont)).concat("R$ na conta do banco");

        System.out.println(msg);
    }
}
