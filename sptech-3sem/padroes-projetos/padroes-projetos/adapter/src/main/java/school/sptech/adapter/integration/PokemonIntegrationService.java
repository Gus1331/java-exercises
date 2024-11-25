package school.sptech.adapter.integration;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import feign.FeignException;
import school.sptech.adapter.integration.client.PokemonClient;
import school.sptech.adapter.integration.dto.PokemonResponse;

@Service
public class PokemonIntegrationService {

    private final PokemonClient pokemonClient;

    public PokemonIntegrationService(PokemonClient pokemonClient) {
        this.pokemonClient = pokemonClient;
    }

    public PokemonResponse getPokemon(String name) {

        try {
            this.pokemonClient.getPokemon(name);
            return pokemonClient.getPokemon(name);
        } catch (FeignException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pokemon not found");
        }
    }
}
