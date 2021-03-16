package sample;

public class User {

    private String username;


    public User (){    }

    public int getScore() {
        return (( ListOfPokemon.filteredPokemonArrayList.size() / 721) + ((9 - sampleController.nTry) / 8)) * 50;
    }

    public void setUsername(String username){   this.username = username;   }
}
