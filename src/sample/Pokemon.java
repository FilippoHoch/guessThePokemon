package sample;

// Questa classe ci permette di definire i vari Pokémon e tutte le loro informazioni
public class Pokemon {

    private final int id;
    private final String name;
    private final int evoPhase; //base = 0; fase1 = 1; fase2 = 2
    private final String type1;
    private final String type2;
    private final int generation; //form 1 to 6
    private final String rarity; //Starter, Common, Fossil, Leggendary, Semi-Legendary, Mysterious
    private final double height; //in mt
    private final double weight; //in kg
    public String[] abilities = new String[3];
    public String randomAbility;

    /**
    * Il costruttore dei Pokémon richiede tutte le informazioni caratteristiche di ogni Pokémon
    */
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

    public String getName() {
        return name;
    }

    public int getEvoPhase() {
        return evoPhase;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public int getGeneration() {
        return generation;
    }

    public String getRarity() {
        return rarity;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    /**
    * Questo metodo ci permette di poter assegnare correttamente tutte le abilità dei Pokémon, in particolare quelli che ne hanno più di una
    */
    public void setAbilities() {
        abilities[0] = ListOfPokemon.abilityArrayList
                .get(ListOfPokemon.pokemonAbilityArrayList.get(getId()).abilitySlots.get(0));
        if (ListOfPokemon.pokemonAbilityArrayList.get(getId()).abilitySlots.size() == 2) {
            abilities[1] = ListOfPokemon.abilityArrayList
                    .get(ListOfPokemon.pokemonAbilityArrayList.get(getId()).abilitySlots.get(1));
        } else if (ListOfPokemon.pokemonAbilityArrayList.get(getId()).abilitySlots.size() == 3) {
            abilities[2] = ListOfPokemon.abilityArrayList
                    .get(ListOfPokemon.pokemonAbilityArrayList.get(getId()).abilitySlots.get(2));
        }
    }

}
