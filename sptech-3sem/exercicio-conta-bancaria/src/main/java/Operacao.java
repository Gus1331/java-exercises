public class Operacao {
    private ContaBancaria objConta;
    private String tipoOperacao;
    private Double valor;

    public Operacao(ContaBancaria objConta, String tipoOperacao, Double valor) {
        if(!tipoOperacao.equals("débito") && !tipoOperacao.equals("crédito")){
            System.out.println("Tipo operação inválido");
            System.out.println("Deve ser débito ou crédito");

            throw new IllegalArgumentException();
        }

        this.objConta = objConta;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Operacao{" +
                "objConta=" + objConta +
                ", tipoOperacao='" + tipoOperacao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
