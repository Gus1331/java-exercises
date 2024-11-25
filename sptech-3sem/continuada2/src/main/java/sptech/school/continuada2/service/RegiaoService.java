package sptech.school.continuada2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sptech.school.continuada2.entity.Regiao;
import sptech.school.continuada2.exception.ConflitoException;
import sptech.school.continuada2.exception.NaoEncontradoException;
import sptech.school.continuada2.repository.PersonagemRepository;
import sptech.school.continuada2.repository.RegiaoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegiaoService {

    // WARN: Não edite essa classe! Já está pronta!

    private final RegiaoRepository regiaoRepository;
    private final PersonagemRepository personagemRepository;

    public Regiao cadastrar(Regiao regiao) {

        if (regiaoRepository.existsBySigla(regiao.getSigla())) {
            throw new ConflitoException("Sigla %s já cadastrada".formatted(regiao.getSigla()));
        }

        return regiaoRepository.save(regiao);
    }

    public List<Regiao> listar() {
        return regiaoRepository.findAll();
    }

    public Regiao buscarPorId(Integer id) {
        return regiaoRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Região não encontrada"));
    }
}
