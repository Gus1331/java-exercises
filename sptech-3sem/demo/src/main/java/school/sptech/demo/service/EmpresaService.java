package school.sptech.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.demo.entity.Empresa;
import school.sptech.demo.exception.ConflitoException;
import school.sptech.demo.exception.EntidadeNaoEncontradaException;
import school.sptech.demo.repository.EmpresaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public List<Empresa> buscarTodos() {
        return empresaRepository.findAll();
    }

    public Empresa buscarPorId(int i) {
        return empresaRepository.findById(i).orElseThrow(() -> new EntidadeNaoEncontradaException("Empresa"));
    }

    public Empresa salvar(Empresa novaEmpresa){
        if(empresaRepository.existsByCnpj(novaEmpresa.getCnpj())){
            throw new ConflitoException("CNPJ já existe");
        }

        return empresaRepository.save(novaEmpresa);
    }

}
