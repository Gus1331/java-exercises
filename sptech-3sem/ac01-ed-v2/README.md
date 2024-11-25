# Avaliação Continuada 01 - Prática 📎

## 📌 Orientações Gerais:
1. Verifique se **não** há **erros de compilação** no projeto antes de enviar.
2. Respeite os nomes de atributos e métodos definidos no exercício.
3. Tome cuidado com os argumentos especificados no exercício. Não adicione argumentos não solicitados e mantenha a ordem definida no enunciado.
4. O projeto possui testes automatizados para ajuda-los a acompanhar a resolucão, para rodar os testes, clique com botão direito no nome do projeto, e em "Run All Tests".

## 🚨 Orientações para a avaliação:
- Não é necessário utilizar Pesquisa Binária
- Não é necessário criar métodos novos
- Já deixamos a assinatura dos métodos pronta, ou seja, basta preencher o corpo dos métodos 🙂
- Usar a classe Teste (método main) é opcional, mas pode te ajudar a entender possíveis erros

   ## 🏥 Gestão de Pacientes

Você recebeu a classe `GestaoPacientes` que contém métodos para gerenciar um array de objetos `Paciente`. Sua tarefa é completar os métodos da classe conforme descrito abaixo. 
Caso ache necessário, teste cada método utilizando a classe `GestaoPacientes` no seu código principal (`main`).

### Métodos a serem completados na classe `GestaoPacientes`:

1. **alterarValorConsulta(Paciente[] pacientes, Integer id, Double valorNovo):**
    - Este método deve alterar o valor da consulta de um `Paciente` com o `id` fornecido.
    - Se o `id` for encontrado, o método deve atualizar o valor e retornar `true`. Caso contrário, deve retornar `false`.

2. **somaValorConsulta(Paciente[] pacientes):**
    - Este método deve calcular e retornar a soma dos valores de todas as consultas dos pacientes no vetor.

3. **trocaPacientes(Paciente[] pacientes, Integer idPaciente01, Integer idPaciente02):**
    - Este método deve trocar a posição dos pacientes no vetor baseando-se nos IDs fornecidos (`idPaciente01` e `idPaciente02`).

4. **ordenarPorIdade(Paciente[] pacientes):**
    - Corrija o algoritmo de ordenação para que ordene corretamente os pacientes pela idade em ordem crescente.

5. **ordenarPorIdadeDecrescente(Paciente[] pacientes) :**
    - O método está fazendo a ordenação crescente, **corrija** para que a ordenação dos pacientes seja feita pela idade em ordem **decrescente**.

6. **ordenarPorNomePaciente(Paciente[] pacientes) :**
    - Complete a lógica deste método para ordenar o vetor de pacientes em ordem alfabética crescente pelo nome do paciente.
    - Necessário completar apenas dentro do `if`, foi adicionado um comentário indicando onde deve ser completado.  

### Dica:
- Para testar os métodos, você pode utilizar o método `exibePacientes(Paciente[] pacientes)` já fornecido, que exibe os detalhes dos pacientes no console.

Boa prova!
