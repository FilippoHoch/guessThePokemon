package sample;

public class Pokemon {

    private int id;
    private String name;
    private int evoPhase; //base = 0; fase1 = 1; fase2 = 2
    private String type1;
    private String type2;
    private int generation; //form 1 to 6
    private String rarity; //Starter, Common, Fossil, Leggendary, Pseudo-Leggendary, Mysterious
    private double height; //in mt
    private double weight; //in kg
    private String[] abilities = new String[3];

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
    public void setAbilities( String ability0, String ability1, String ability2 ){
        this.abilities[0] = ability0;
        this.abilities[1] = ability1;
        this.abilities[2] = ability2;
    }

}