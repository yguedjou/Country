package com.controllers;

import com.classes.AllData;
import com.classes.Country;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>com.controllers TriController</h1>
 *
 * @author Erwan LBP
 * @version 1.0
 * @since 27-12-2016
 */
public class TriController implements ActionListener {
    private AllData data;
    private JComboBox<String> triPar;
    private JList<String> jListPays;

    public TriController(AllData data, JComboBox<String> triPar, JList<String> jListPays) {
        this.data = data;
        this.triPar = triPar;
        this.jListPays = jListPays;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        List<Country> countries = new ArrayList<>();

        //Tri par nom fr
        if (triPar.getSelectedIndex() == 0) {
            countries = data.getCountries().sortByFrName();
        }
        //Tri par population
        if (triPar.getSelectedIndex() == 1) {
            countries = data.getCountries().sortByPopulation();
        }
        // SI == 2 : Tri par Region
        DefaultListModel<String> modelListe = new DefaultListModel<>();
        if (countries.isEmpty())
            modelListe.addElement("Aucun pays trouvé");
        else {
            for (Country country : countries) {
                String cname = country.getFrName(), cpop = country.getPop(), carea = country.getArea();
                modelListe.addElement((cname == null ? "" : cname) + "; " + (cpop == null ? "" : cpop) + " hab.; " + (carea == null ? "" : carea) + " km²");
            }
        }
        jListPays.setModel(modelListe);
    }
}
