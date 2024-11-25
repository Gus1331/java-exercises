package school.sptech.teste_relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.teste_relacionamento.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
