package sample;

import javafx.scene.image.Image;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

// La seguente classe contiene i Pokemon che possiamo indovinare tramite i vari filtri da noi apportati
public class ListOfPokemon {
    public static ArrayList<Pokemon> pokemonArrayList = new ArrayList<>();
    public static ArrayList<String> abilityArrayList = new ArrayList<>();
    public static ArrayList<Ability> pokemonAbilityArrayList = new ArrayList<>();
    public static ArrayList<Image> pokemonShape = new ArrayList<>();
    public static ArrayList<Pokemon> filteredPokemonArrayList;

    ListOfPokemon() {
    }

    /**
     * Questo metodo estrae i dati dei Pokémon dal file Excel e applica
     */
    public void excelReading() {
        try {
            File f = new File("src/sample/Excel/withoutDescription/pokemonDataBaseWD.xlsx");
            Workbook wb = WorkbookFactory.create(f);
            Sheet mySheet = wb.getSheetAt(0);
            // Iteratore che aggiunge alla lista i Pokémon inserendoli nella classe omonima
            for (Iterator<Row> rowIterator = mySheet.rowIterator(); rowIterator.hasNext(); ) {
                Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
                // Gabriele propone ottimizzazione (rimozione di variazione della variabile)
                int pokemonNumber = (int) Math.round(Double.parseDouble(cellIterator.next().toString()));
                String pokemonName = cellIterator.next().toString();
                int pokemonPhase = (int) Math.round(Double.parseDouble(cellIterator.next().toString()));
                String pokemonType1 = cellIterator.next().toString();
                String pokemonType2 = cellIterator.next().toString();
                int pokemonGeneration = (int) Math.round(Double.parseDouble(cellIterator.next().toString()));
                String pokemonRarity = cellIterator.next().toString();
                double pokemonHeight = Double.parseDouble(cellIterator.next().toString());
                double pokemonWeight = Double.parseDouble(cellIterator.next().toString());

                pokemonArrayList.add(new Pokemon(pokemonNumber, pokemonName, pokemonPhase, pokemonType1, pokemonType2,
                        pokemonGeneration, pokemonRarity, pokemonHeight, pokemonWeight));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File f = new File("src/sample/Excel/withoutDescription/abilityDataBaseWD.xlsx");
            Workbook wb = WorkbookFactory.create(f);
            Sheet mySheet = wb.getSheetAt(0);
            // Iteratore che estrae tutte le abilità 
            for (Iterator<Row> rowIterator = mySheet.rowIterator(); rowIterator.hasNext(); ) {
                Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
                String abilityName = cellIterator.next().toString();
                abilityArrayList.add(abilityName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File f = new File("src/sample/Excel/withoutDescription/abilityDataBasePokemonWD.xlsx");
            Workbook wb = WorkbookFactory.create(f);
            Sheet mySheet = wb.getSheetAt(0);
            boolean firstTime = true;
            // Iteratore che assegna le abilità ai Pokémon a cui appartengono 
            for (Iterator<Row> rowIterator = mySheet.rowIterator(); rowIterator.hasNext(); ) {
                Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
                int pokemonId = (int) Math.round(Double.parseDouble(cellIterator.next().toString()));
                pokemonId--;
                int abilityId = (int) Math.round(Double.parseDouble(cellIterator.next().toString()));
                if (firstTime) {
                    pokemonAbilityArrayList.add(new Ability(pokemonId));
                    firstTime = false;
                } else if (pokemonAbilityArrayList.get(pokemonAbilityArrayList.size() - 1).pokemonId != pokemonId) {
                    pokemonAbilityArrayList.add(new Ability(pokemonId));
                }
                pokemonAbilityArrayList.get(pokemonId).addAbilitySlots(abilityId - 1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File f = new File("src/sample/Excel/withoutDescription/Shape.xlsx");
            Workbook wb = WorkbookFactory.create(f);
            Sheet mySheet = wb.getSheetAt(0);
            // Iteratore che assegna ai vari Pokémon le loro forme 
            for (Iterator<Row> rowIterator = mySheet.rowIterator(); rowIterator.hasNext(); ) {
                Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
                String url = cellIterator.next().toString();
                pokemonShape.add(new Image(url));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Pokemon pokemon : pokemonArrayList) {
            pokemon.setAbilities();
        }
    }

    /**
     * Questo metodo permette, nel caso il Pokémon abbia più di un'abilità, di poterla assegnare completamente.
     *
     * @arguments Pokémon
     */
    public String randomAbility(Pokemon pokemon) {
        Random random = new Random();
        String ability;
        do {
            ability = pokemon.abilities[random.nextInt(2)];
        } while (ability == null);
        return ability;
    }

    /**
     * Quando si gioca, possiamo utilizzare dei filtri per poter selezionare i Pokémon desiderati. Grazie a questo metodo, possiamo selezionarli.
     *
     * @return lista dei Pokémon che sono stati filtrati
     */
    public ArrayList<Pokemon> filteredPokemons() {
        ArrayList<Pokemon> pokemons = (ArrayList<Pokemon>) pokemonArrayList.clone();
        String[] rar = {"Starter", "Common", "Fossil", "Legendary", "Pseudo-Legendary", "Mysterious"};
        for (int j = 0; j < createNewGameController.generationResult.size(); j++) {
            for (int i = 0; i < pokemons.size(); i++) {
                if (!createNewGameController.generationResult.get(j) && pokemons.get(i).getGeneration() == j + 1) {
                    pokemons.remove(i);
                    i--;
                }
            }
        }
        for (int j = 0; j < createNewGameController.evolutionStepResult.size(); j++) {
            for (int i = 0; i < pokemons.size(); i++) {
                if (!createNewGameController.evolutionStepResult.get(j) && pokemons.get(i).getEvoPhase() == j) {
                    pokemons.remove(i);
                    i--;
                }
            }
        }
        for (int j = 0; j < createNewGameController.rarityResult.size(); j++) {
            for (int i = 0; i < pokemons.size(); i++) {
                if (!createNewGameController.rarityResult.get(j) &&
                        pokemons.get(i).getRarity().equalsIgnoreCase(rar[j])) {
                    pokemons.remove(i);
                    i--;
                }
            }
        }
        return pokemons;
    }

    /**
     * Il metodo seleziona randomicamente uno dei vari Pokémon che sono stati filtrati.
     *
     * @return lista dei Pokémon che sono stati filtrati
     */
    public Pokemon takeRandomPokemon() {
        Random random = new Random();
        return filteredPokemons().get(random.nextInt(filteredPokemons().size()));
    }


}
