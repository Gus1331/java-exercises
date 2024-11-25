package sptech.school.continuada2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sptech.school.continuada2.entity.Personagem;
import sptech.school.continuada2.entity.Regiao;
import sptech.school.continuada2.exception.NaoEncontradoException;
import sptech.school.continuada2.repository.PersonagemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonagemService {

    private final RegiaoService regiaoService;
    private final PersonagemRepository personagemRepository;

    //WARN: Já esta pronto! pule para o próximo
    public List<Personagem> listar() {
        return personagemRepository.findAll();
    }

    //TODO: Implementar buscar por ID
    public Personagem buscarPorId(Integer id) {
        Personagem p = personagemRepository.findById(id).orElse(null);
        if(p != null){
            return p;
        }
        throw new NaoEncontradoException("achei paia");
    }

    //TODO: Implementar cadastro (use a service de região para buscar a região pelo ID)
    public Personagem cadastrar(Personagem personagem, int regiaoId) {
        Regiao r = regiaoService.buscarPorId(regiaoId);
        personagem.setRegiao(r);
        return personagemRepository.save(personagem);
    }

    //TODO: Implementar pesquisa por nome da região aproximado e ignorando maiúsculas e minúsculas
    public List<Personagem> buscarPorRegiaoNomeAproximado(String nome) {
        List<Personagem> personagens = personagemRepository.findByRegiaoNomeContainingIgnoreCase(nome);
        return personagens;
    }

    //TODO: Implementar pesquisa por função principal e sigla da região (valores exatos)
    public List<Personagem> buscarPorfuncaoPrincipalAndRegiaoSigla(String funcaoPrincipal, String sigla) {
        List<Personagem> personagens = personagemRepository.findByFuncaoPrincipalAndRegiaoSigla(funcaoPrincipal, sigla);
        return personagens;
    }
}
