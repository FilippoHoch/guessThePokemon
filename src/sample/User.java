package sample;

public class User {

    public String username;
    public int score;
    public String settings = "";


    public User(String username) {
        this.username = username;
    }

    public User(String username, String settings, int score) {
        this.username = username;
        this.score = score;
        this.settings = settings;
    }

    public String getUsername() {
        return username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSettings() {
        return settings;
    }

    public void setScore() {
        double nPokemonMod = (double) ListOfPokemon.filteredPokemonArrayList.size() / 721;
        double tryMod = (10 - (double) sampleController.nTry) / 9;
        double tempScore = nPokemonMod * tryMod * 100;
        score = (int) tempScore;
    }

    public void setSettings() {
        String[] evolutionSteps = {"Base", "Phase1", "Phase2"};
        String[] rarity = {"Starter", "Common", "Fossil", "Legendary", "Pseudo-Legendary", "Mysterious"};
        for (int i = 0; i < createNewGameController.generationResult.size(); i++) {
            if (createNewGameController.generationResult.get(i)) {
                settings = settings.concat(i + 1 + "°, ");
            }
        }
        settings = settings.concat(" generazione; ");
        for (int i = 0; i < createNewGameController.evolutionStepResult.size(); i++) {
            if (createNewGameController.evolutionStepResult.get(i)) {
                settings = settings.concat(evolutionSteps[i] + ", ");
            }
        }
        settings = settings.concat("; ");
        for (int i = 0; i < createNewGameController.rarityResult.size(); i++) {
            if (createNewGameController.rarityResult.get(i)) {
                settings = settings.concat(rarity[i] + ", ");
            }
        }
    }
}