package school.sptech.projeto_05_validations.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import school.sptech.projeto_05_validations.entity.BoletoBancario;

import java.util.List;

@Repository
public interface BoletoBancarioRepository extends JpaRepository<BoletoBancario, Integer> {

    List<BoletoBancario> findByCpf(String cpf);

    List<BoletoBancario> findByNomePagadorContainingIgnoreCase(String nome);

    boolean existsByCpfOrEmail(String cpf, String email);

    //JPQL

    @Query("SELECT b FROM BoletoBancario b WHERE b.cpf = :cpf")
    List<BoletoBancario> buscaDoisda(String cpf);
}
