package com.InterfaceGraphique;

import javax.swing.*;

public class FrameImage extends JFrame {

    private JLabel labelImage;

    public FrameImage(String srcImage, String titre) {
        super(titre);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        labelImage = new JLabel(new ImageIcon(srcImage));

        this.add(labelImage);
        this.pack();
        this.setVisible(true);
    }
    
    public void actualize(String srcImage, String titre){
    	this.setTitle(srcImage);
    	this.labelImage.setIcon(new ImageIcon(srcImage));
    	this.repaint();
    	this.pack();
    }
}
