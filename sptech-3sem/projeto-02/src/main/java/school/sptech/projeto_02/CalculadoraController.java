package school.sptech.projeto_02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RequestMapping("/calculos")
@RestController
public class CalculadoraController {
    private Integer contador = 0;

    @GetMapping("contar")
    public Integer contar(){
        return ++contador;
    }

    @GetMapping("somar/{n1}/{n2}")
    public Integer somar(@PathVariable Integer n1, @PathVariable Integer n2){
        return n1 + n2;
    }

    /*
    @GetMapping("data/{data}")
    public LocalDate data (@PathVariable LocalDate data){
        return data.
    }
    */
}
