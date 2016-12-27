package com.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Classe de parsage du fichier CSV des superficies
 *
 * @author Yasmine Guedjou
 * @since 20-12-2016
 */
public class ParseCsv {
    /**
     * Method used to extract country information from a csv file
     *
     * @param cheminCSV
     * @return
     */
    public static ArrayList<String[]> parseCsvCodesToMap(String cheminCSV, String csvSplitBy) {
        /** Using ArrayList as the number of values are unknown at this stage */
        ArrayList<String[]> result = new ArrayList<>();
        String line = "";
        int cpt = 0;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(cheminCSV), Charset.forName("ISO-8859-1"))) {
            /** to repeat as much as the line isn't a country   */
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(csvSplitBy);
                result.add(lineSplit);
                cpt++;
            }
            System.out.println(" Lecture du fichier CSV reussie, " + cpt + " lignes lues");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
    public static <Type de la MAP> parseCsvISOToMap(String cheminCSV) {

        <Type de la MAP> mapISO = new <Type de la MAP><>();
        String line = "";
        String cvsSplitBy = ";";
        int cpt = 0;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(cheminCSV), Charset.forName("ISO-8859-1"))) {
            
            // A répéter le nombre de fois qu'il y a des lignes qui sont pas des pays
            br.readLine();

            while (line = br.readLine() != null) {
                String[] lineSplit = line.split(cvsSplitBy);
                if (!lineSplit[0].isEmpty()) {
                    mapISO.put(lineSplit[<num ISO 2>], lineSplit[<num ISO 3>]);
                    cpt++;
                } 
            }
            System.out.println("[O]\tLecture du fichier CSV reussie, " + cpt + " lignes lues");
        } catch (FileNotFoundException e) {
            Main.ecrire_log("[X]\tLe fichier CSV a lire est introuvable");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            Main.ecrire_log("[X]\tErreur lors de la lecture du fichier CSV");
            System.exit(1);
        }

        return mapISO;
    }

	
	
	*/


}
