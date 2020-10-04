package pl.sdaacademy.PokemonAcademyApi.pokemonDetalis.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.*;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.pokeapi.PokemonDetailsRepository;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.pokeapi.PokemonDetailsResponse;
import pl.sdaacademy.PokemonAcademyApi.app_loader.service.PokemonDetailsTransformer;
import pl.sdaacademy.PokemonAcademyApi.common.NoPokemonFoundExeption;
import pl.sdaacademy.PokemonAcademyApi.common.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.common.repository.PokemonRepository;


@Service
public class PokemonDetailsService<pokemon> {

    private final PokemonRepository pokemonRepository;
    private final PokemonDetailsRepository pokemonDetailsRepository;
    private final PokemonDetailsTransformer pokemonDetailsTransformer;


    public PokemonDetailsService(PokemonRepository pokemonRepository, PokemonDetailsRepository pokemonDetailsRepository, PokemonDetailsTransformer pokemonDetailsTransformer) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonDetailsRepository = pokemonDetailsRepository;
        this.pokemonDetailsTransformer = pokemonDetailsTransformer;
    }

    @GetMapping
    public PokemonDetails getPokemon(@RequestParam String name) {
        Pokemon pokemon = pokemonRepository.findByName(name).orElseThrow(() -> {
            throw new NoPokemonFoundExeption(name);
        });

        PokemonDetailsResponse response = pokemonDetailsRepository.pokemonDetailsResponse(pokemon.getUrl());

        return pokemonDetailsTransformer.transformToPokemonDetails(response);

    }
}
