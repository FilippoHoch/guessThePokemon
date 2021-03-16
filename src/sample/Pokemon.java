package sample;

import java.util.ArrayList;

public class Pokemon {

    public String[] abilities = new String[3];
    public String randomAbility;
    private int id;
    private String name;
    private int evoPhase; //base = 0; fase1 = 1; fase2 = 2
    private String type1;
    private String type2;
    private int generation; //form 1 to 6
    private String rarity; //Starter, Common, Fossil, Leggendary, Semi-Legendary, Mysterious
    private double height; //in mt
    private double weight; //in kg

    public Pokemon(int id, String name, int evoPhase, String type1, String type2,
                   int generation, String rarity, double height, double weight) {
        this.id = id;
        this.name = name;
        this.evoPhase = evoPhase;
        this.type1 = type1;
        this.type2 = type2;
        this.generation = generation;
        this.rarity = rarity;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEvoPhase() {
        return evoPhase;
    }

    public void setEvoPhase(int evoPhase) {
        this.evoPhase = evoPhase;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAbilities(ArrayList<Ability> pokemonAbilityArrayList, ArrayList<String> abilityArrayList) {
        abilities[0] = abilityArrayList.get(pokemonAbilityArrayList.get(getId()).abilitySlots.get(0));
        if (pokemonAbilityArrayList.get(getId()).abilitySlots.size() == 2) {
            abilities[1] = abilityArrayList.get(pokemonAbilityArrayList.get(getId()).abilitySlots.get(1));
        } else if (pokemonAbilityArrayList.get(getId()).abilitySlots.size() == 3) {
            abilities[2] = abilityArrayList.get(pokemonAbilityArrayList.get(getId()).abilitySlots.get(2));
        }
    }

}