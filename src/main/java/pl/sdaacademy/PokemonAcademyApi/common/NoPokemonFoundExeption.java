package pl.sdaacademy.PokemonAcademyApi.common;

public class NoPokemonFoundExeption extends RuntimeException {

    public NoPokemonFoundExeption(String pokemonName) {
        super(String.format("No pokemon %s found", pokemonName));
    }
}
