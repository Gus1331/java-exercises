package school.sptech.strategy.entity.strategy;

public class PagamentoCartao implements PagamentoStrategy {

  @Override
  public double pagar(double valor) {
    return valor + (valor * 0.1);
  }
}
