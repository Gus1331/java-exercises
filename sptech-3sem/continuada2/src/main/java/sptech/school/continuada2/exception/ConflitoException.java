package sptech.school.continuada2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflitoException extends RuntimeException {

    // WARN: Não edite essa classe! Já está pronta.

    public ConflitoException(String message) {
        super(message);
    }
}
