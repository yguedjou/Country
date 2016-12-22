package com.Tests;

import java.util.ArrayList;
import com.Utils.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.classes.Countries;
import com.classes.Country;

public class ConsoleTest {

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		Countries countries = new Countries();
		// parse CODE_PAYS file 
		
		CSV_CountryCodesParser pCSV = new CSV_CountryCodesParser (); 
		/**create a Map of countries with country Codes */
		 ArrayList<String[]> codes =  pCSV.parseCsvCodesToMap("/Users/yasmine/Desktop/Preject_S3/country_codes_iso.csv"); 
		for (String[] codes_Country : codes) {
			Country c = new Country (codes_Country[0], codes_Country[1], codes_Country[2], codes_Country[3], codes_Country[4]);
			countries.addCountry(c);
		}  
		

		
		
		
		 /** Method used to parse Population csv file */
		 
		int cpt=0; 
		CSV_Pop_Parser popCsv = new CSV_Pop_Parser();  
		ArrayList<String[]> population = popCsv.parser("/Users/yasmine/Desktop/Preject_S3/POP.csv"); 
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

		
		/*Map<String, Country> triNames= countries.triEngName(); 
		for (Map.Entry<String, Country> names : triNames.entrySet()){
			System.out.println(names.getValue().toString()+"\n");
		}*/
		
		/***
		 * Method used to recover the information from CSV 
		 */
		
		
		
		
		
		
		
		
		
		
	
	 /** Method used to extract area information from csv file */
	 
		ParseCsv areaCSV = new ParseCsv (); 
		ArrayList<String[]> areas =  areaCSV.parseCsvCodesToMap("/Users/yasmine/Desktop/Preject_S3/rawdata_2147.txt", "\t"); 
		
		HashMap<String,Country> mapConversion= countries.convertEnNameToISO3();
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
	//
	
		
/******************************************************Monde console*************************************************************************/
	
		
/*
		Scanner sc = new Scanner(System.in); 
		System.out.println("Veuillez choisir votre mode de recherche, tapez: 1.Recherche par nom, 2.Recherche par région, 3. Recherche par population ");
		String typeRecherche = sc.nextLine().trim(); 
		switch (typeRecherche) {
		case "1": // recherche par nom
			System.out.println("Veuillez taper le nom[en français] du pays");
			Scanner scanner= new Scanner(System.in);
			String nomfrRecherche = scanner.nextLine().toLowerCase().trim(); 
			Country c = countries.searchByfrName(nomfrRecherche);
			if (c != null ){
				System.out.println(c.toString());
			}else {
				System.out.println("Pays non trouvé");
			}; break; 
		case "2" : ; break; 
		case "3" :
			System.out.println("Veuillez taper la population");
			Scanner scanPop  = new Scanner (System.in);
			String populationRecherche = scanPop.nextLine().trim(); 
			Country popc = countries.searchByPopulation(populationRecherche);
			if (popc != null) {
				System.out.println(popc.toString());
			}else {
				System.out.println("Pays non trouvé");
			}; break; 
			
		default : System.out.println("Choix introuvable ");;break; 
		
		
		
		
		
		
			
		}
		String nomPaysEnRecherche = sc.nextLine().toUpperCase().trim();
		System.out.print(nomPaysEnRecherche);
		Country c = countries.search_By_ISO3(nomPaysEnRecherche);
		if (c != null){
			System.out.println(c.toString());
		}else {
			System.out.println("Error, ISO3 not found ");
		}
		
		
	
	
	*/
	}
}

