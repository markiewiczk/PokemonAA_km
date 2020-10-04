package pl.sdaacademy.PokemonAcademyApi.app_loader.repository.pokeapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.pokeapi.PokemonDetailsResponse;

@Repository
public class PokemonDetailsRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public PokemonDetailsRepository(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    public PokemonDetailsResponse pokemonDetailsResponse(String url) {
        return restTemplate.getForObject(url, PokemonDetailsResponse.class);
    }
}
