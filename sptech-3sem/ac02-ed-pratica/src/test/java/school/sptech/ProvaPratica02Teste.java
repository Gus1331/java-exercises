package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.sptech.arquivo.Escritor;
import school.sptech.arquivo.Leitor;
import school.sptech.arquivo.Produto;
import school.sptech.lista.estatica.ListaEstatica;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes Prova Prática 02")
public class ProvaPratica02Teste {


    //Adiciona:
    @Test
    @DisplayName("Método adicionaNoMeio - Deve adicionar o elemento no meio da lista")
    public void adicionaNoMeio_adiciona() {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);

        lista.adicionaNoMeio(25);

        assertEquals(25, lista.getVetor()[2]);
        assertEquals(30, lista.getVetor()[3]);
        assertEquals(40, lista.getVetor()[4]);
    }
    @Test
    @DisplayName("Método adicionaNoMeio - O número de elementos deve ser atualizado")
    public void adicionaNoMeio_numElementos() {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);

        lista.adicionaNoMeio(42);

        assertEquals(5, lista.getNroElem());
    }
    @Test
    @DisplayName("Método adicionaNoMeio - Os elementos seguintes devem ser reposicionados")
    public void adicionaNoMeio_reposicionaElementos() {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);

        lista.adicionaNoMeio(42);

        assertEquals(30, lista.getVetor()[3]);
        assertEquals(40, lista.getVetor()[4]);
    }
    @Test
    @DisplayName("Método adicionaNoMeio - Deve lançar IllegalStateException quando a lista estiver cheia")
    public void adicionaNoMeio_listaCheia() {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);
        lista.adiciona(50);

        // Verificar se lança exceção quando a lista estiver cheia
        assertThrows(IllegalStateException.class, () -> lista.adicionaNoMeio(25));
    }

    //Remove:
    @Test
    @DisplayName("Método removeImpares - Devolve a quantidade correta removida")
    public void removeImpares_retornaQuantidade() {

        ListaEstatica lista  = new ListaEstatica(10);
        for (int i = 1; i <= 10; i++) {
            lista.adiciona(i);
        }

        int removidos = lista.removeImpares();

        assertEquals(5, removidos);

        int[] esperado = {2, 4, 6, 8, 10};
        for (int i = 0; i < lista.getNroElem(); i++) {
            assertEquals(esperado[i], lista.getVetor()[i]);
        }
    }
    @Test
    @DisplayName("Método removeImpares - Deve remover todos os números ímpares da lista")
    public void removeImpares_remove() {
        ListaEstatica lista = new ListaEstatica(10);
        for (int i = 1; i <= 10; i++) {
            lista.adiciona(i);
        }

        int removidos = lista.removeImpares();

        // Verificar quantos números ímpares foram removidos
        assertEquals(5, removidos);

        // Verificar o estado da lista após a remoção
        int[] esperado = {2, 4, 6, 8, 10};
        for (int i = 0; i < lista.getNroElem(); i++) {
            assertEquals(esperado[i], lista.getVetor()[i]);
        }
    }
    @Test
    @DisplayName("Método removeImpares - Deve remover quando houver dois ímpares seguidos")
    public void removeImpares_removeSeguidos() {
        ListaEstatica lista = new ListaEstatica(10);
        lista.adiciona(11);
        lista.adiciona(13);
        lista.adiciona(20);
        lista.adiciona(22);

        int removidos = lista.removeImpares();

        assertEquals(2, removidos);

        int[] esperado = {20, 22};
        for (int i = 0; i < lista.getNroElem(); i++) {
            assertEquals(esperado[i], lista.getVetor()[i]);
        }
    }
    @Test
    @DisplayName("Método removeImpares - Devolve 0 se não houver ímpares para remover")
    public void removeImpares_semImpares() {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(2);
        lista.adiciona(4);
        lista.adiciona(6);
        lista.adiciona(8);
        lista.adiciona(10);

        int removidos = lista.removeImpares();

        assertEquals(0, removidos);
    }

    //Escrever:
    @Test
    @DisplayName("Classe Escritor - Cria arquivo produtos.csv")
    public void escritor_criaArquivo() {
        File arquivo = new File("produtos.csv");
        if (arquivo.exists()) {
            arquivo.delete();
        }
        assertFalse(arquivo.exists());
        Escritor.escreverArquivo();
        assertTrue(arquivo.exists());
    }
    @Test
    @DisplayName("Classe Escritor - Cria cabeçalho corretamente")
    public void escritor_Cabecalho() {
        Escritor.escreverArquivo();

        File arquivo = new File("produtos.csv");
        assertTrue(arquivo.exists());

        try {
            List<String> linhas = Files.readAllLines(Paths.get("produtos.csv"), StandardCharsets.UTF_8);

            String cabecalhoEsperado = "id;nome;categoria;pontuacao;preco;qtdEstoque";
            assertEquals(cabecalhoEsperado, linhas.get(0), "O cabeçalho do arquivo está incorreto.");
        } catch (IOException e) {
            fail("Erro ao ler o arquivo produtos.csv.");
        }
    }
    @Test
    @DisplayName("Classe Escritor - Cria corpo (dados) corretamente")
    public void escritor_Corpo() {
        Escritor.escreverArquivo();

        File arquivo = new File("produtos.csv");
        assertTrue(arquivo.exists());

        try {
            List<String> linhas = Files.readAllLines(Paths.get("produtos.csv"), StandardCharsets.UTF_8);

            String[] produtosEsperados = {
                    "100;Potes;Cozinha;5;10.65;67",
                    "101;Sabão em Pó;Limpeza;2;9.99;8",
                    "102;Mouse;Eletronicos;5;80.50;10",
                    "103;Teclado;Eletronicos;1;150.93;5",
                    "104;Pão Francês;Padaria;3;5.33;23",
                    "105;Brigadeiro;Padaria;4;4.10;130"
            };

            for (int i = 0; i < produtosEsperados.length; i++) {
                String esperadoComPonto = produtosEsperados[i];
                String esperadoComVirgula = produtosEsperados[i].replace(".", ",");

                String linhaGerada = linhas.get(i + 1);
                assertTrue(linhaGerada.equals(esperadoComPonto) || linhaGerada.equals(esperadoComVirgula));
            }

        } catch (IOException e) {
            fail("Erro ao ler o arquivo produtos.csv.");
        }
    }

    //Ler:
    @Test
    @DisplayName("Classe Leitor - Retorna lista com produtos lidos do arquivo novos-produtos.csv")
    public void testLerProdutos() {
        List<Produto> produtos = Leitor.lerProdutos();

        assertNotNull(produtos, "A lista de produtos não deve ser nula.");
        assertFalse(produtos.isEmpty(), "A lista de produtos não deve estar vazia.");

        assertEquals(3, produtos.size(), "O número de produtos lidos do arquivo está incorreto.");

        Produto produto1 = produtos.get(0);
        assertEquals(106, produto1.getId(), "O ID do primeiro produto está incorreto.");
        assertEquals("Cabo USB", produto1.getNome(), "O nome do primeiro produto está incorreto.");
        assertEquals("Eletronicos", produto1.getCategoria(), "A categoria do primeiro produto está incorreta.");
        assertEquals(1, produto1.getPontuacao(), "A pontuação do primeiro produto está incorreta.");
        assertEquals(10.95, produto1.getPreco(), 0.01, "O preço do primeiro produto está incorreto."); // Permite variação com ponto ou vírgula
        assertEquals(1, produto1.getQuantidadeEstoque(), "A quantidade em estoque do primeiro produto está incorreta.");

        Produto produto2 = produtos.get(1);
        assertEquals(107, produto2.getId(), "O ID do segundo produto está incorreto.");
        assertEquals("Sonho", produto2.getNome(), "O nome do segundo produto está incorreto.");
        assertEquals("Padaria", produto2.getCategoria(), "A categoria do segundo produto está incorreta.");
        assertEquals(4, produto2.getPontuacao(), "A pontuação do segundo produto está incorreta.");
        assertEquals(7.90, produto2.getPreco(), 0.01, "O preço do segundo produto está incorreto."); // Permite variação com ponto ou vírgula
        assertEquals(25, produto2.getQuantidadeEstoque(), "A quantidade em estoque do segundo produto está incorreta.");

        Produto produto3 = produtos.get(2);
        assertEquals(108, produto3.getId(), "O ID do terceiro produto está incorreto.");
        assertEquals("Folha", produto3.getNome(), "O nome do terceiro produto está incorreto.");
        assertEquals("Papelaria", produto3.getCategoria(), "A categoria do terceiro produto está incorreta.");
        assertEquals(3, produto3.getPontuacao(), "A pontuação do terceiro produto está incorreta.");
        assertEquals(4.50, produto3.getPreco(), 0.01, "O preço do terceiro produto está incorreto."); // Permite variação com ponto ou vírgula
        assertEquals(156, produto3.getQuantidadeEstoque(), "A quantidade em estoque do terceiro produto está incorreta.");
    }

}
