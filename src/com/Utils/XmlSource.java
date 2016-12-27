package com.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class XmlSource {
    private String name;
    private String fips;
    private String region;
    private static char[] separators = {'<', '=', '\t'};
    private static char specialChars = '"';

    /**
     * method used to parse a line of xml file
     *
     * @param line
     * @return
     */
    public static String[] lineParser(String line) {
        String[] result = null;


        /** Using as the number  of values are unknown at this stage */
        ArrayList<String> parsedLine = new ArrayList<String>();
        int len = line.length();
        int i = 0;

        /** iterate through all the chars in the line */
        while (i < len) {
            int nextSep = len;
            /** Get the next separator */
            for (int j = 0; j < separators.length; ++j) {
                int temp = line.indexOf(separators[j], i);
                if ((temp == -1) || (temp >= nextSep))
                    continue;
                nextSep = temp;
            }

            /** Place the special separator at the end of the string */
            int nextSpecialSep = len;

            /** Check if there is any special separator */
            int temp = line.indexOf(specialChars, i);
            if ((temp == -1) || (temp >= nextSpecialSep))
                nextSpecialSep = len;
            else
                nextSpecialSep = temp;

            /** if we are at the special separator get the text until the next special separator */
            if (nextSpecialSep == i) {
                char c = line.charAt(i);
                /** check if there is any double quote chars in the text */
                int d = line.indexOf((c + "") + (c + ""), i + 1);

                /** if there are two double quota chars jump to the next one - are part of the text */
                int end = line.indexOf(c, d >= 0 ? d + 3 : i + 1);
                if (end == -1) {
                    end = len;
                }
                String toAdd = line.substring(i + 1, end);
                /** Replace two double quota with one double quota */
                toAdd = toAdd.replaceAll((c + "") + (c + ""), c + "");

                parsedLine.add(toAdd);
                i = end + 1;
            }
            /** if we are at a normal separator, ignore the separator and jump to the next char */
            else if (nextSep == i) {
                ++i;
            }
            /** Copy the value in the result string */
            else {
                parsedLine.add(line.substring(i, nextSep));
                i = nextSep;
            }
        }

        /** Convert the result to String[] */
        result = parsedLine.toArray(new String[parsedLine.size()]);
        return result;
    }


    /**
     * Method used to get fips of a country
     */

    public ArrayList<String[]> parser(String path) {

        BufferedReader br = null;
        int cpt = 0;
        ArrayList<String[]> result = new ArrayList<String[]>();
        try {

            br = new BufferedReader(new FileReader(path));

            /** Parsing each line in the file */
            String line = "";
            while ((line = br.readLine()) != null) {

                /** Parse each line into values */
                String[] values = lineParser(line);
                /** Adding the lines to the array list */

                result.add(values);

                cpt++;
            }
            System.out.println("Lecture du fichier POP.CSV réussie, Nombre de lignes lues est:" + cpt);
        } catch (Exception e) {
            /** Just display the error */
            e.printStackTrace();
        } finally {
            /** Closing the the stream */
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


}

	