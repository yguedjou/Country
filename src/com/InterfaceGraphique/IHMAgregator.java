package com.InterfaceGraphique;

import com.classes.AllData;
import com.classes.Country;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class IHMAgregator extends JFrame {
    private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(800, 400);
    /**       */
    private AllData data = new AllData();

    private JPanel search_Tri_Panel = new JPanel();
    private JPanel name_flag_Panel = new JPanel();
    private JPanel mapsPanel = new JPanel();
    private JPanel informationPanel = new JPanel();


    //Je saiis pas si j'en aurai besoin
    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblNom;
    private JLabel lblDens;
    private JLabel lblSuper;
    private JLabel lblPopulation;
    private JComboBox comboBox;
    private ImageIcon flag;
    private JLabel lblFlag;


    public IHMAgregator(String title) {
        super(title);
    }


    /**
     * Create the frame.
     */
    public IHMAgregator() {

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setBounds(100, 100, 450, 300);
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // ComboBox Box for search
        comboBox = new JComboBox();
        comboBox.setBounds(6, 24, 138, 27);
        comboBox.addItem("Recherche Par Nom");
        comboBox.addItem("Recharche Par Population");
        comboBox.addItem("Recherche Par Region");
        comboBox.addItemListener(new ItemState());
        contentPane.add(comboBox);
        // Jtext Field to enter what we are searching for
        textField = new JTextField();
        textField.setBounds(156, 23, 130, 26);
        contentPane.add(textField);
        textField.setColumns(10);


        // Second ComboBox to sort countries
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(367, 24, 130, 27);
        contentPane.add(comboBox_1);


        // il me manque un jtf


        // Jlabel to display Name
        lblNom = new JLabel("Nom");
        lblNom.setBounds(0, 84, 130, 16);
        contentPane.add(lblNom);


        // Jlabel to put on it the flag
        lblFlag = new JLabel("flag");
        lblFlag.setBounds(156, 69, 130, 49);
        contentPane.add(lblFlag);


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

        JButton btnGo = new JButton("Go");
        btnGo.addActionListener(new GetJtf());
        btnGo.setBounds(282, 24, 41, 27);
        contentPane.add(btnGo);

        // Afficher les images


        setPreferredSize(IDEAL_MAIN_DIMENSION);
        this.pack();
        this.setVisible(true);


    }


    // inner class

    public class ItemState implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            // TODO Auto-generated method stub

        }

        public String returnResult() {

            if (comboBox.getSelectedItem().toString().equals("Recherche Par Nom")) {
                return "0";

            } else {
                return "1";
            }

        }

    }

    public class GetJtf implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            ItemState itemState = new ItemState();
            if (itemState.returnResult() == "0") {
                Country c = data.getCountries().searchByfrName(textField.getText());
                if (c != null) {

                    lblNom.setText(lblNom.getText() + "\t" + c.getFrName());
                    lblSuper.setText(lblSuper.getText() + "\t" + c.getArea());
                    lblPopulation.setText(lblPopulation.getText() + "\t" + c.getPop());
                    lblDens.setText("Densité: " + "\t" + c.getDensite());
                    Icon image = new ImageIcon(c.getPathToflag());
                    lblFlag.setIcon(image);
                } else {
                    System.out.println("Pays Non existant");
                }


            } else {
                System.out.println("Rien faire pour le moment!");
            }


        }

    }


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        new IHMAgregator();
    }
}
