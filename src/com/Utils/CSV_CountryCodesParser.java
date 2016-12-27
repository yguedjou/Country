package com.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Classe de parsage du fichier contenant les codes des pays
 *
 * @author Yasmine Guedjou
 * @since 10-12-2016
 */
public class CSV_CountryCodesParser {

    /**
     * Pour parser le fichier CSV des codes des pays
     *
     * @param cheminCSV Le chemin vers le fichier à parser
     * @return Une liste de tableaux retranscivant le fichier CSV
     */
    public ArrayList<String[]> parseCsvCodesToMap(String cheminCSV) {
        String csvSplitBy = ",";

        ArrayList<String[]> result = new ArrayList<>();
        String line;
        int cpt = 0;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(cheminCSV), Charset.forName("ISO-8859-1"))) {

            // On lit jusqu'à la fin du fichier
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(csvSplitBy);
                int len = lineSplit.length;
                String engName;
                String frName;
                String iso3;
                String iso2;
                String numeric;
                if (len == 7) {
                    engName = lineSplit[0] + ',' + lineSplit[1];
                    frName = lineSplit[2] + ',' + lineSplit[3];
                    iso2 = lineSplit[4];
                    iso3 = lineSplit[5];
                    numeric = lineSplit[6];
                    String codes[] = {engName, frName, iso2, iso3, numeric};
                    result.add(codes);
                } else if (len == 6) {
                    engName = lineSplit[0];
                    frName = lineSplit[1] + lineSplit[2];
                    iso2 = lineSplit[3];
                    iso3 = lineSplit[4];
                    numeric = lineSplit[5];
                    String codes[] = {engName, frName, iso2, iso3, numeric};
                    result.add(codes);
                } else
                    result.add(lineSplit);
                cpt++;
            }
            System.out.println(" Lecture du fichier CSV reussie, " + cpt + " lignes lues");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
