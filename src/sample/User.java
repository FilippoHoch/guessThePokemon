package sample;

import java.util.ArrayList;

public class User {

    private String username;
    private int risposteDate;
    private final ArrayList<Pokemon> pokemonPossibili;


    public User (){
        this.pokemonPossibili = ListOfPokemon.possiblePokemons();
    }

    public int getScore(int aiutiDati) {
        return (( pokemonPossibili.size() / 721) + ((9 - aiutiDati) / 8)) * 50;
    }
}
