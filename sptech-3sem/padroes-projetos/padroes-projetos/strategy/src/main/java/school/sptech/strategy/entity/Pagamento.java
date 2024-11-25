package school.sptech.strategy.entity;

public class Pagamento {
  private String pagador;
  private String codigoBarra;
  private double valor;
  private TipoPagamentoEnum tipo;

  public TipoPagamentoEnum getTipo() {
    return tipo;
  }

  public void setTipo(TipoPagamentoEnum tipo) {
    this.tipo = tipo;
  }

  public String getPagador() {
    return pagador;
  }

  public void setPagador(String pagador) {
    this.pagador = pagador;
  }

  public String getCodigoBarra() {
    return codigoBarra;
  }

  public void setCodigoBarra(String codigoBarra) {
    this.codigoBarra = codigoBarra;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public double calcular() {
    return this.tipo.getEstrategia().pagar(this.valor);
  }
}
