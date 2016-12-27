package com.InterfaceGraphique;

import javax.swing.*;

public class FrameDrapeau extends JFrame {

    private JLabel labelImage;

    public FrameDrapeau(String srcImage) {
        super("Drapeau : " + srcImage);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        labelImage = new JLabel(new ImageIcon(srcImage));

        this.add(labelImage);
        this.pack();
        this.setVisible(true);
    }
    
    public void actualize(String srcImage){
    	this.setTitle(srcImage);
    	this.labelImage.setIcon(new ImageIcon(srcImage));
    	this.repaint();
    	this.pack();
    }
}
