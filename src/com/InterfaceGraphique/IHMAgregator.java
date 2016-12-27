package com.InterfaceGraphique;

import com.classes.AllData;
import com.controllers.*;

import javax.swing.*;
import java.awt.*;

/**
 * La fenetre principale de l'application
 *
 * @author Yasmine Guedjou
 * @since 20-12-2016
 */
public class IHMAgregator extends JFrame {

    private AllData data = new AllData();

    private JPanel contentPane;

    private FrameImage frameLocator;
    private FrameImage frameDrapeau;
    private FrameImage frameMap;

    private JTextField rechercheTextField;
    private JComboBox<String> rechercheComboBox;
    private JButton rechercheBouton;
    private JComboBox<String> triComboBox;
    private JButton triBouton;

    private JPanel panelCentre;

    private JList<String> listePays;

    private JLabel lblNom;
    private JLabel lblDens;
    private JLabel lblSuper;
    private JLabel lblPopulation;

    private PaysSelection paysSelection;

    /**
     * Ouvre la fenetre principale
     */
    public IHMAgregator() {
        super("Pays du monde");
        contentPane = new JPanel(new BorderLayout());
        this.setContentPane(contentPane);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(50, 50);
        this.setResizable(false);

        // Le pays courant, s'il est mis à jour, ca met à jour les composants de la fenetre
        paysSelection = new PaysSelection();

        panelCentre = new JPanel(new GridLayout(1, 2));
        creerPanelInfosPays();
        creerListePays();
        contentPane.add(panelCentre, BorderLayout.CENTER);
        creerPanelActions();

        frameDrapeau = new FrameImage();
        frameMap = new FrameImage();
        frameLocator = new FrameImage();
        FramesImagesController fic = new FramesImagesController(paysSelection, frameDrapeau, frameMap, frameLocator);
        paysSelection.addObserver(fic);


        this.pack();
        this.setVisible(true);
    }

    /**
     * Démarre l'application graphique
     */
    public static void main(String[] args) {
        new IHMAgregator();
    }

    public void creerListePays() {

        DefaultListModel<String> modelListe = new DefaultListModel<>();
        modelListe.addElement("Aucun pays sélectionné");

        listePays = new JList<>(modelListe);
        listePays.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listePays.setSelectedIndex(0);
        listePays.addListSelectionListener(new ListeController(listePays, paysSelection, data));

        JScrollPane panelListePays = new JScrollPane();
        panelListePays.setViewportView(listePays);
        panelListePays.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        panelListePays.setPreferredSize(new Dimension(400, 600));
        panelCentre.add(panelListePays);
    }

    public void creerPanelInfosPays() {
        JPanel panelInfos = new JPanel(new GridLayout(4, 2));

        panelInfos.add(new JLabel("Nom : "));
        lblNom = new JLabel("-");
        panelInfos.add(lblNom);

        panelInfos.add(new JLabel("Densité : "));
        lblDens = new JLabel("-");
        panelInfos.add(lblDens);

        panelInfos.add(new JLabel("Population : "));
        lblPopulation = new JLabel("-");
        panelInfos.add(lblPopulation);

        panelInfos.add(new JLabel("Superficie"));
        lblSuper = new JLabel("-");
        panelInfos.add(lblSuper);

        LabelsPaysController lpc = new LabelsPaysController(lblNom, lblPopulation, lblDens, lblSuper, paysSelection);
        paysSelection.addObserver(lpc);
        panelCentre.add(panelInfos);
    }

    public void creerPanelActions() {

        JPanel panelRecherche = new JPanel();
        rechercheComboBox = new JComboBox<>();
        rechercheComboBox.addItem("Recherche Par Nom");
        rechercheComboBox.addItem("Recharche Par Population");
        panelRecherche.add(rechercheComboBox);
        rechercheTextField = new JTextField();
        rechercheTextField.setColumns(15);
        panelRecherche.add(rechercheTextField);
        rechercheBouton = new JButton("Rechercher");
        RechercheController rc = new RechercheController(data, paysSelection, rechercheTextField, rechercheComboBox);
        rechercheBouton.addActionListener(rc);
        panelRecherche.add(rechercheBouton);

        JPanel panelTri = new JPanel();
        triComboBox = new JComboBox<>();
        triComboBox.addItem("Tri par Nom Francais");
        triComboBox.addItem("Tri par Population");
        panelTri.add(triComboBox);
        triBouton = new JButton("Trier");
        triBouton.addActionListener(new TriController(data, triComboBox, listePays));
        panelTri.add(triBouton);

        JPanel panelActions = new JPanel(new GridLayout(2, 1));
        panelActions.add(panelRecherche);
        panelActions.add(panelTri);
        panelActions.setBorder(BorderFactory.createRaisedBevelBorder());

        contentPane.add(panelActions, BorderLayout.NORTH);
    }
}