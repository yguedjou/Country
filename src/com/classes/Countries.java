package com.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import com.Utils.ParseCsv;

public class Countries {
	private HashMap<String, Country> countries = new HashMap<String, Country>();
	
	
	
	/**
	 * Method used to add a country to the arrayList 
	 * 
	 */
	
	public void addCountry (Country country) {
		countries.put(country.getIso3(), country); 
		
	}
		
	
	/**
	 * Method used to search by english name 
	 */
	
	
	public Country searByEnName(String engName) {
		 Collection<Country> values = countries.values(); 
		 for (Country c : values) {
			 if ( c.getEnName().contains(engName) ){
				 return c; 
			 }
			 
			 
		 }
		 return null; 
		
	}
	
	/**
	 * Method used to search by french name
	 */
	
	public Country searchByfrName (String frName){
		Collection<Country> values = countries.values(); 
		for (Country c : values) {
			 if ( c.getFrName().toLowerCase().trim().contains(frName.toLowerCase().trim())){
				 return c; 
			 }
		}
		return null;
	}
	
	/**Method used to sort countries by french name
	 * 
	 */
	public void sortByFrName (){
		Map<String, Country> noms = new TreeMap<>();
		for (Map.Entry<String,Country> pays : countries.entrySet()) {// je récupère la ligne 
            noms.put(pays.getValue().getFrName(), pays.getValue());
        }
		for (Map.Entry<String, Country> nomPays : noms.entrySet()) {
			System.out.println(nomPays.getValue().toString());
			System.out.println("\n");
	    }

		
	}
	
	/**
	 * Method used to search by population 
	 */
	public Country searchByPopulation (String pop) {
		HashMap<String, Country> populations = new HashMap<String, Country>(); 
		for (Map.Entry<String, Country> line : countries.entrySet()) {// je récupère la ligne 
            populations.put(line.getValue().getPop().trim(), line.getValue());
        }
		if (populations.containsKey(pop)) {
			return populations.get(pop);
		}
		return null; 
		
		
	}
	
	
	
	/**
	 * Method used to convert every single engName to Iso3
	 */
	
	public HashMap <String, Country> convertEnNameToISO3() {
		HashMap<String, Country>conversions= new HashMap<String, Country>(); 
		for (Map.Entry<String, Country> line : countries.entrySet()) {// je récupère la ligne 
            conversions.put(line.getValue().getEnName(), line.getValue());
        }
		return conversions; 
	}
	
	
	
	
	
	
	/**
	 * Method used to search a country by ISO3 or economic name
	 * @param iso3 
	 */
	
	public Country search_By_ISO3_EcoName(String iso3, String economicName) {
		if (( countries.containsKey(iso3))) {
			return (countries.get(iso3));
		} else{
			return this.searByEnName(economicName);
		}
		
	}
	
	/**
	 * Method used to search a country by ISO3
	 * @param iso3 
	 */
	
	public Country search_By_ISO3(String iso3) {
		if (countries.containsKey(iso3)){
			return countries.get(iso3);
		}
		return null;
	}
	
	
	
	
	
	/**
	 * Method used to search a country by engNma or Economic name 
	 * 
	 */
	
	public Country searchByEngName_EconomicName (String name) {
		Collection<Country> values = countries.values(); 
		 for (Country c : values) {
			 if ( ( c.getEnName().contains(name) )){
				 return c; 
			 }else if ( (c.getEconomicName() != null)  && (c.getEconomicName().contains(name))) {
				 return c; 
			 }
		 }
			 return null; 
	}
	
	
	
	
	/**
	 * Method used to return a treeMap
	 */
	
	public Map<String, Country> triEngName() {
		Map<String, Country> noms= new TreeMap<>(); 
		for (Map.Entry<String, Country> countries : countries.entrySet()) {
			noms.put(countries.getValue().getEnName(), countries.getValue());
		}
		return noms; 
	}
	
	
	
	
	@Override
	public String toString() {
		String lines= null; 
		Collection<Country> values = countries.values();
		for (Country country : values) {
			lines = lines + " \n \n \n"+ country.toString();
		}
		return lines; 	
	}
	 


	
		
		
		
}
