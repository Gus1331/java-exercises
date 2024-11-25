package school.sptech.prova_ac1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public List<Usuario> findByEmail(String email);

    public List<Usuario> findByCpf(String cpf);

    public List<Usuario> findByDataNascimentoAfter(LocalDate data);
}
