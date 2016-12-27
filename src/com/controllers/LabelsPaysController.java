package com.controllers;

import com.InterfaceGraphique.PaysSelection;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * <h1>com.controllers LabelNomController</h1>
 *
 * @author Erwan LBP
 * @version 1.0
 * @since 27-12-2016
 */
public class LabelsPaysController implements Observer {

    private JLabel labelNom;
    private JLabel labelPop;
    private JLabel labelDens;
    private JLabel labelSuperficie;

    private PaysSelection paysSelection;

    public LabelsPaysController(JLabel labelNom, JLabel labelPop, JLabel labelDens, JLabel labelSuperficie, PaysSelection paysSelection) {
        this.labelNom = labelNom;
        this.labelPop = labelPop;
        this.labelDens = labelDens;
        this.labelSuperficie = labelSuperficie;
        this.paysSelection = paysSelection;
    }

    @Override
    public void update(Observable observable, Object o) {
        labelDens.setText(""+paysSelection.getPays().getDensite());
        labelNom.setText(paysSelection.getPays().getFrName());
        labelPop.setText(paysSelection.getPays().getPop());
        labelSuperficie.setText(paysSelection.getPays().getArea());
    }
}
