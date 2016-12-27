package com.classes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Yasmine Guedjou
 * @since 06-12-2016
 */
public class Countries {
    private HashMap<String, Country> countries = new HashMap<>();

    /**
     * @param country Le pays à rajouter à la map des pays
     */
    public void addCountry(Country country) {
        countries.put(country.getIso3(), country);
    }

    /**
     * Recherche dans la liste des pays par le nom anglais
     *
     * @param engName Le nom anglais à chercher
     * @return Le pays correspondant, ou null si aucun résultat
     */
    public Country searByEnName(String engName) {
        Collection<Country> values = countries.values();
        for (Country c : values)
            if (c.getEnName().contains(engName))
                return c;
        return null;
    }

    /**
     * Recherche dans la liste des pays par le nom francais
     *
     * @param frName Le nom francais à chercher
     * @return Le pays correspondant, ou null si aucun résultat
     */
    public Country searchByfrName(String frName) {
        Collection<Country> values = countries.values();
        for (Country c : values)
            if (c.getFrName().toLowerCase().trim().contains(frName))
                return c;
        return null;
    }

    /**
     * Affiche la liste des pays triés par ordre croissant selon les noms francais
     */
    public void sortByFrName() {
        Map<String, Country> noms = new TreeMap<>();
        for (Map.Entry<String, Country> pays : countries.entrySet())
            noms.put(pays.getValue().getFrName(), pays.getValue());

        for (Map.Entry<String, Country> nomPays : noms.entrySet())
            System.out.println(nomPays.getValue() + "\n");
    }

    /**
     * Recherche dans la liste des pays par la population
     */
    public Country searchByPopulation(String pop) {
        HashMap<String, Country> populations = new HashMap<>();
        for (Map.Entry<String, Country> line : countries.entrySet())
            populations.put(line.getValue().getPop().trim(), line.getValue());
        if (populations.containsKey(pop))
            return populations.get(pop);

        return null;
    }

    /**
     * Recherche un pays par sa norme ISO3 ou par son nom économique
     *
     * @param iso3         La norme ISO3 à chercher
     * @param economicName Le nom économique à chercher
     * @return Le pays correspondant, ou null si aucun résultat
     */
    public Country search_By_ISO3_EcoName(String iso3, String economicName) {
        if ((countries.containsKey(iso3)))
            return (countries.get(iso3));
        else
            return this.searByEnName(economicName);
    }

    /**
     * Recherche un pays par son nom anglais ou par son nom économique
     *
     * @param name Le nom du pays à chercher
     * @return Le pays correspondant, ou null si aucun résultat
     */
    public Country searchByEngName_EconomicName(String name) {
        Collection<Country> values = countries.values();
        for (Country c : values) {
            if ((c.getEnName().contains(name)))
                return c;
            else if ((c.getEconomicName() != null) && (c.getEconomicName().contains(name)))
                return c;
        }
        return null;
    }

    /**
     * @return Une chaine decrivant le pays
     */
    @Override
    public String toString() {
        String lines = null;
        Collection<Country> values = countries.values();
        for (Country country : values)
            lines = lines + " \n \n \n" + country.toString();

        return lines;
    }
}
