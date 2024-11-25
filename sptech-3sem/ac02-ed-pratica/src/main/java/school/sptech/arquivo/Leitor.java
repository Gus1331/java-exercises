package school.sptech.arquivo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Leitor {
    public static List<Produto> lerProdutos() {

        List<Produto> novosProdutos = new ArrayList<>();

        try (
                InputStream inputStream = new FileInputStream("novos-produtos.csv");
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(inputStream)
                );
                Scanner leitor = new Scanner(bufferedReader);
        ) {
            leitor.useLocale(Locale.forLanguageTag("pt-BR"));
            leitor.useDelimiter("[;\\n]");
            leitor.nextLine();

            while (leitor.hasNextLine()) {
                // [COMPLETAR CÓDIGO ABAIXO]
                            /*
            *
    private Integer id;
    private String nome;
    private String categoria;
    private Integer pontuacao;
    private Double preco;
    private Integer quantidadeEstoque; */
                // Altere as linhas abaixo para preencher as variáveis com as informações lidas do arquivo:
                Integer idLido = leitor.nextInt();
                String nomeLido = leitor.next();
                String categoriaLida = leitor.next();
                Integer pontuacaoLida = leitor.nextInt();
                Double precoLido = leitor.nextDouble();
                Integer quantidadeEstoqueLido = leitor.nextInt();


                // [COMPLETAR CÓDIGO ABAIXO]
                // Na linha abaixo desse comentário, crie um objeto de Produto com as informações lidas
                // adicione o produto criado na lista chamdada novosProdutos (criada na linha 11 dessa classe)
                novosProdutos.add(new Produto(
                        idLido,
                        nomeLido,
                        categoriaLida,
                        pontuacaoLida,
                        precoLido,
                        quantidadeEstoqueLido));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo!");
        }

        return novosProdutos;
    }

    public static void main(String[] args) {
        //Rode esse main caso queira testar a leitura do arquivo além dos testes automatizados:
        List<Produto> produtosLidos = lerProdutos();

        System.out.println("Exibindo lista de produtos lidos:");
        for (int i = 0; i < produtosLidos.size(); i++) {
            System.out.println(produtosLidos.get(i));
        }
    }
}
