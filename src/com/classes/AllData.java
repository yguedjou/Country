package com.classes;

import com.Utils.CSV_CountryCodesParser;
import com.Utils.CSV_Pop_Parser;
import com.Utils.ParseCsv;
import com.Utils.XmlSource;

import java.util.ArrayList;

/**
 * Contient les données du programme<br/>
 * Le constructeur va extraire les données des fichiers
 *
 * @author Yasmine Guedjou
 * @since 05-12-2016
 */
public class AllData {

    // Le chemin du dossier des données CSV
    private static final String dossierDataCSV = "data/dataCSV/";
    // Le chemin du dossier des données graphiques
    private static final String dossierGraphics = "data/graphics/";
    // La liste de countries et les méthodes de recherches dessus
    private Countries countries;
    // Pour parser le fichier contenant les codes des pays
    private CSV_CountryCodesParser pCSV;
    // Pour parser le fichier XML avec les fips
    private XmlSource xmlsource = new XmlSource();

    /**
     * Extraits les données des fichiers
     */
    public AllData() {
        countries = new Countries();
        pCSV = new CSV_CountryCodesParser();
        this.extractCountryCode();
        this.extractPop();
        this.exctractArea();
        this.extractFlips_And_Paths();
    }

    /**
     * Extraits les codes des pays du fichier <i>country_codes_iso.csv</i> et remplis <i>countries</i>
     */
    private void extractCountryCode() {
        System.out.println("\n>>> Extraction country codes");
        ArrayList<String[]> codes = pCSV.parseCsvCodesToMap(dossierDataCSV + "country_codes_iso.csv");
        for (String[] codes_Country : codes) {
            Country c = new Country(codes_Country[0], codes_Country[1], codes_Country[2], codes_Country[3], codes_Country[4]);
            countries.addCountry(c);
        }
    }

    /**
     * Extraits les populations des pays du fichier <i>POP.csv</i> et remplis <i>countries</i>
     */
    private void extractPop() {
        System.out.println("\n>>> Extraction population");
        ArrayList<String[]> population = CSV_Pop_Parser.parser(dossierDataCSV + "POP.csv");
        int cpt = 0;
        for (String[] country_Pop : population) {
            if (country_Pop.length >= 4) { // si la ligne contient bien l'information de la population
                Country count = countries.search_By_ISO3_EcoName(country_Pop[0], country_Pop[2]);
                if (count != null) {
                    count.setPop(country_Pop[3].trim());
                    count.setEconomicName(country_Pop[2]);
                } else {
                    System.out.println("Pays non trouvé avec cet ISO: " + country_Pop[0] + " Le Nom Economique est: " + country_Pop[2]);
                    cpt++;
                }
            }
        }
        System.out.println(cpt + " pays non trouvés");
    }

    /**
     * Extrait les superficies du fichier <i>rawdata_2147.txt</i> et remplis <i>countries</i>
     */
    private void exctractArea() {
        System.out.println("\n>>> Extraction superficies");
        ArrayList<String[]> areas = ParseCsv.parseCsvCodesToMap(dossierDataCSV + "rawdata_2147.txt", "\t");
        int compt = 0;
        for (String[] areaCountry : areas) {
            Country c = countries.searchByEngName_EconomicName(areaCountry[1]);
            if (c != null) {
                c.setArea(areaCountry[2].trim());
            } else {
                System.out.println(areaCountry[1] + ": Pays Non trouvé");
                compt++;
            }
        }
        System.out.println("Nombre de pays non trouvés : " + compt);
    }

    /**
     * Extraits les chemins vers les drapeaux, et les chemins vers les maps locales et mondiales du fichier <i>sourceXML.xml</i> et remplis <i>countrie</i>
     */
    private void extractFlips_And_Paths() {
        System.out.println("\n>>> Extraction images");
        ArrayList<String[]> xmlInformation = xmlsource.parser(dossierGraphics + "flash_files/sourceXML.xml");
        for (String[] values : xmlInformation) {
            if (values.length >= 5) {
                Country c = countries.searByEnNameOnly(values[1]);
                if (c != null) {
                    c.setFlips(values[3]);
                    c.setRegion(values[5]);
                    c.setPathToMap(dossierGraphics + "maps/" + c.getFlips().toLowerCase() + "-map.gif");
                    c.setPathToflag(dossierGraphics + "flags/large/" + c.getFlips().toLowerCase() + "-lgflag.gif");
                    switch (c.getRegion()) {
                        case "Africa":
                            c.setPathToLocator(dossierGraphics + "locator/afr/" + c.getFlips().toLowerCase() + "_large_locator.gif");
                            break;
                        case "Central America":
                            c.setPathToLocator(dossierGraphics + "locator/afr/" + c.getFlips().toLowerCase() + "_large_locator.gif");
                            break;
                        case "Antartica":
                            c.setPathToLocator(dossierGraphics + "locator/ant/" + c.getFlips().toLowerCase() + "_large_locator.gif");
                            break;
                        case "Middle East":
                            c.setPathToLocator(dossierGraphics + "locator/mde/" + c.getFlips().toLowerCase() + "_large_locator.gif");
                            break;
                        case "Europe":
                            c.setPathToLocator(dossierGraphics + "locator/eur/" + c.getFlips().toLowerCase() + "_large_locator.gif");
                            break;
                        case "North America":
                            c.setPathToLocator(dossierGraphics + "locator/noa/" + c.getFlips().toLowerCase() + "_large_locator.gif");
                            break;
                        case "South America":
                            c.setPathToLocator(dossierGraphics + "locator/soa/" + c.getFlips().toLowerCase() + "_large_locator.gif");
                            break;
                        case "South Asia":
                            c.setPathToLocator(dossierGraphics + "locator/sas/" + c.getFlips().toLowerCase() + "_large_locator.gif");
                            break;
                        case "East Asia":
                            c.setPathToLocator(dossierGraphics + "locator/eas/" + c.getFlips().toLowerCase() + "_large_locator.gif");
                            break;
                        case "Oceania":
                            c.setPathToLocator(dossierGraphics + "locator/aus/" + c.getFlips().toLowerCase() + "_large_locator.gif");
                            break;
                        case "Central Asia":
                            c.setPathToLocator(dossierGraphics + "locator/cas/" + c.getFlips().toLowerCase() + "_large_locator.gif");
                            break;
                    }
                }
            }
        }
    }

    /**
     * @return La liste des pays
     */
    public Countries getCountries() {
        return countries;
    }
}

	
	
	
	
	
	



	
