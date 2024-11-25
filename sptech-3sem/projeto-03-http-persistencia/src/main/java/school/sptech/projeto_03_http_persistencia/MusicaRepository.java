package school.sptech.projeto_03_http_persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {
}
