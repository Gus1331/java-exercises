package school.sptech.adapter.service;

import org.springframework.stereotype.Service;

import school.sptech.adapter.dto.Pokemon;
import school.sptech.adapter.integration.client.PokemonClient;
import school.sptech.adapter.integration.dto.PokemonResponse;

@Service
public class PokemonService {

    private final PokemonClient pokemonClient;

    public PokemonService(PokemonClient pokemonClient) {
        this.pokemonClient = pokemonClient;
    }

    // ADAPTING THE RESPONSE FROM THE INTEGRATION
    public Pokemon getPokemon(String name) {
        PokemonResponse response = this.pokemonClient.getPokemon(name);
        return new Pokemon(response.getName(), response.getHeight(), response.getWeight());
    }
}
