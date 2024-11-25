package school.sptech.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.demo.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    boolean existsByCnpj(String cnpj);
}
