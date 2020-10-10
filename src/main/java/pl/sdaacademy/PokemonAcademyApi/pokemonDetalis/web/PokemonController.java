package pl.sdaacademy.PokemonAcademyApi.pokemonDetalis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.pokemonDetalis.service.PokemonDetailsService;

@RequestMapping("/pokemons")
@RestController
public class PokemonController {

    private final PokemonDetailsService pokemonService;

    @Autowired
    public PokemonController(PokemonDetailsService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{name}")
    public PokemonDetails getPokemon(@PathVariable String name) {
        return pokemonService.getPokemonDetails(name);
    }
}
