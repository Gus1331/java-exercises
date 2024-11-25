package school.sptech.strategy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.strategy.entity.Pagamento;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    /*
        O Strategy é um padrão de projeto comportamental que permite que você defina uma família de algoritmos,
        coloque-os em classes separadas, e faça os objetos deles intercambiáveis.

        Referência:
        https://refactoring.guru/pt-br/design-patterns/strategy
    */

  /*

  {
  "tipo": "CARTAO"
   */

  @PostMapping("/valor")
  public String gerarPagamento(@RequestBody Pagamento pagamento) {
    return String.format("PAGAMENTO VIA: %s - Valor final: R$%s", pagamento.getTipo(), pagamento.calcular());
  }
}
