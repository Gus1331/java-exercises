package test.Corvinal.corvinal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.Corvinal.entity.Jogo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @GetMapping("/jogo-favorito")
    public Jogo jogoFavorito(){

        Jogo jogoFavorito = new Jogo(13,"Zelda ocarina of Time", 1989, 10.0);
        return jogoFavorito;
    }

    @GetMapping
    public List<Jogo> listarJogos(){

        List<Jogo> listaJogos = new ArrayList<>();

        Jogo jogo01 = new Jogo(1, "Metal Hellsinger", 2021, 8.5);

        listaJogos.add(jogo01);

        listaJogos.add( new Jogo(2,"Little Nigmares 2", 2021, 7.9));
        return listaJogos;
    }

    @GetMapping("/{id}")
    public Jogo buscarPorId(@PathVariable Integer id){
        List<Jogo> listaJogos = new ArrayList<>();

        Jogo jogo01 = new Jogo(1, "Metal Hellsinger", 2021, 8.5);

        listaJogos.add(jogo01);
        listaJogos.add( new Jogo(2,"Little Nigmares 2", 2021, 7.9));

        for(int i = 0; i < listaJogos.size(); i++){
            if(listaJogos.get(i).getId() == id){
                return listaJogos.get(i);
            }
        }

        return null;
    }
}
