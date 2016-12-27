package com.controllers;

import com.InterfaceGraphique.PaysSelection;
import com.classes.AllData;
import com.classes.Country;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <h1>com.controllers RechercheController</h1>
 *
 * @author Erwan LBP
 * @version 1.0
 * @since 27-12-2016
 */
public class RechercheController implements ActionListener {
    private AllData data;
    private PaysSelection paysSelection;
    private JTextField rechercheTextField;
    private JComboBox<String> recherchePar;

    public RechercheController(AllData data, PaysSelection paysSelection, JTextField rechercheTextField, JComboBox<String> recherchePar) {
        this.data = data;
        this.paysSelection = paysSelection;
        this.rechercheTextField = rechercheTextField;
        this.recherchePar = recherchePar;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Country c = null;
        //Recherche par nom
        if (recherchePar.getSelectedIndex() == 0) {
            c = data.getCountries().searchByfrName(rechercheTextField.getText());
        }
        //Recherche par population
        if (recherchePar.getSelectedIndex() == 1) {
            c = data.getCountries().searchByPopulation(rechercheTextField.getText());
        }
        // SI == 2 : Recherche par Region

        if (c == null)
            rechercheTextField.setText("Recherche inconnue");
        else
            paysSelection.setPays(c);
    }
}
