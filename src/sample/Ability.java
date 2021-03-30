package sample;

import java.util.ArrayList;

// Questo file ci permetterà di poter costruire degli slot per definire le abilità
public class Ability {
    public ArrayList<Integer> abilitySlots = new ArrayList<>();
    public int pokemonId;

    public Ability(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public void addAbilitySlots(int abilityId) {
        abilitySlots.add(abilityId);
    }
}
