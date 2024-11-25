package school.sptech.ex_many_to_one_dto1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NaoEncontradoException extends RuntimeException {

    public NaoEncontradoException(String message) {
        super(message);
    }
}
