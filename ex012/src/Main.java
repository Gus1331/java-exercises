public class Main {
    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario();

        //Upcasts
        Funcionario gerente0 = new Gerente();
        Funcionario vendedor0 = new Vendedor();
        Funcionario faxineiro0 = new Faxineiro();

        //Downcast explicito
        // Vendedor vendedor1 = (Vendedor) new Funcionario();
    }
}