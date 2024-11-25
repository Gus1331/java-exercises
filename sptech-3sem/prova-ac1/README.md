# Objetivo: Desenvolver uma aplicação CRUD simples para gerenciar usuários.

## ⚠️ Atenção alunos:

Antes de começar a escrever seu código, leia o enunciado completamente pelo menos uma vez! Isso é essencial para
garantir que você entenda todos os requisitos do projeto;

<span style="color: red; font-weight: bold;">Não utilize bibliotecas ou outras dependências externas, como por exemplo, LOMBOK. Faça somente o
necessário para resolver o enunciado.</span>

Ao final da prova, suba um arquivo **zip.** Utilize o gerenciador/explorador de arquivos do seu sistema operacional para compactar a pasta inteira do projeto.

**Não utilize o IntelliJ para isso, pois ele pode adicionar arquivos indesejados ao zip.**

## Instruções:

Você deverá criar um sistema de gerenciamento de usuários com os seguintes endpoints:

### 1. Cadastro de usuário

Objetivo: Adicionar um novo usuário.

- Método HTTP: POST
- URL Completa: http://localhost:8080/usuarios
- Validações:
    - O e-mail e/ou cpf não deve existir na base para o cadastro.
    - caso algum dos dois existam, retorne o código adequado.
- Descrição: Cadastro de um novo usuário, retorne o usuário recém cadastrado com ID gerado.

Parâmetros: Recebe um objeto Usuario, exemplo:

```json
{
  "nome": "POST Malone",
  "email": "post@malone.com",
  "cpf": "51071857037",
  "senha": "post123",
  "dataNascimento": "1995-07-04"
}
```

Forneça uma resposta (código http) adequada para cada situação.

<hr>

### 2. Listagem de todos os usuários

Objetivo: Retornar uma lista com todos os usuários cadastrados.

- Método HTTP: GET
- URL Completa: http://localhost:8080/usuarios
- Descrição: Retorna todos os usuários cadastrados.

Exemplo de resposta:

```json
[
  {
    "id": 1,
    "nome": "GET Malone",
    "cpf": "52071857037",
    "email": "get@malone.com",
    "senha": "post123",
    "dataNascimento": "1995-07-04"
  }
]
```

Forneça uma resposta (código http) adequada para cada situação.
<hr>

### 3. Buscar usuário por ID

- Método HTTP: GET
- URL Completa: http://localhost:8080/usuarios/1
- Descrição: Consulta de um usuário específico pelo seu ID.

Forneça uma resposta (código http) adequada para cada situação.
<hr>

### 4. Exclusão de usuário por ID

- Método HTTP: DELETE
- URL Completa: http://localhost:8080/usuarios/1
- Descrição: Remove um usuário pelo seu ID, sem necessidade de retornar o objeto removido.

Fornecer uma resposta (código http) adequada para cada situação.

<hr>

### 5. Busca Data de Nascimento maior que

- Método HTTP: GET
- URL Completa: http://localhost:8080/usuarios/filtro-data
- Parâmetros: Recebe uma data no formato yyyy-MM-dd
- Descrição: Retorna uma lista com todos os usuários que possuem data de nascimento maior que a data informada.

Fornecer uma resposta (código http) adequada para cada situação.

<hr>

### Especificações do Modelo:

O usuário deve possuir os seguintes campos:

- id: Integer
- email: String
- nome: String
- cpf: String
- senha: String
- dataNascimento: LocalDate

### Utilize classes Wrapper!

<hr>

### Dicas:

- __Respostas e Verbos:__
    - Ao criar seus endpoints, tenha em mente os códigos de resposta HTTP adequados para cada situação. Lembre-se que
      esses códigos indicam o resultado da operação realizada.
    - Adicionalmente, assegure-se de que os verbos HTTP, como "GET", "POST", "PUT" e "DELETE", estejam sendo usados
      corretamente.
    - Em caso de falha, apenas o código de status é necessário na resposta, sem a necessidade de mensagens detalhadas ou
      lançamento de exceções.

__Observação: Ao copiar o JSON fornecido, é possível que caracteres invisíveis ou especiais sejam incluídos
acidentalmente, o que pode causar problemas. Se encontrar alguma dificuldade, recomendamos que você digite o JSON
diretamente no Insomnia.__

<hr>

# Ao final da prova, suba o projeto inteiro __.zip__

# Arquivos com extensões diferentes de .zip não serão aceitos.

# A qualidade do arquivo .zip é de responsabilidade do aluno. (Arquivos corrompidos não serão aceitos)

### Sobre testes automatizados:

- Os testes são disponibilizados para auxiliar o desenvolvimento, **e serão utilizados para avaliar a implementação.**
- Passar nos testes automatizados não garante que a implementação está correta, mas sim que atende os casos de uso
  propostos.
- Caso os testes se mostrem mais um obstáculo do que um auxílio, você tem a opção de não os utilizar. Contudo, vale
  ressaltar que a finalidade dos testes é assegurar a correção da lógica por trás do seu código.
- Se você identificar qualquer inconveniente nos testes, não hesite em comunicá-lo ao término do exame enviando um
  e-mail ao professor encarregado. Diante dessa situação, adote a abordagem que considerar mais adequada para a questão.

<br>

# Boa sorte! 📓✏️😊