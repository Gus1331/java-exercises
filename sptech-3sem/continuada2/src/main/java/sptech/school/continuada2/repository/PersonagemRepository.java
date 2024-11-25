package sptech.school.continuada2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sptech.school.continuada2.entity.Personagem;

import java.util.List;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {

    //TODO: Implementar as consultas personalizadas

    List<Personagem> findByFuncaoPrincipalAndRegiaoSigla(String funcaoPrincipal, String sigla);

    List<Personagem> findByRegiaoNomeContainingIgnoreCase(String nome);
}
