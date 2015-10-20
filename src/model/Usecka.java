/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import gui.Platno;
import java.awt.image.BufferedImage;

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
    
    public Usecka(double x1, double y1, double x2,double y2){
	this.x1 = x1;
	this.y1 = y1;
	this.x2 = x2;
	this.y2 = y2;
    }
    public Usecka(Platno platno)    {
	this.platno = platno.getPlatno();
    }
// Triviální algoritmus

    double dx = x2 - x1;
    double dy = y2 - y1;

    if (Math.abs(y2 - y1) >= Math.abs(x2 - x1)) {

    if ((x1 == x2) && (y1 == y2)) {
        drawPixel(x1, y1, barva);

    } else {
        if (y2 < y1) {
            double tmp = x2;
            x2 = x1;
            x1 = tmp;

            tmp = y2;
            y2 = y1;
            y1 = tmp;
        }

        double k = dx / (double) dy;
        double q = x1 - k * y1;

        for (double y = y1; y < y2; y++) {
            int x = (int) (k * y + q);
            drawPixel(x, y, barva);
        }
    }


} else {
    if (x2 < x1) {
        double tmp = x2;
        x2 = x1;
        x1 = tmp;

        tmp = y2;
        y2 = y1;
        y1 = tmp;
    }

    double k = dy / (double) dx;
    double q = y1 - k * x1;

    for (double x = x1; x < x2; x++) {
        int y = (int) (k * x + q);
        drawPixel(x, y, barva);
    }
}

}
