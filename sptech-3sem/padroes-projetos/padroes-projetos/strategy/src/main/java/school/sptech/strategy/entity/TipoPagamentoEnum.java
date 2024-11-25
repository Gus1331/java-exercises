package school.sptech.strategy.entity;

import school.sptech.strategy.entity.strategy.PagamentoBoleto;
import school.sptech.strategy.entity.strategy.PagamentoCartao;
import school.sptech.strategy.entity.strategy.PagamentoPix;
import school.sptech.strategy.entity.strategy.PagamentoStrategy;

public enum TipoPagamentoEnum {

  CARTAO(new PagamentoCartao()),
  BOLETO(new PagamentoBoleto()),
  PIX(new PagamentoPix());

  private PagamentoStrategy estrategia;

  TipoPagamentoEnum(PagamentoStrategy estrategia) {
    this.estrategia = estrategia;
  }

  public PagamentoStrategy getEstrategia() {
    return estrategia;
  }
}
