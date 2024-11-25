public class CofrinhoDesafio {

    String meta;
    Double poupado;

    Boolean quebrado;


    public void depositar(Double quantia) {
        if (!quebrado && !quebrado) {
            this.poupado = quantia;
            System.out.println("Quantia depositada!");
        } else if (poupado == 0 ) {
            this.poupado += quantia;
            System.out.println("Quantia depositada!");
        } else {
            System.out.println("Cofrinho está quebrado");
        }
    }

    public void agitar(){
        Double valorRetirado = Math.random() * this.poupado;
        System.out.println("O valor " + valorRetirado + " foi retirado do cofre");
        this.poupado -= valorRetirado;
    }

    public void quebrar(){
        this.quebrado = true;
        System.out.println("Valor retirado foi: " + this.poupado);
        this.poupado = 0.0;
    }
}
