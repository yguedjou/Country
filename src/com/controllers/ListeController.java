package com.controllers;

import com.InterfaceGraphique.PaysSelection;
import com.classes.AllData;
import com.classes.Country;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * <h1>com.controllers ListeController</h1>
 *
 * @author Erwan LBP
 * @version 1.0
 * @since 27-12-2016
 */
public class ListeController implements ListSelectionListener {

    private JList<String> listPays;
    private PaysSelection paysSelection;
    private AllData data;

    public ListeController(JList<String> listPays, PaysSelection paysSelection, AllData data) {
        this.listPays = listPays;
        this.paysSelection = paysSelection;
        this.data = data;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        try {
            Country c = data.getCountries().searchByfrName(listPays.getSelectedValue().split(";")[0]);
            if (c != null)
                paysSelection.setPays(c);
        } catch (Exception ignored) {
        }
    }
}
