package sample;

public class User {

    public String username;
    public int score;
    public String settings = "";


    public User (String username){
        this.username = username;
    }

    public User (String username, String settings, int score){
        this.username = username;
        this.score = score;
        this. settings = settings;
    }

    public void setScore() {
        score = ((ListOfPokemon.filteredPokemonArrayList.size() / 721) + ((9 - sampleController.nTry) / 8)) * 50;
    }

    public void setSettings() {
        String[] evolutionSteps = {"Base", "Phase1", "Phase2"};
        String[] rarity = {"Starter", "Common", "Fossil", "Legendary", "Pseudo-Legendary", "Mysterious"};
        for (int i = 0; i < createNewGameController.generationResult.size(); i++) {
            if (createNewGameController.generationResult.get(i)){
                settings.concat( i + "° generazione, ");
            }
        }
        settings.concat(";");
        for (int i = 0; i < createNewGameController.evolutionStepResult.size(); i++){
            if (createNewGameController.evolutionStepResult.get(i)){
                settings.concat(evolutionSteps[i] + ", ");
            }
        }
        settings.concat(";");
        for (int i = 0; i < createNewGameController.rarityResult.size(); i++){
            if (createNewGameController.rarityResult.get(i)){
                settings.concat(rarity[i] + ", ");
            }
        }
    }
}