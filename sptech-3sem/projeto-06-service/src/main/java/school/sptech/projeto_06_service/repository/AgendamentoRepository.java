package school.sptech.projeto_06_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.projeto_06_service.entity.Agendamento;

import java.time.LocalDate;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    boolean existsByData(LocalDate data);
}
