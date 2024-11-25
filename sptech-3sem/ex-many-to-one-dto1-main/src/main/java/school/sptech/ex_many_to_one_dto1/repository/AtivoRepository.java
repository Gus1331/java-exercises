package school.sptech.ex_many_to_one_dto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.sptech.ex_many_to_one_dto1.entity.Ativo;

import java.util.List;

// TODO: TERMINAR A CLASSE
public interface AtivoRepository extends JpaRepository<Ativo, Integer> {
    @Query("SELECT a FROM Ativo a JOIN a.carteira c WHERE LOWER(c.investidor) IN LOWER(?1)")
    List<Ativo> findByInvestidorIgnoreCase(String nome);

}
