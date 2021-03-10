package sample;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ListOfPokemon {
    public static ArrayList<Pokemon> pokemonArrayList = new ArrayList<>();
    public static ArrayList<String> abilityArrayList = new ArrayList<>();
    public static ArrayList<Ability> pokemonAbilityArrayList = new ArrayList<>();

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
            for (Iterator<Row> rowIterator = mySheet.rowIterator(); rowIterator.hasNext(); ) {
                Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
                int pokemonId = (int) Math.round(Double.parseDouble(cellIterator.next().toString()));
                pokemonId--;
                int abilityId = (int) Math.round(Double.parseDouble(cellIterator.next().toString()));
                pokemonAbilityArrayList.add(new Ability(pokemonId));
                pokemonAbilityArrayList.get(pokemonId).addAbilitySlots(abilityId);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int countAbility(int generation, int evoPhase, String rarity) {
        int numeroAbilità = 0;
        for (int i = 0; i < pokemonArrayList.toArray().length; i++) {
            if (pokemonArrayList.get(i).getGeneration() == generation &&
                    pokemonArrayList.get(i).getEvoPhase() == evoPhase &&
                    pokemonArrayList.get(i).getRarity() == rarity) {
                numeroAbilità++;
            }
        }
        return numeroAbilità;
    }

    public Pokemon takeRandomPokemon() {
        ArrayList<Pokemon> pokemons = (ArrayList<Pokemon>) pokemonArrayList.clone();
        String[] rar = {"Starter", "Common", "Fossil", "Legendary", "Pseudo-Legendary", "Mysterious"};
        Random random = new Random();
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
                        pokemons.get(i).getRarity().equalsIgnoreCase(rar[i])) {
                    pokemons.remove(i);
                    i--;
                }
            }
        }
        System.out.println(pokemons.size());
        Pokemon pokemon = pokemons.get(random.nextInt(pokemons.size()));
        return pokemon;
    }

    public int getScore(int aiutiDati, int pokemonPossibili) {
        return ((pokemonPossibili / 721) + ((9 - aiutiDati) / 8)) * 50;
    }


    /**
     * Transforma il nome con il relativo valore numerico
     *
     * @param name Il nome da convertire in numero
     * @return Il numero corrispondente al pokemon in input
     */
    public int nameToInt(String name) {
        for (int i = 0; i < pokemonArrayList.size(); i++) {
            if (pokemonArrayList.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }
}
