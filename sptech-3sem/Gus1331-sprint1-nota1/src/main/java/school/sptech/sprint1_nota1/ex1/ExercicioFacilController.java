package school.sptech.sprint1_nota1.ex1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;

@RestController
public class ExercicioFacilController {

    @GetMapping("/ex-01/{palavra}")
    public Boolean exercicioFacil(@PathVariable String palavra) {
        char[] sArray = palavra.toCharArray();
        String palavraBackwards = "";


        for (int i = sArray.length; i > 0; i--) {
            palavraBackwards += sArray[(i - 1)];
        }

        if (palavraBackwards.replace(" ", "").toLowerCase().equals(palavra.replace(" ", "").toLowerCase())){
            return true;
        } else {
            return false;
        }
    }
}
