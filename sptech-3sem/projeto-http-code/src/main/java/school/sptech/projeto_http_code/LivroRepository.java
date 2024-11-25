package school.sptech.projeto_http_code;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    //buscadores dinamicos
    /*
        findBy= SELECT * FROM LIVRO
        Nome = WHERE Nome = ?
     */
    List<Livro> findByNome(String nome);

    List<Livro> findByNomeContainsIgnoreCase(String nome);

    List<Livro> findByNomeContainsIgnoreCaseOrderByClassificacaoDesc(String nome);

    List<Livro> findByDataLancamentoBetween(LocalDate data1, LocalDate data2);

    List<Livro> findByOrderByClassificacaoDesc();
}
