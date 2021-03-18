package sample;

import javafx.scene.image.Image;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ListOfPokemon {
    public static ArrayList<Pokemon> pokemonArrayList = new ArrayList<>();
    public static ArrayList<String> abilityArrayList = new ArrayList<>();
    public static ArrayList<Ability> pokemonAbilityArrayList = new ArrayList<>();
    public static ArrayList<Image> pokemonShape = new ArrayList<>();
    public static ArrayList<Pokemon> filteredPokemonArrayList;

    ListOfPokemon() {
    }

    public void excelReading() {
        try {
            File f = new File("src/sample/Excel/withoutDescription/pokemonDataBaseWD.xlsx");
            Workbook wb = WorkbookFactory.create(f);
            Sheet mySheet = wb.getSheetAt(0);
            for (Iterator<Row> rowIterator = mySheet.rowIterator(); rowIterator.hasNext(); ) {
                Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
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

    public String randomAbility(Pokemon pokemon) {
        Random random = new Random();
        String ability;
        do {
            ability = pokemon.abilities[random.nextInt(2)];
        } while (ability == null);
        return ability;
    }

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

    public Pokemon takeRandomPokemon() {
        Random random = new Random();
        return filteredPokemons().get(random.nextInt(filteredPokemons().size()));
    }


}
