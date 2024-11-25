
# Enunciado para Implementação da Entidade **Personagem** e Métodos Associados

### Contexto:
Em muitos jogos e sistemas de narrativa, os personagens são figuras centrais que possuem habilidades, funções e histórias próprias. No contexto deste exercício, cada personagem está vinculado a uma região, que pode ser uma localização geográfica fictícia ou baseada em um universo conhecido de um jogo. A relação entre personagens e suas regiões ajuda a definir o background, as motivações e o ambiente em que esses personagens atuam.

Por exemplo, no jogo Valorant, personagens como Jett e Phoenix vêm de diferentes partes do mundo, como Coreia do Sul e Reino Unido, respectivamente, e cada um deles carrega uma história e um estilo de combate associados à sua região de origem. Já em League of Legends, personagens como Yasuo ou Lee Sin estão associados a regiões fictícias, como Ionia, que representam culturas e poderes específicos.

Esse sistema de vinculação entre personagens e regiões não só enriquece a narrativa, mas também organiza a lógica do jogo, permitindo uma categorização clara de suas origens, habilidades e papéis.

### Atividade
Neste exercício, você irá finalizar a implementação de uma aplicação que gerencia **personagens** em um sistema de narrativa fictícia. Cada personagem está associado a uma **região**, e as classes relacionadas à entidade **Região** já estão completas. Agora, o foco é concluir a implementação da entidade **Personagem**, seus serviços, mapeadores e controladores.

### ⚠️ ANTES DE COMEÇAR ⚠️:
Saiba que as classes que você precisa atuar estão parcialmente implementadas, e você deve completar o código onde indicado.
Pesquise pelo termo `TODO` no código para encontrar os locais onde é necessário criar ou completar a implementação.

## ✅ Classes já implementadas (não precisa alterar) ✅

1. **Classe Regiao**: 
   - Atributos: `id`, `nome`, `sigla`, e `descricao`.
   
2. **RegiaoService**: 
   - Inclui métodos básicos como salvar, buscar e deletar regiões.
   
3. **RegiaoController**: 
   - Controlador responsável pelos endpoints de `Regiao`.

4. **RegiaoMapper**: 
   - Mapeador de entidades relacionado à classe **Regiao**.

5. **RegiaoCreateDto**:
    - DTO para criação de regiões.

6. **RegiaoResponseDto**:
    - DTO para resposta de regiões.

7. **RegiaoRepository**:
   - Repositório de dados para a entidade **Regiao**.

<hr>

## 🚀 Código que precisa ser completado (A jornada começa aqui) 🚀

### 1. **Classe Personagem**

A classe **Personagem** já foi parcialmente implementada. É necessário:

- Adicionar o relacionamento entre **Personagem** e **Região**, considerando que **são muitos personagens para uma única região.**

### 2. **PersonagemService**

Os seguintes métodos ainda precisam ser implementados:

- **Buscar por ID**: Implementar a busca de um personagem pelo seu identificador, caso não encontre, lançar uma exceção.
- **Cadastrar**: Completar o cadastro de personagens, utilizando a **RegiaoService** para buscar a região pelo seu ID e vincular ao personagem posteriormente.
- **Busca por Nome de Região Aproximado**: Implementar a busca por personagens com base no nome da região aproximado (texto parcial), sem diferenciação de maiúsculas e minúsculas.
- **Busca por Função Principal e Sigla da Região**: Implementar a busca por personagens que correspondam **exatamente** à função principal e (operador AND) à sigla da região.

### 3. **PersonagemMapper**

O mapeamento da classe **Personagem** ainda está incompleto. Você deve finalizar o processo de mapeamento dos atributos:

- No método que converte de **PersonagemCreateDto** para **Personagem**.
- No método que converte de **Personagem** para **PersonagemResponseDto**, mapeando os atributos de **Personagem** e também os de **Regiao**.

### 4. **PersonagemController**

### Endpoints

### GET /personagens
- **Objetivo**: Buscar todos os personagens cadastrados no sistema.

### POST /personagens
- **Objetivo**: Cadastrar um personagem e vinculá-lo a uma região existente.
- **Validações**:
   - `nome`: Não pode ser nulo, não pode conter espaços em branco e nem ser vazio.
   - `ultimate`: Não pode ser nulo, não pode conter espaços em branco e nem ser vazio.
   - `funcaoPrincipal`: Não pode ser nulo, não conter espaços em branco e nem ser vazio.
   - `regiaoId`: Deve ser um número positivo e não nulo.

### GET /personagens/{id}
- **Objetivo**: Buscar um personagem específico pelo seu ID.

### GET /personagens/filtro/regiao-nome
- **Objetivo**: Buscar personagens por região nome parcial, ignorando maiúsculas e minúsculas.

### GET /personagens/filtro/funcao-regiao
- **Objetivo**: Buscar personagens por função e região exatas.

## Requisitos

Complete cada parte do código onde indicado, utilizando a lógica necessária para conectar a entidade **Personagem** com **Região** e garantir o correto funcionamento dos métodos que ainda estão incompletos.

### Ficou com dúvidas sobre a ideia? Veja alguns exemplos: 

## Overwatch:
```json
{
    "id": 1,
    "nome": "Reinhardt",
    "ultimate": "Terremoto",
    "funcaoPrincipal": "Tanque",
        "regiao": {
        "id": 1,
        "nome": "Stuttgart",
        "descricao": "Cidade natal de Reinhardt na Alemanha",
        "sigla": "STG"
    }
}
```

````json
{
    "id": 2,
    "nome": "Mercy",
    "ultimate": "Valquíria",
    "funcaoPrincipal": "Suporte",
    "regiao": {
        "id": 2,
        "nome": "Zurique",
        "descricao": "Cidade natal de Mercy, na Suíça",
        "sigla": "ZUR"
    }
}
````

## League of legends:
```json
{
    "id": 1,
    "nome": "Lee Sin",
    "ultimate": "Dragão Ascendente",
    "funcaoPrincipal": "Lutador",
    "regiao": {
        "id": 1,
        "nome": "Ionia",
        "descricao": "A terra dos guerreiros espirituais e monges",
        "sigla": "ION"
    }
}
```

````json
{
    "id": 2,
    "nome": "Blitzcrank",
    "ultimate": "Campo Estático",
    "funcaoPrincipal": "Suporte",
    "regiao": {
        "id": 2,
        "nome": "Zaun",
        "descricao": "A cidade subterrânea de ciência e alquimia",
        "sigla": "ZAU"
    }
}
````

````json
{
    "id": 3,
    "nome": "Yasuo",
    "ultimate": "Último Suspiro",
    "funcaoPrincipal": "Feedar",
    "regiao": {
        "id": 1,
        "nome": "Ionia",
        "descricao": "A terra dos guerreiros espirituais e monges",
        "sigla": "ION"
    }
}
````

## Valorant:

```json
{
    "id": 1,
    "nome": "Jett",
    "ultimate": "Tormenta de Aço",
    "funcaoPrincipal": "Duelista",
    "regiao": {
        "id": 1,
        "nome": "Coreia do Sul",
        "descricao": "Ágil e mortal, vem da cidade de Seul",
        "sigla": "KOR"
    }
}
```

```json
{
    "id": 2,
    "nome": "Phoenix",
    "ultimate": "Renascimento",
    "funcaoPrincipal": "Duelista",
    "regiao": {
        "id": 2,
        "nome": "Reino Unido",
        "descricao": "Controla o fogo e vem de Londres",
        "sigla": "UK"
    }
}
```

```json
{
    "id": 3,
    "nome": "Sage",
    "ultimate": "Ressurreição",
    "funcaoPrincipal": "Sentinela",
    "regiao": {
        "id": 3,
        "nome": "China",
        "descricao": "A curandeira que protege sua equipe, de Xangai",
        "sigla": "CHN"
    }
}
```

