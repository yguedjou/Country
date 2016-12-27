package com.classes;

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
    private String densite;

	
	
	
	/* Constructeur pour construire
	 * 
	 */


    public Country(String enName, String frName, String iso2, String iso3, String numeric) {
        super();
        this.enName = enName;
        this.frName = frName;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.numeric = numeric;
    }


    public String getArea() {
        return area;
    }


    public String getEnName() {
        return enName;
    }


    public void setEnName(String enName) {
        this.enName = enName;
    }


    public String getFrName() {
        return frName;
    }


    public void setFrName(String frName) {
        this.frName = frName;
    }


    public String getIso2() {
        return iso2;
    }


    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }


    public String getIso3() {
        return iso3;
    }


    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }


    public String getNumeric() {
        return numeric;
    }


    public void setNumeric(String numeric) {
        this.numeric = numeric;
    }


    public void setArea(String area) {
        this.area = area;
    }


    public String getPop() {
        return pop;
    }


    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getEngNameWithoutQuote() {
        String namesplit[] = enName.split("\\(");
        return namesplit[0];
    }


    public String getEconomicName() {
        return economicName;
    }


    public void setEconomicName(String economicName) {
        this.economicName = economicName;
    }


    @Override
    public String toString() {
        return "Country [enName=" + enName + ", frName=" + frName + ", iso2=" + iso2 + ", iso3=" + iso3 + ", numeric="
                + numeric + ", area=" + area + ", pop=" + pop + ", economicName=" + economicName + ", flips=" + flips
                + ", pathToMap=" + pathToMap + ", region=" + region + ", pathToflag=" + pathToflag + "]";
    }


    public String getDensite() {
        return densite;
    }


    public void setDensite(String densite) {
        this.densite = densite;
    }


    public String getRegion() {
        return region;
    }


    public String getPathToflag() {
        return pathToflag;
    }


    public void setPathToflag(String pathToflag) {
        this.pathToflag = pathToflag;
    }


    public void setRegion(String region) {
        this.region = region;
    }


    public String getFlips() {
        return flips;
    }


    public void setFlips(String flips) {
        this.flips = flips;
    }


    public String getPathToMap() {
        return pathToMap;
    }


    public void setPathToMap(String pathToMap) {
        this.pathToMap = pathToMap;
    }


}
