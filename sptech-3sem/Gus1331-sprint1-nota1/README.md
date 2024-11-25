# A boa e velha lógica, dessa vez com endpoints! 📎

## Orientações Gerais: 🚨
1. Sua nota será baseada na quantidade de testes que passarem.
2. Verifique se **não** há **erros de compilação** no projeto antes de enviar
3. Retorne apenas o que foi solicitado no enunciado do exercício.

<hr>

###  👶 Exercício 1

Dentro da classe `ExercicioFacilController`, faça o seguinte:

- Crie um endpoint GET que receba uma palavra como parte da URL.
- Verifique se a palavra recebida é um palíndromo, ou seja, se pode ser lida da mesma forma de trás para frente, ignorando diferenças entre maiúsculas e minúsculas.
- Retorne `true` se a palavra for um palíndromo e `false` caso contrário.

#### Cenários testados:

1. **Quando a palavra for um palíndromo (ex.: "ana"):**
   - **Endpoint:** `/ex-01/ana`
   - **Saída esperada:** `true`

2. **Quando a palavra não for um palíndromo (ex.: "carro"):**
   - **Endpoint:** `/ex-01/carro`
   - **Saída esperada:** `false`

3. **Quando a palavra for um palíndromo com diferentes casos de maiúsculas e minúsculas (ex.: "Ana"):**
   - **Endpoint:** `/ex-01/Ana`
   - **Saída esperada:** `true`

4. **Quando a palavra for "reviver":**
   - **Endpoint:** `/ex-01/reviver`
   - **Saída esperada:** `true`

<hr>

### ⚖️ Exercício 2

Dentro da classe `ExercicioMedioController`, faça o seguinte:

- Crie um endpoint GET que receba um número inteiro como parte da URL.
- Verifique se o número recebido é um número primo. Um número primo é um número natural maior que 1 que só pode ser dividido por 1 e por ele mesmo.
- Retorne `true` se o número for primo e `false` caso contrário.

#### Cenários testados:

1. **Quando o número for primo (ex.: 7):**
   - **Endpoint:** `/ex-02/7`
   - **Saída esperada:** `true`

2. **Quando o número não for primo (ex.: 10):**
   - **Endpoint:** `/ex-02/10`
   - **Saída esperada:** `false`

3. **Quando o número for menor ou igual a um (ex.: 1 ou -5):**
   - **Endpoint:** `/ex-02/1`
   - **Saída esperada:** `false`
   
   - **Endpoint:** `/ex-02/-5`
   - **Saída esperada:** `false`

<hr>

### 💪 Exercício 3 - Desafio Difícil

Dentro da classe `ExercicioDificilController`, faça o seguinte:

- Crie um endpoint GET que receba um número inteiro `n` como parte da URL.
- O endpoint deve calcular o enésimo termo da sequência de Fibonacci e a soma de todos os termos até esse enésimo termo.
- Se `n` for menor ou igual a 0, o endpoint deve retornar 0 tanto para o enésimo termo quanto para a soma.
- Retorne um objeto JSON com os campos `enesimoTermo` e `soma`.

#### Cenários testados:

1. **Quando `n` for um número positivo (ex.: 6 ou 7):**
   - **Endpoint:** `/ex-03/6`
   - **Saída esperada:**
     ```json
     {
       "enesimoTermo": 8,
       "soma": 20
     }
     ```
   
   - **Endpoint:** `/ex-03/7`
   - **Saída esperada:**
     ```json
     {
       "enesimoTermo": 13,
       "soma": 33
     }
     ```

2. **Quando `n` for 0:**
   - **Endpoint:** `/ex-03/0`
   - **Saída esperada:**
     ```json
     {
       "enesimoTermo": 0,
       "soma": 0
     }
     ```

3. **Quando `n` for 1:**
   - **Endpoint:** `/ex-03/1`
   - **Saída esperada:**
     ```json
     {
       "enesimoTermo": 1,
       "soma": 1
     }
     ```

4. **Quando `n` for 10:**
   - **Endpoint:** `/ex-03/10`
   - **Saída esperada:**
     ```json
     {
       "enesimoTermo": 55,
       "soma": 143
     }
     ```

5. **Quando `n` for um número negativo (ex.: -1):**
   - **Endpoint:** `/ex-03/-1`
   - **Saída esperada:**
     ```json
     {
       "enesimoTermo": 0,
       "soma": 0
     }
     ```

<hr>

