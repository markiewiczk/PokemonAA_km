package pl.sdaacademy.PokemonAcademyApi.app_loader.repository.pokeapi.type;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Type {
    @JsonProperty("type")
    private TypeDetails typeDetails;

    public TypeDetails getTypeDetails() {
        return typeDetails;
    }

    public void setTypeDetails(TypeDetails typeDetails) {
        this.typeDetails = typeDetails;
    }
}
