package sptech.school.continuada2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.continuada2.entity.Regiao;

public interface RegiaoRepository extends JpaRepository<Regiao, Integer> {

    // WARN: Não edite essa interface! Já está pronta!

    boolean existsBySigla(String sigla);
}
