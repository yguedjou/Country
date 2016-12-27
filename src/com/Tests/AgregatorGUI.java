package com.Tests;

import com.classes.AllData;
import com.classes.Country;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class AgregatorGUI extends JFrame {
    private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(800, 400);
    private AllData data = new AllData();
    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblNom;
    private JLabel lblDens;
    private JLabel lblSuper;
    private JLabel lblPopulation;


    public AgregatorGUI(String title) {
        super(title);
    }


    /**
     * Create the frame.
     */
    public AgregatorGUI() {

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setBounds(100, 100, 450, 300);
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // ComboBox Box for search
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(6, 24, 52, 27);
        comboBox.addItem("Recherche Par Nom");
        comboBox.addItem("Recharche Par Population");
        comboBox.addItem("Recherche Par Region");
        comboBox.addItemListener(new ItemState());
        contentPane.add(comboBox);
        // Jtext Field to enter what we are searching for
        textField = new JTextField();
        textField.setBounds(67, 23, 130, 26);
        contentPane.add(textField);
        textField.setColumns(10);


        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(224, 24, 52, 27);
        contentPane.add(comboBox_1);


        // il me manque un jtf


        // Jlabel to display Name
        lblNom = new JLabel("Nom");
        lblNom.setBounds(16, 63, 181, 40);
        contentPane.add(lblNom);

        // Jlabel to Display Densite
        lblDens = new JLabel("Densité");
        lblDens.setBounds(6, 242, 396, 16);
        contentPane.add(lblDens);
        // Jlabel to display Population
        lblPopulation = new JLabel("Population");
        lblPopulation.setBounds(6, 224, 396, 16);
        contentPane.add(lblPopulation);
        // Jlabel to display area
        lblSuper = new JLabel("Superficie");
        lblSuper.setBounds(6, 201, 396, 16);
        contentPane.add(lblSuper);
        setPreferredSize(IDEAL_MAIN_DIMENSION);
        this.pack();
        this.setVisible(true);


    }


    // inner class itemState

    public class ItemState implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            // TODO Auto-generated method stub
            if (e.getItem().equals("Recherche Par Nom")) {// if users choose search by name
                Country c = data.getCountries().searchByfrName(textField.getText());
                if (c != null) {
                    lblNom.setText(c.getFrName());
                    lblSuper.setText(c.getArea());
                    lblPopulation.setText(c.getPop());
                    lblDens.setText(c.getDensite());

                } else {
                    System.out.println("Nom introuvable");
                }

            }

        }

    }


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        new AgregatorGUI();
    }


}
