package school.sptech.ex_many_to_one_dto1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.ex_many_to_one_dto1.entity.Carteira;
import school.sptech.ex_many_to_one_dto1.exception.NaoEncontradoException;
import school.sptech.ex_many_to_one_dto1.repository.CarteiraRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;

    public Carteira salvar(Carteira carteira) {
        return carteiraRepository.save(carteira);
    }

    public List<Carteira> buscarTodos() {
        return carteiraRepository.findAll();
    }

    public Carteira buscarPorId(int id) {
        return carteiraRepository.findById(id).orElseThrow(
                () -> new NaoEncontradoException("Carteira de id: %d não encontrada".formatted(id))
        );
    }
}
