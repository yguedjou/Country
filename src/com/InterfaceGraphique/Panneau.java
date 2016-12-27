package com.InterfaceGraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class Panneau extends JPanel  { 
	
	private BufferedImage img;
	private static final long serialVersionUID = 1L;
	public void paintComponent ( Graphics g ) {	
		
		this.setSize(900,600);
		this.setBackground(Color.red);
		g.drawImage(img, 0,0 , null);
	}  
	
	
	public BufferedImage setImg (String path ) throws IOException{
		this.img = ImageIO.read(new File(path));
		return img; 
	}
	



}