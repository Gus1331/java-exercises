package school.sptech.projeto_02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/* tudo que for componente é responsabilidade do spring
@Component
@Controller
@Service
@Repository
@Configuration
*/

@RequestMapping("/frases")
@RestController
public class FraseController {

    // URL = caminho
    // URI = rescurso

    // URL = https://localhost:8080/
    // URI = /

    @GetMapping
    public String ola(){
        return "Olá!";
    }

    @GetMapping("/bom-dia")
    public String bomDia(){
        return "Bom dia! :)";
    }

    @GetMapping("/nome/{nome}")
    public String nome(@PathVariable String nome){
        return "Bem vindo, " + nome + "!";
    }

    @GetMapping("/nome-completo/{nome}/{sobrenome}")
    public String nomeCompleto(@PathVariable String nome, @PathVariable String sobrenome){
        return "Bem vindo, " + nome + " " + sobrenome + "!";
    }
}
