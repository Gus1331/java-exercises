package school.sptech.exerciciojpavalidation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.exerciciojpavalidation.entity.Evento;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    List<Evento> findByGratuito(Boolean gratuito);

    List<Evento> findByDataEventoOrDataPublicacao(LocalDate dataEvento, LocalDate dataPublicacao);

    List<Evento> findByDataEventoBetween(LocalDate inicio, LocalDate fim);
}
