package school.sptech.projeto_06_service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntidadeNaoEncontradaExeption extends RuntimeException{

    public EntidadeNaoEncontradaExeption() {
        super();
    }

    public EntidadeNaoEncontradaExeption(String message) {
        super(String.format("%s não encontrado(a)" , message));
    }
}
