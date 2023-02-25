public class Main {
    public static void main(String[] args) {
        System.out.println(Convert.string(1));
        System.out.println(Convert.string(2d));
        System.out.println(Convert.string(3f));
        System.out.println(Convert.string(true));
        System.out.println(Convert.string(5d) + Convert.string(5f)); //verificando se está em string
    }
}