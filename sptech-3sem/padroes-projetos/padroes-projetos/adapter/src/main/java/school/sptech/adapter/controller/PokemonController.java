package school.sptech.adapter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import school.sptech.adapter.dto.Pokemon;
import school.sptech.adapter.integration.PokemonIntegrationService;
import school.sptech.adapter.integration.dto.PokemonResponse;
import school.sptech.adapter.service.PokemonService;

@RestController
@RequestMapping("/chars")
public class PokemonController {
    
    private final PokemonIntegrationService pokemonIntegrationService;

    private final PokemonService pokemonService;

    public PokemonController(PokemonIntegrationService pokemonIntegrationService, PokemonService pokemonService) {
        this.pokemonIntegrationService = pokemonIntegrationService;
        this.pokemonService = pokemonService;
    }

    //FIRST IMPLEMENTATION
    @GetMapping("/full-info/{name}")
    public ResponseEntity<PokemonResponse> getPokemon(@PathVariable String name) {
        return ResponseEntity.ok(pokemonIntegrationService.getPokemon(name));
    }

    //SECOND IMPLEMENTATION (USING ADAPTER)
    @GetMapping("short-info/{name}")
    public ResponseEntity<Pokemon> getPokemonShortInfo(@PathVariable String name) {
        return ResponseEntity.ok(pokemonService.getPokemon(name));
    }
}
