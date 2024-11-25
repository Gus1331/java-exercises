<h1>Entidade: Ativo</h1>

<p>A classe <strong>Ativo</strong> representa os ativos de investimento que estão vinculados a uma carteira específica. Ela contém informações essenciais sobre o ativo e seu relacionamento com a carteira à qual pertence. Abaixo estão descritos os atributos, o relacionamento com outras entidades, e os recursos da biblioteca <strong>Lombok</strong> que devem ser utilizados.</p>

<h2>Atributos</h2>

<ul>
  <li><strong>id</strong>: Um identificador único para cada ativo. Esse campo deve ser gerado automaticamente ao criar um novo ativo.</li>
  <li><strong>nome</strong>: O nome do ativo. Este campo armazena a identificação do ativo, como "Ação XPTO" ou "Tesouro Direto".</li>
  <li><strong>tipo</strong>: O tipo do ativo. Este campo define a categoria do ativo, como "Ação", "Fundo Imobiliário", "Tesouro Direto", etc.</li>
  <li><strong>valorAtual</strong>: O valor atual do ativo. Este campo armazena o valor de mercado atual do ativo, e deve ser um número positivo.</li>
  <li><strong>carteira</strong>: O relacionamento entre o ativo e a carteira à qual ele pertence. Cada ativo deve estar associado a uma única carteira de investimentos.</li>
</ul>

<h2>Relacionamento</h2>

<ul>
  <li><strong>Carteira</strong>: A entidade <strong>Ativo</strong> está vinculada a uma única entidade <strong>Carteira</strong>. Esse relacionamento é necessário para indicar a qual carteira o ativo pertence. No banco de dados, o relacionamento será representado por uma chave estrangeira que aponta para o ID da carteira.</li>
  <li><strong>Vários ativos para uma carteira</strong>
</ul>

<h2>Lombok</h2>

<p>A classe <strong>Ativo</strong> utiliza a biblioteca <strong>Lombok</strong> para reduzir a quantidade de código boilerplate, como getters, setters, construtores e métodos de construção de objetos. Os seguintes recursos do Lombok devem ser utilizados:</p>

<ul>
  <li><strong>@Getter</strong>: Gera automaticamente os métodos <code>get</code> para todos os atributos da classe.</li>
  <li><strong>@Setter</strong>: Gera automaticamente os métodos <code>set</code> para todos os atributos da classe.</li>
  <li><strong>@Builder</strong>: Permite a construção de objetos utilizando o padrão Builder, que facilita a criação de instâncias de <strong>Ativo</strong> de forma fluente.</li>
  <li><strong>@NoArgsConstructor</strong>: Gera um construtor sem parâmetros. Necessário para instanciar a classe sem passar valores diretamente.</li>
  <li><strong>@AllArgsConstructor</strong>: Gera um construtor com parâmetros para todos os atributos da classe. Facilita a criação de instâncias passando todos os valores de uma vez.</li>
</ul>

<h2>Exemplo de Instância de Ativo</h2>
<pre><code>Ativo ativo = Ativo.builder()
    .nome("Ação XPTO")
    .tipo("Ação")
    .valorAtual(150.75)
    .carteira(carteira)
    .build();
</code></pre>

<hr>

<h1>Service</h1>

<p>Agora, você precisa implementar os métodos da classe <strong>AtivoService</strong>, que será responsável por manipular os dados da entidade <strong>Ativo</strong> e fazer a comunicação entre o repositório e o controlador. Abaixo estão as assinaturas dos métodos e suas descrições.</p>

<h2>Assinaturas e o que deve ser implementado</h2>

<h3>1. <code>Ativo salvar(Ativo ativo, int carteiraId)</code></h3>
<ul>
  <li><strong>Objetivo:</strong> Este método é responsável por salvar um ativo no banco de dados, vinculando-o a uma carteira existente com base no ID da carteira.</li>
  <li><strong>Parâmetros:</strong> 
    <ul>
      <li><code>ativo</code>: Um objeto da entidade <code>Ativo</code> contendo os dados que serão persistidos.</li>
      <li><code>carteiraId</code>: O ID da carteira à qual o ativo será vinculado.</li>
    </ul>
  </li>
  <li><strong>Retorno:</strong> O método deve retornar o objeto <code>Ativo</code> salvo no banco de dados.</li>
  <li><strong>Comportamento:</strong> 
    <ul>
      <li>Buscar a carteira pelo <code>carteiraId</code> usando o serviço de carteira.</li>
      <li>Associar a carteira encontrada ao objeto <code>Ativo</code>.</li>
      <li>Salvar o ativo usando o repositório.</li>
    </ul>
  </li>
</ul>

<h3>2. <code>List&lt;Ativo&gt; buscarTodos()</code></h3>
<ul>
  <li><strong>Objetivo:</strong> Este método é responsável por buscar e retornar todos os ativos cadastrados no sistema.</li>
  <li><strong>Parâmetros:</strong> Nenhum.</li>
  <li><strong>Retorno:</strong> Uma lista de objetos do tipo <code>Ativo</code>.</li>
  <li><strong>Comportamento:</strong> 
    <ul>
      <li>Buscar todos os ativos no banco de dados usando o repositório.</li>
    </ul>
  </li>
</ul>

<h3>3. <code>Ativo buscarPorId(int id)</code></h3>
<ul>
  <li><strong>Objetivo:</strong> Este método busca um ativo específico pelo seu ID.</li>
  <li><strong>Parâmetros:</strong> 
    <ul>
      <li><code>id</code>: O ID do ativo a ser buscado.</li>
    </ul>
  </li>
  <li><strong>Retorno:</strong> O objeto <code>Ativo</code> correspondente ao ID fornecido.</li>
  <li><strong>Comportamento:</strong> 
    <ul>
      <li>Buscar o ativo pelo ID usando o repositório.</li>
      <li>Se o ativo não for encontrado, lançar uma exceção <code>NaoEncontradoException</code> com uma mensagem apropriada.</li>
    </ul>
  </li>
</ul>

<h3>4. <code>void deletarPorId(int id)</code></h3>
<ul>
  <li><strong>Objetivo:</strong> Este método deleta um ativo do banco de dados com base no ID fornecido.</li>
  <li><strong>Parâmetros:</strong> 
    <ul>
      <li><code>id</code>: O ID do ativo que será deletado.</li>
    </ul>
  </li>
  <li><strong>Retorno:</strong> Nenhum (método <code>void</code>).</li>
  <li><strong>Comportamento:</strong> 
    <ul>
      <li>Verificar se o ativo existe no banco de dados usando o método <code>existsById</code> do repositório.</li>
      <li>Se o ativo não existir, lançar uma exceção <code>NaoEncontradoException</code> com uma mensagem apropriada.</li>
      <li>Deletar o ativo usando o repositório.</li>
    </ul>
  </li>
</ul>

<h3>5. <code>List&lt;Ativo&gt; buscarAtivosPorInvestidorNome(String nome)</code></h3>
<ul>
  <li><strong>Objetivo:</strong> Buscar todos os ativos vinculados ao nome de um investidor, ignorando maiúsculas e minúsculas.</li>
  <li><strong>Parâmetros:</strong> 
    <ul>
      <li><code>nome</code>: O nome do investidor para o qual os ativos serão buscados.</li>
    </ul>
  </li>
  <li><strong>Retorno:</strong> Uma lista de objetos <code>Ativo</code> vinculados ao investidor.</li>
  <li><strong>Comportamento:</strong> 
    <ul>
      <li>Buscar os ativos usando o método do repositório que ignora maiúsculas e minúsculas para o nome do investidor.</li>
    </ul>
  </li>
</ul>

<h3>6. <code>Double buscarMediaAtivosPorInvestidorNome(String nome)</code></h3>
<ul>
  <li><strong>Objetivo:</strong> Calcular e retornar a média dos valores dos ativos vinculados ao nome exato de um investidor.</li>
  <li><strong>Parâmetros:</strong> 
    <ul>
      <li><code>nome</code>: O nome exato do investidor para o qual a média dos ativos será calculada.</li>
    </ul>
  </li>
  <li><strong>Retorno:</strong> O valor médio dos ativos do investidor.</li>
  <li><strong>Comportamento:</strong> 
    <ul>
      <li>Buscar a média dos ativos pelo nome exato do investidor, considerando as letras maiúsculas e minúsculas, ou seja, deve ser igual.</li>
      <li>Se a carteira não for encontrada, lançar uma exceção <code>NaoEncontradoException</code> com uma mensagem apropriada.</li>
      <li>A média deve ser calculada diretamente no banco de dados usando JPQL para garantir eficiência e performance.</li>
    </ul>
  </li>
<li>
    Dica: Utilizar função "AVG" do banco junto com o @Query e o retorno "Double" wrapper
</li>
</ul>

<hr>

<h1>Mapper</h1>

<h2>Assinaturas e o que deve ser implementado</h2>

<h3>1. <code>toAtivoResponseDto(Ativo ativo)</code></h3>
<ul>
  <li><strong>Objetivo:</strong> Converter uma entidade <code>Ativo</code> em um <code>AtivoResponseDto</code>.</li>
  <li><strong>Parâmetro:</strong> <code>ativo</code>: um objeto da entidade <code>Ativo</code> contendo os dados do ativo e da carteira vinculada.</li>
  <li><strong>Retorno:</strong> Um objeto do tipo <code>AtivoResponseDto</code>, contendo as informações formatadas da entidade <code>Ativo</code> e sua respectiva <code>Carteira</code>.</li>
  <li><strong>Validações:</strong> O método deve garantir que, se o objeto <code>Ativo</code> for nulo, o método retorne <code>null</code>. A resposta deve estar corretamente estruturada com os dados da carteira, que será mapeada para a classe aninhada <code>AtivoCarteiraResponseDto</code>.</li>
</ul>

<p>Exemplo de assinatura:</p>
<pre><code>public static AtivoResponseDto toAtivoResponseDto(Ativo ativo) {
    // Implementar lógica para converter Ativo em AtivoResponseDto
}
</code></pre>

<h4>Exemplo de <code>AtivoResponseDto</code>:</h4>
<pre><code>{
  "id": 1,
  "nome": "Ação XPTO",
  "tipo": "Ação",
  "valorAtual": 150.75,
  "carteira": {
    "id": 1,
    "nome": "Carteira de Investimentos A",
    "investidor": "João Silva"
  }
}</code></pre>

<hr>

<h3>2. <code>toAtivoEntity(AtivoRequestDto ativoRequestDto)</code></h3>
<ul>
  <li><strong>Objetivo:</strong> Converter um DTO <code>AtivoRequestDto</code> em uma entidade <code>Ativo</code>.</li>
  <li><strong>Parâmetro:</strong> <code>ativoRequestDto</code>: um objeto do tipo <code>AtivoRequestDto</code> contendo os dados que serão inseridos na entidade <code>Ativo</code>.</li>
  <li><strong>Retorno:</strong> Um objeto da entidade <code>Ativo</code>, contendo os dados do ativo prontos para serem persistidos no banco de dados.</li>
  <li><strong>Validações:</strong> O método deve garantir que, se o DTO for nulo, o método retorne <code>null</code>. Deve também converter corretamente os atributos do DTO para a entidade <code>Ativo</code>, exceto o ID da carteira, que será tratado no serviço.</li>
</ul>

<p>Exemplo de assinatura:</p>
<pre><code>public static Ativo toAtivoEntity(AtivoRequestDto ativoRequestDto) {
    // Implementar lógica para converter AtivoRequestDto em Ativo
}
</code></pre>

<h4>Exemplo de <code>AtivoRequestDto</code>:</h4>
<pre><code>{
  "nome": "Ação XPTO",
  "tipo": "Ação",
  "valorAtual": 150.75,
  "carteiraId": 1
}</code></pre>

<h4>Validações</h4>
<ul>
  <li><strong>nome</strong>: Não pode ser nulo, não pode conter apenas aspas vazias, e não pode ser uma string em branco (ex: " ").</li>
  <li><strong>tipo</strong>: Não pode ser nulo, não pode conter apenas aspas vazias, e não pode ser uma string em branco (ex: " ").</li>
  <li><strong>valorAtual</strong>: Deve ser um número positivo e não pode ser nulo.</li>
  <li><strong>carteiraId</strong>: Deve ser um número positivo, não pode ser nulo, e deve corresponder a uma carteira existente no banco de dados.</li>
</ul>

<hr>

<h1>Controller</h1>

<p>Você precisa implementar os seguintes endpoints na classe <strong>AtivoController</strong>:</p>

<h3>1. POST /ativos</h3>
<p>Este endpoint tem como objetivo cadastrar um ativo e vinculá-lo a uma carteira existente.</p>

<p><strong>Use o DTO</strong> <code>AtivoRequestDto</code> para receber os dados da requisição.</p>

<h4>Exemplo de Requisição</h4>
<pre><code>{
  "nome": "Ação XPTO",
  "tipo": "Ação",
  "valorAtual": 100.0,
  "carteiraId": 1
}</code></pre>

<h4>Exemplo de Resposta (Status 201 - Created)</h4>
<pre><code>{
  "id": 1,
  "nome": "Ação XPTO",
  "tipo": "Ação",
  "valorAtual": 100.0,
  "carteira": {
    "id": 1,
    "nome": "Carteira de Investimentos A",
    "investidor": "João Silva"
  }
}</code></pre>

<hr>

<h3>2. GET /ativos</h3>
<p>Este endpoint tem como objetivo buscar todos os ativos cadastrados no sistema.</p>

<h4>Requisitos</h4>
<ul>
  <li>Retornar uma lista de todos os ativos cadastrados.</li>
  <li>Se não houver ativos cadastrados, retornar <strong>Status 204 (No Content)</strong>.</li>
</ul>

<p><strong>Use o DTO</strong> <code>AtivoResponseDto</code> para formatar os dados de resposta.</p>

<h4>Exemplo de Resposta (Status 200 - OK)</h4>
<pre><code>[
  {
    "id": 1,
    "nome": "Ação XPTO",
    "tipo": "Ação",
    "valorAtual": 100.0,
    "carteira": {
      "id": 1,
      "nome": "Carteira de Investimentos A",
      "investidor": "João Silva"
    }
  },
  {
    "id": 2,
    "nome": "Fundo Imobiliário ABC",
    "tipo": "Fundo Imobiliário",
    "valorAtual": 200.5,
    "carteira": {
      "id": 1,
      "nome": "Carteira de Investimentos A",
      "investidor": "João Silva"
    }
  }
]</code></pre>

<hr>

<h3>3. GET /ativos/{id}</h3>
<p>Este endpoint tem como objetivo buscar um ativo específico com base no ID fornecido.</p>

<h4>Requisitos</h4>
<ul>
  <li>Buscar um ativo específico pelo seu ID.</li>
  <li>Se o ativo não for encontrado, retornar <strong>Status 404 (Not Found)</strong>.</li>
</ul>

<p><strong>Use o DTO</strong> <code>AtivoResponseDto</code> para formatar os dados de resposta.</p>

<h4>Exemplo de Resposta (Status 200 - OK)</h4>
<pre><code>{
  "id": 1,
  "nome": "Ação XPTO",
  "tipo": "Ação",
  "valorAtual": 100.0,
  "carteira": {
    "id": 1,
    "nome": "Carteira de Investimentos A",
    "investidor": "João Silva"
  }
}</code></pre>

<hr>

<h3>4. DELETE /ativos/{id}</h3>
<p>Este endpoint tem como objetivo deletar um ativo com base no ID fornecido.</p>

<h4>Requisitos</h4>
<ul>
  <li>Deletar o ativo correspondente ao ID fornecido.</li>
  <li>Se o ativo não for encontrado, retornar <strong>Status 404 (Not Found)</strong>.</li>
</ul>

<h4>Exemplo de Resposta (Status 204 - No Content)</h4>
<pre><code>// Sem conteúdo</code></pre>

<hr>

<h3>5. GET /ativos/carteiras</h3>
<p>Este endpoint tem como objetivo buscar ativos associados a um investidor cujo nome contenha o valor fornecido.</p>

<h4>Requisitos</h4>
<ul>
  <li>Buscar ativos associados ao nome do investidor fornecido (nome parcial, ignorar maiúsculas e minúsculas).</li>
  <li>Se não houver ativos relacionados ao investidor, retornar <strong>Status 204 (No Content)</strong>.</li>
</ul>

<p><strong>Use o DTO</strong> <code>AtivoResponseDto</code> para formatar os dados de resposta.</p>

<h4>Exemplo de Requisição</h4>
<pre><code>GET /ativos/carteiras?nomeInvestidor=João Silva</code></pre>

<h4>Exemplo de Resposta (Status 200 - OK)</h4>
<pre><code>[
  {
    "id": 1,
    "nome": "Ação XPTO",
    "tipo": "Ação",
    "valorAtual": 100.0,
    "carteira": {
      "id": 1,
      "nome": "Carteira de Investimentos A",
      "investidor": "João Silva"
    }
  }
]</code></pre>

<hr>

<h3>6. GET /ativos/carteiras/media</h3>
<p>Este endpoint tem como objetivo calcular e retornar a média dos valores dos ativos de um investidor cujo nome seja fornecido de forma exata.</p>

<h4>Requisitos</h4>
<ul>
  <li>Calcular a média dos valores dos ativos vinculados ao nome exato do investidor (case-sensitive).</li>
  <li>Se o investidor não possuir ativos ou não for encontrado, retornar <strong>Status 404 (Not Found)</strong>.</li>
</ul>

<h4>Exemplo de Requisição</h4>
<pre><code>GET /ativos/carteiras/media?nomeInvestidor=João Silva</code></pre>

<h4>Exemplo de Resposta (Status 200 - OK)</h4>
<pre><code>150.25</code></pre>
