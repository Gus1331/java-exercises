package school.sptech.adapter.integration.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import school.sptech.adapter.integration.dto.PokemonResponse;

@FeignClient(name = "pokemonClient", url = "https://pokeapi.co/api/v2/pokemon")
public interface PokemonClient {

    @GetMapping("/{name}")
    PokemonResponse getPokemon(@PathVariable String name);
}
