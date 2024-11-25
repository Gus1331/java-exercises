public class TesteBanco {
    public static void main(String[] args) {
        ContaBancaria conta01 = new ContaBancaria("sim");


        ContaBancaria conta02 = new ContaBancaria("nao");


        conta01.sacar(10.5);
    }
}
