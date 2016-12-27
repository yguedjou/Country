package com.InterfaceGraphique;

import javax.swing.*;

/**
 * Fenetre pour afficher une image à part
 *
 * @author Yasmine Guedjou
 * @since 24-12-2016
 */
public class FrameImage extends JFrame {

    // Variables statics permettant d'éviter que les fenetres s'affichent empilées
    private static int locationX = 50;
    private static int locationY = 500;

    // Le label qui va contenir l'image voulue
    private JLabel labelImage;

    /**
     * Ouvre une nouvelle fenetre sans s'empiler sur la précédente
     */
    public FrameImage() {
        super("FrameImage");

        this.setDefaultCloseOperation(HIDE_ON_CLOSE);

        labelImage = new JLabel();

        this.setLocation(locationX, locationY);
        locationX += 550;

        this.add(labelImage);
    }

    /**
     * Affiche l'image voulue dans la fenetre
     *
     * @param srcImage Le chemin de l'image à afficher
     * @param titre    Le titre de la fenetre
     */
    public void actualize(String srcImage, String titre) {
        this.setTitle(titre);
        this.labelImage.setIcon(new ImageIcon(srcImage));
        this.setVisible(true);
        this.pack();
    }
}
