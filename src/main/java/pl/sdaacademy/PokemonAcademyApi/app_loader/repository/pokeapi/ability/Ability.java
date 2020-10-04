package pl.sdaacademy.PokemonAcademyApi.app_loader.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Ability {
    @JsonProperty("ability")
    private AbilityDetails abilityDetails;

    public AbilityDetails getAbilityDetails() {
        return abilityDetails;
    }

    public void setAbilityDetails(AbilityDetails abilityDetails) {
        this.abilityDetails = abilityDetails;
    }
}
