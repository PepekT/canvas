/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import gui.Platno;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

/**
 *
 * @author pepek
 */
public class Usecka implements Utvar {

    protected double x1;
    protected double y1;
    protected double x2;
    protected double y2;
    protected BufferedImage platno;

    public Usecka(Platno platno) {
	this.platno = platno.getPlatno();
    }
    @Override
    public void kresli(Graphics g) {
	double dx = x2 - x1;
	double dy = y2 - y1;
	int barva = 0x000000;
	vycistiPlatno();

	if (Math.abs(y2 - y1) >= Math.abs(x2 - x1)) {

	    if ((x1 == x2) && (y1 == y2)) {
		kresliPixel(x1, y1, barva);

	    } else {
		double k = (double) dx / dy;
		double q = x1 - k * y1;

		if (y1 >= y2) {
		    for (double y = y1; y >= y2; y--) {
			int x = (int) (k * y + q);
			kresliPixel(x, y, barva);
		    }
		} else {
		    for (double y = y1; y <= y2; y++) {
			int x = (int) (k * y + q);
			kresliPixel(x, y, barva);
		    }
		}
	    }

	} else {
	    double k = dy / (double) dx;
	    double q = y1 - k * x1;
	    if (x1 > x2) {

		for (double x = x1; x >= x2; x--) {
		    int y = (int) (k * x + q);
		    kresliPixel(x, y, barva);
		}
	    } else {
		for (double x = x1; x <= x2; x++) {
		    int y = (int) (k * x + q);
		    kresliPixel(x, y, barva);
		}
	    }
	}

	g.drawImage(platno, 0, 0, null);

    }

    @Override
    public void nastavZacatek(double x, double y) {
	x1 = x;
	y1 = y;
    }

    @Override
    public void nastavKonec(double x, double y) {
	x2 = x;
	y2 = y;
    }

    private void kresliPixel(double x1, double y1, int barva) {
	int _x1 = (int) Math.round(x1);
	int _y1 = (int) Math.round(y1);
	platno.setRGB(_x1, _y1, barva);
    }

    private void vycistiPlatno() {
	int color = Color.WHITE.getRGB();
	for (int x = 0; x < platno.getWidth(); x++) {
	    for (int y = 0; y < platno.getHeight(); y++) {
		platno.setRGB(x, y, color);
	    }
	}
    }
}
