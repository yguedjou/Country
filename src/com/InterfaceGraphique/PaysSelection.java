package com.InterfaceGraphique;

import com.classes.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * <h1>InterfaceGraphique PaysSelectionne</h1>
 *
 * @author Erwan LBP
 * @version 1.0
 * @since 27-12-2016
 */
public class PaysSelection extends Observable {

    private Country pays;
    private List<Country> paysList;

    public PaysSelection() {
        paysList = new ArrayList<>();
        pays = new Country("null", "null", "null", "null", "null");
    }

    public Country getPays() {
        return pays;
    }

    public void setPays(Country pays) {
        this.pays = pays;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Country> getPaysList() {
        return paysList;
    }

    public void setPaysList(List<Country> paysList) {
        this.paysList = paysList;
    }
}
