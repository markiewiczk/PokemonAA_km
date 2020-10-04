package pl.sdaacademy.PokemonAcademyApi.service;

import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;
import pl.sdaacademy.PokemonAcademyApi.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.repository.PokemonResult;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PokemonTransformer {
    public Pokemon transformToPokemon(PokemonResult pokemonResult) {
        String[] urlData = pokemonResult.getUrl().split("/");
        int id = Integer.parseInt(urlData[urlData.length - 1]);
        return new Pokemon(id, pokemonResult.getName(), pokemonResult.getUrl());
    }


    public List<Pokemon> transformToPokemonList(List<PokemonResult> pokemonResults) {
        return pokemonResults.stream().map(this::transformToPokemon)
                .collect(Collectors.toList());
    }
}
