package pl.sdaacademy.PokemonAcademyApi.pokemonDetalis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokemonRepository;


@Service
public class PokemonService<pokemon> {

    private final PokemonRepository pokemonRepository;


    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @GetMapping
    public Pokemon getPokemon(@RequestParam String name) {
        return pokemonRepository.findByName(name).orElseThrow(() -> {
            throw new NoPokemonFoundExeption(name);
        });
    }
}
