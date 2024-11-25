package school.sptech.projeto_03_http_persistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/musicas")
@RestController
public class MusicaController {

    private List<Musica> musicas = new ArrayList<>();

    @Autowired
    private MusicaRepository musicaRepository;

    @GetMapping("/favorita")
    public Musica favorita(){
        return new Musica("'Till we die", "Nó de suicidio", 2008);
    }

    @PostMapping
    public Musica criar(@RequestBody Musica musica){
        //musicas.add(musica);
        return musicaRepository.save(musica);
    }

    @GetMapping("/listar")
    public List<Musica> listar(){return musicaRepository.findAll();}

    @GetMapping("/{id}")
    public Musica buscarPorIndice(@PathVariable int id){

       Optional<Musica> musicaOpt = musicaRepository.findById(id);
       if(musicaOpt.isPresent()){
           return musicaOpt.get();
       } else {
           return null;
       }
       // return musicaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Musica atualizar(@PathVariable int id, @RequestBody Musica musica){
        if(musicaRepository.existsById(id)){
            musica.setId(id);
            return musicaRepository.save(musica);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable int id){
        if(musicaRepository.existsById(id)){
            musicaRepository.deleteById(id);
        }
    }
}
