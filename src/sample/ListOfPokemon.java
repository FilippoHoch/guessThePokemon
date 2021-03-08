package sample;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class ListOfPokemon {

    private final ArrayList<Pokemon> pokemonArrayList = new ArrayList<>();
    private final ArrayList<String> abilityArrayList = new ArrayList<>();
    private final ArrayList<Ability> pokemonAbilityArrayList = new ArrayList<>();


    private ListOfPokemon () {
    }

    public void excelReading() {
        try
        {
            File f = new File( "src/sample/Excel/pokemonDataBase.xlsx" );
            Workbook wb = WorkbookFactory.create(f);
            Sheet mySheet = wb.getSheetAt(0);
            for ( Iterator<Row> rowIterator = mySheet.rowIterator(); rowIterator.hasNext(); )
            {
                Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
                int pokemonNumber = Integer.parseInt(cellIterator.toString());
                String pokemonName = cellIterator.next().toString();
                int pokemonPhase = Integer.parseInt(cellIterator.next().toString());
                String pokemonType1 = cellIterator.next().toString();
                String pokemonType2 = cellIterator.next().toString();
                int pokemonGeneration = Integer.parseInt(cellIterator.next().toString());
                String pokemonRarity = cellIterator.next().toString();
                double pokemonHeight = Double.parseDouble(cellIterator.next().toString());
                double pokemonWeight = Double.parseDouble(cellIterator.next().toString());

                pokemonArrayList.add(new Pokemon(pokemonNumber, pokemonName, pokemonPhase, pokemonType1, pokemonType2, pokemonGeneration, pokemonRarity, pokemonHeight, pokemonWeight));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try{
            File f = new File( "src/sample/Excel/abilityDataBase.xlsx" );
            Workbook wb = WorkbookFactory.create(f);
            Sheet mySheet = wb.getSheetAt(0);
            for ( Iterator<Row> rowIterator = mySheet.rowIterator(); rowIterator.hasNext(); )
            {
                Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
                String abilityName = cellIterator.next().toString();
                abilityArrayList.add(abilityName);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            File f = new File( "src/sample/Excel/abilityDataBasePokemon.xlsx" );
            Workbook wb = WorkbookFactory.create(f);
            Sheet mySheet = wb.getSheetAt(0);
            for ( Iterator<Row> rowIterator = mySheet.rowIterator(); rowIterator.hasNext(); )
            {
                Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
                int pokemonId = Integer.parseInt(cellIterator.toString());
                int abilityId = Integer.parseInt(cellIterator.next().toString());
                pokemonAbilityArrayList.add(new Ability(pokemonId));
                pokemonAbilityArrayList.get(pokemonId).addAbilitySlots(abilityId);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
