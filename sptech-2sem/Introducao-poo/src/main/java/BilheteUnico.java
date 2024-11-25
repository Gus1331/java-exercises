public class BilheteUnico {
    String nomeTitular;
    Double saldo;
    String codigo;

    public void carregar(Double valor) {

        if (valor <= 0) {
            System.out.println("Valor inválido");
        } else {
            this.saldo = +valor;
            System.out.println("Recarga efetuada");
        }
    }

}
