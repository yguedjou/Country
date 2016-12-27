package com.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CSV_CountryCodesParser {
    private String engName;
    private String frName;
    private String iso3;
    private String iso2;
    private String numeric;


    /**
     * Method used to parse CountryCodes csv file
     *
     * @param cheminCSV
     * @param csvSplitBy
     * @return
     */


    public ArrayList<String[]> parseCsvCodesToMap(String cheminCSV) {
        String csvSplitBy = ",";

        /** Using ArrayList as the number of values are unknown at this stage */
        ArrayList<String[]> result = new ArrayList<String[]>();
        String line = "";
        int cpt = 0;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(cheminCSV), Charset.forName("ISO-8859-1"))) {

            /** to repeat as much onces when the line isn't a country   */
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(csvSplitBy);
                int len = lineSplit.length;
                if (len == 7) {
                    this.engName = lineSplit[0] + ',' + lineSplit[1];
                    this.frName = lineSplit[2] + ',' + lineSplit[3];
                    this.iso2 = lineSplit[4];
                    this.iso3 = lineSplit[5];
                    this.numeric = lineSplit[6];
                    String codes[] = {engName, frName, iso2, iso3, numeric};
                    result.add(codes);
                } else if (len == 6) {
                    this.engName = lineSplit[0];
                    this.frName = lineSplit[1] + lineSplit[2];
                    this.iso2 = lineSplit[3];
                    this.iso3 = lineSplit[4];
                    this.numeric = lineSplit[5];
                    String codes[] = {engName, frName, iso2, iso3, numeric};
                    result.add(codes);
                } else {
                    result.add(lineSplit);

                }
                cpt++;
            }

            System.out.println(" Lecture du fichier CSV reussie, " + cpt + " lignes lues");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return result;

    }


}
