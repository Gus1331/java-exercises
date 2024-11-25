package school.sptech.strategy.entity.strategy;

public class PagamentoPix implements PagamentoStrategy {

  @Override
  public double pagar(double valor) {
    return valor - (valor * 0.2);
  }
}
