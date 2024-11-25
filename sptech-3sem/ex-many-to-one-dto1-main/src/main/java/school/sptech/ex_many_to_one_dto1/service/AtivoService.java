package school.sptech.ex_many_to_one_dto1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.ex_many_to_one_dto1.entity.Ativo;
import school.sptech.ex_many_to_one_dto1.exception.NaoEncontradoException;
import school.sptech.ex_many_to_one_dto1.repository.AtivoRepository;

import java.util.List;

// TODO: TERMINAR A CLASSE
@Service
public class AtivoService {
    @Autowired
    private AtivoRepository ativoRepository;
    @Autowired
    private CarteiraService carteiraService;

    public Ativo salvar(Ativo ativo, Integer carteiraId) {
        ativo.setCarteira(carteiraService.buscarPorId(carteiraId));
        return ativoRepository.save(ativo);
    }

    public List<Ativo> buscarTodos() {
        return ativoRepository.findAll();
    }

    public Ativo buscarPorId(int id) {
        Ativo ativo = ativoRepository.findById(id).orElse(null);
        if(ativo == null){
            throw new NaoEncontradoException("Ativo de id: "+ id + " não encontrado");
        }
        return ativo;
    }

    public void deletarPorId(int id){
        if(!ativoRepository.existsById(id)){
            throw new NaoEncontradoException("Ativo de id: "+ id + " não encontrado");
        }
        ativoRepository.deleteById(id);
    }

    public List<Ativo> buscarAtivosPorInvestidorNome(String nome){
        return ativoRepository.findByInvestidorIgnoreCase(nome);
    }

    public Double buscarMediaAtivosPorInvestidorNome(String nome){
        Double media = 0.0;
        Integer qtd = 0;

        List<Ativo> ativos = ativoRepository.findByInvestidorIgnoreCase(nome);
        for(Ativo a : ativos){
            media += a.getValorAtual();
            qtd++;
        }
        return media / qtd;
    }
}