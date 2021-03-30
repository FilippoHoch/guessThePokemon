package sample;

import java.util.ArrayList;

// Questo file ci permetterà di poter costruire degli slot per definire le abilità
public class Ability {
    public ArrayList<Integer> abilitySlots = new ArrayList<>();
    public int pokemonId;

    public Ability(int pokemonId) {
        this.pokemonId = pokemonId;
    }
    
    /**
    * Questo metodo assegna l'id dell'abilità di un Pokèmon al Pokemon in questione
    *
    * @arguments id unico dell'abilità
    */
    public void addAbilitySlots(int abilityId) {
        abilitySlots.add(abilityId);
    }
}
