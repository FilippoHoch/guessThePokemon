package sample;

import java.util.ArrayList;

public class Ability {
    private int pokemonId;
    public ArrayList<Integer> abilitySlots = new ArrayList<>();
    public Ability (int pokemonId){
        this.pokemonId = pokemonId;
    }
    public void addAbilitySlots(int abilityId) {
        abilitySlots.add(abilityId);
    }
}
