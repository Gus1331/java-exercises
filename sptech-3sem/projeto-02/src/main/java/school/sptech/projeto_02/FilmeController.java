package school.sptech.projeto_02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/filmes")
@RestController
public class FilmeController {
    private List<Filme> filmes = new ArrayList<>(List.of(
            new Filme("Yasmimha", "n/a"),
            new Filme("Yasmão", "n/a")
    ));

    @GetMapping("/favorito")
    public Filme favorito(){
        Filme favorito = new Filme("YasmiNNNNNNNN", "ata");
        return favorito;
    }

    @GetMapping
    public List<Filme> filmes(){
        return filmes;
    }

    @GetMapping("criar/{nome}/{diretor}")
    public Filme criar(@PathVariable String nome, @PathVariable String diretor){
        Filme criado = new Filme(nome, diretor);
        filmes.add(criado);
        return criado;
    }

    @GetMapping("{index}")
    public Filme buscaPorIndex( @PathVariable int index){
        if(index >= filmes.size() || index < 0){
            return null;
        }
        return filmes.get(index);
    }

    @GetMapping("atualizar/{index}/{nome}/{diretor}")
    public Filme atualizar(@PathVariable  int index,
                           @PathVariable String nome,
                           @PathVariable String diretor){
        if(index >= filmes.size() || index < 0){
            return null;
        }

        filmes.set(index, new Filme(nome, diretor));
        return filmes.get(index);
    }

    @GetMapping("deletar/{index}")
    public void deletar(@PathVariable int index){
        if(index >= filmes.size() || index < 0){
            return;
        }
        filmes.remove(index);
    }
}
