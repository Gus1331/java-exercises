package school.sptech.projeto_05_validations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import school.sptech.projeto_05_validations.entity.BoletoBancario;
import school.sptech.projeto_05_validations.repository.BoletoBancarioRepository;

@Service
public class BoletoBancarioService {

    @Autowired
    BoletoBancarioRepository repository;

    public ResponseEntity<BoletoBancario> cadastrar(BoletoBancario boletoBancario) {
        boletoBancario.setId(null);
        /*
        if (boletoBancario.getAgencia() == null ||
                boletoBancario.getAgencia().isEmpty() ||
                boletoBancario.getAgencia().isBlank() ||
                boletoBancario.getAgencia().length() != 4 ||
                boletoBancario.getBanco() == null ||
                boletoBancario.getBanco().isEmpty() ||
                boletoBancario.getBanco().isBlank() ||
                boletoBancario.getBanco().length() != 4 ||
                boletoBancario.getConta() == null ||
                boletoBancario.getConta().isEmpty() ||
                boletoBancario.getConta().isBlank() ||
                boletoBancario.getConta().length() != 4 ||
                boletoBancario.getCodigoBarra() == null ||
                boletoBancario.getCodigoBarra().isEmpty() ||
                boletoBancario.getCodigoBarra().isBlank() ||
                boletoBancario.getCodigoBarra().matches("\\\\d{5}\\\\.\\\\d{5} \\\\d{5}\\\\.\\\\d{6} \\\\d{5}\\\\.\\\\d{6} \\\\d \\\\d{14")) {
            return ResponseEntity.status(400).build();
        }*/
        return ResponseEntity.status(201).body(repository.save(boletoBancario));
    }
}
