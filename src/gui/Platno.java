package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import model.Utvar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pepek
 */
public class Platno extends JLabel {
    private List<Utvar> utvary = new ArrayList<Utvar>();

    BufferedImage platno;

    public Platno(int sirka, int vyska) {
	platno = new BufferedImage(sirka, vyska, BufferedImage.TYPE_INT_RGB);
	int barva = Color.WHITE.getRGB();
	for (int x = 0; x < sirka; x++) {
	    for (int y = 0; y < vyska; y++) {
		platno.setRGB(x, y, barva);
	    }
	}
	repaint();
    }
    @Override
    public void paint(Graphics g)  {
	super.paint(g);
	
	for(Utvar utvar : utvary)   {
	    try {
		utvar.kresli(g);
	    } catch (ArrayIndexOutOfBoundsException e) {
	    System.out.println("Varovani: Kreslite mimo platno!!!" +e);
	    }
	}
	
    }
    public void pridejUtvar(Utvar u){
		utvary.add(u);
	}
    public BufferedImage getPlatno()	{
	return platno;
    }
}
