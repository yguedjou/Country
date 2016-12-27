package com.Tests;

import java.util.ArrayList;
import com.Utils.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.classes.AllData;
import com.classes.Countries;
import com.classes.Country;

public class ConsoleTest {

	public static void main(String[] args) {
		AllData data = new AllData(); 
		Scanner sca = new Scanner (System.in);
		System.out.println("Faites votre choix: 1:Tri, 2: Recherche");
		String modeRecherche = sca.nextLine().trim(); 
		switch (modeRecherche){
		case "1": // tri 
			data.getCountries().sortByFrName();
			; break;
		case "2": ; // recherche 
			Scanner sc = new Scanner(System.in); 
			System.out.println("Veuillez choisir votre mode de recherche, tapez: 1.Recherche par nom, 2.Recherche par région, 3. Recherche par population ");
			String typeRecherche = sc.nextLine().trim(); 
			switch (typeRecherche) {
			case "1": // recherche par nom
				System.out.println("Veuillez taper le nom[en français] du pays");
				Scanner scanner= new Scanner(System.in);
				String nomfrRecherche = scanner.nextLine().toLowerCase().trim(); 
				Country c = data.getCountries().searchByfrName(nomfrRecherche);
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
				Country popc = data.getCountries().searchByPopulation(populationRecherche);
				if (popc != null) {
					System.out.println(popc.toString());
				}else {
					System.out.println("Pays non trouvé");
				}; break; 
				default : System.out.println("Recherche  introuvable ");;break; 
			}
		break;
		
		
		
		
	
		default:System.out.println("Choix introuvable") ;break; 
		}
		
	}
}

