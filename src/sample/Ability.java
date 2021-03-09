package sample;

import java.util.ArrayList;

public class Ability {
    public ArrayList<Integer> abilitySlots = new ArrayList<>();
    private int pokemonId;

    public Ability(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public void addAbilitySlots(int abilityId) {
        abilitySlots.add(abilityId);
    }
}
