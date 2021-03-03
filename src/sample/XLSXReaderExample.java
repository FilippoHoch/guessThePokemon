package sample;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
public class XLSXReaderExample
{
    public static void main(String[] args)
    {
        ArrayList<Pokemon> pokemonArrayList = new ArrayList<>();
        try
        {
            File f = new File( "src/sample/pokemonDataBase.xlsx" );
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
    }
}