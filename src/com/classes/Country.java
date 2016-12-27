package com.classes;

/**
 * Le modèle d'un pays du monde
 *
 * @author Yasmine Guedjou
 * @since 05-12-2016
 */
public class Country {

    private String enName;
    private String frName;
    private String iso2;
    private String iso3;
    private String numeric;
    private String area;
    private String pop;
    private String economicName;
    private String flips;
    private String pathToMap;
    private String region;
    private String pathToflag;
    private String pathToLocator;
    private String densite;

    /**
     * @param enName  Le nom anglais du pays
     * @param frName  Le nom francais du pays
     * @param iso2    La norme ISO2 du pays
     * @param iso3    La norme ISO3 du pays
     * @param numeric La valeur numérique du pays
     */
    public Country(String enName, String frName, String iso2, String iso3, String numeric) {
        super();
        this.enName = enName;
        this.frName = frName;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.numeric = numeric;
    }
	/**
     * @return La superficie du pays
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area La nouvelle superficie du pays
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return Le nom anglais du pays
     */
    public String getEnName() {
        return enName;
    }

    /**
     * @param enName Le nouveau nom anglais
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    /**
     * @return Le nom francais du pays
     */
    public String getFrName() {
        return frName;
    }

    /**
     * @param frName Le nouveau nom francais du pays
     */
    public void setFrName(String frName) {
        this.frName = frName;
    }

    /**
     * @return La norme ISO2 du pays
     */
    public String getIso2() {
        return iso2;
    }

    /**
     * @param iso2 La nouvelle norme ISO2 du pays
     */
    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    /**
     * @return La norme ISO3 du pays
     */
    public String getIso3() {
        return iso3;
    }

    /**
     * @param iso3 La nouvelle norme ISO3 du pays
     */
    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    /**
     * @return La valeur numérique du pays
     */
    public String getNumeric() {
        return numeric;
    }

    /**
     * @param numeric La nouvelle valeur numérique du pays
     */
    public void setNumeric(String numeric) {
        this.numeric = numeric;
    }

    /**
     * @return La population du pays
     */
    public String getPop() {
        return pop;
    }

    /**
     * @param pop La nouvelle population du pays
     */
    public void setPop(String pop) {
        this.pop = pop;
    }

    /**
     * @return Le nom économique du pays
     */
    public String getEconomicName() {
        return economicName;
    }

    /**
     * @param economicName Le nouveau nom économique du pays
     */
    public void setEconomicName(String economicName) {
        this.economicName = economicName;
    }

    /**
     * @return Une chaine decrivant le pays
     */
    @Override
    public String toString() {
        return "Country [enName=" + enName + ", frName=" + frName + ", iso2=" + iso2 + ", iso3=" + iso3 + ", numeric="
                + numeric + ", area=" + area + ", pop=" + pop + ", economicName=" + economicName + ", flips=" + flips
                + ", pathToMap=" + pathToMap + ", region=" + region + ", pathToflag=" + pathToflag + "]";
    }

    /**
     * @return La densité du pays
     */
    public String getDensite() {
        return densite;
    }

    /**
     * @param densite La nouvelle densité du pays
     */
    public void setDensite(String densite) {
        this.densite = densite;
    }

    /**
     * @return La région du pays
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region La nouvelle région du pays
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return Le chemin vers le fichier du drapeau
     */
    public String getPathToflag() {
        return pathToflag;
    }

    /**
     * @param pathToflag Le nouveau chemin vers le fichier du drapeau
     */
    public void setPathToflag(String pathToflag) {
        this.pathToflag = pathToflag;
    }

    /**
     * @return Le code flips du pays
     */
    public String getFlips() {
        return flips;
    }

    /**
     * @param flips Le nouveau code flips du pays
     */
    public void setFlips(String flips) {
        this.flips = flips;
    }

    /**
     * @return Le chemin vers le fichier de la map du pays
     */
    public String getPathToMap() {
        return pathToMap;
    }

    /**
     * @param pathToMap Le nouveau chemin vers le fichier de la map du pays
     */
    public void setPathToMap(String pathToMap) {
        this.pathToMap = pathToMap;
    }
    /**
     *@return Le chemin vers le fichier de la map de la region  du pays
     */
    public String getPathToLocator() {
		return pathToLocator;
	}
    /**
     * @param pathToMap  vers le fichier de la map de la region du pays
     */
    public void setPathToLocator(String pathToLocator) {
		this.pathToLocator = pathToLocator;
	}
    
    
    
}
