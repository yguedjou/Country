package com.classes;

import java.util.ArrayList;
import java.util.HashMap;

import com.Utils.CSV_CountryCodesParser;
import com.Utils.CSV_Pop_Parser;
import com.Utils.ParseCsv;
import com.Utils.XmlSource;

public class AllData {
	private Countries countries = new Countries (); 
	// parse country code csv file 
	private CSV_CountryCodesParser pCSV = new CSV_CountryCodesParser ();
	// attribute to parse population csv file 
	private CSV_Pop_Parser popCsv = new CSV_Pop_Parser(); 
	// to parse area file 
	private ParseCsv areaCSV = new ParseCsv (); 
	// to parse xml file 
	private XmlSource xmlsource = new XmlSource();
	
	private static final String dossierDataCSV = "data/dataCSV/";
	private static final String dossierGraphics = "data/graphics/";
	
	
	/**
	 * Constructeur 
	 */
	public AllData () {
		this.extractCountryCode();
		this.extractPop();
		this.exctractArea();
		this.extractFlips_And_Paths();
	}
	
	
	
	/**
	 * Method used to exctract country code informations
	 */
	
	public void extractCountryCode () {
		/**create a Map of countries with country Codes */
		ArrayList<String[]> codes =  pCSV.parseCsvCodesToMap(dossierDataCSV+"country_codes_iso.csv");
		for (String[] codes_Country : codes) {
			Country c = new Country (codes_Country[0], codes_Country[1], codes_Country[2], codes_Country[3], codes_Country[4]);
			countries.addCountry(c);
		}  
		

		
	}
	
	
	
	/**
	 * Method used to extract population 
	 */
	
	public void extractPop() {
		int cpt=0; 
		ArrayList<String[]> population = popCsv.parser(dossierDataCSV+"POP.csv"); 
		for (String[] country_Pop : population  ) {
			int len= country_Pop.length; // ce test je dois le faire dans la classe de parsage 
			if (len >=4 ){ // si la ligne contient bien l'information de la population  
				Country count = countries.search_By_ISO3_EcoName(country_Pop[0], country_Pop[2]); 
					if (count != null) {
						count.setPop(country_Pop[3]);
						count.setEconomicName(country_Pop[2]);
						
					}else{ 
						System.out.println("Pays non trouvé avec cet ISO: "+ country_Pop[0]+" Nom Economique est: "+country_Pop[2]);
						cpt++; 
					}
					
			}
			
		}
		System.out.println(cpt);
		
		
		
	}
	
	
	
	/**
	 * Method used to extract area information 
	 * 
	 */

	public void exctractArea () {
		
		ArrayList<String[]> areas =  areaCSV.parseCsvCodesToMap(dossierDataCSV+"rawdata_2147.txt", "\t"); 
		int compt=0;
		for (String [] areaCountry : areas) {
			Country c = countries.searchByEngName_EconomicName(areaCountry[1]);
			if (c != null){
				c.setArea(areaCountry[2]);
			}else{
				System.out.println(areaCountry[1]+": Pays Non trouvé");
				compt++;
			}  
			
		}
		System.out.println("Nombre de pays non trouvés : "+compt);
		
		
	}
	
	 /**
	  * Method used to extract flag, local and map path's anf flips 
	  */
	public void extractFlips_And_Paths () {
		ArrayList<String []> xmlInformation = xmlsource.parser(dossierGraphics+"flash_files/sourceXML.xml"); 
		for (String [] values : xmlInformation) {
			if (values.length >= 5 ){
				Country c = countries.searByEnName(values[1]); 
				if (c != null ) {
					c.setFlips(values[3]);
					c.setRegion(values[5]);
					c.setPathToMap(dossierGraphics+"maps/"+c.getFlips()+"-map.gif");
					c.setPathToflag(dossierGraphics+"flags/large/"+c.getFlips().toLowerCase()+"-lgflag.gif");
				}
				else {
					//System.out.println("Pays non trouvé : "+values[0]);
				}
				
				
			}
		}
	}
	
	
	
	
	// getter
		public Countries getCountries() {
			
			return countries;
		}




}

	
	
	
	
	
	



	
