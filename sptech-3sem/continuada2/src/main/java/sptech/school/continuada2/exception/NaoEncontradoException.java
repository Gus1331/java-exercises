package sptech.school.continuada2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NaoEncontradoException extends RuntimeException {

    // WARN: Não edite essa classe! Já está pronta.

    public NaoEncontradoException(String message) {
        super(message);
    }
}
