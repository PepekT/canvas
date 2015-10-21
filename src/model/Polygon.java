/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Baf
 *
 * @author pepek
 */
public class Polygon implements Utvar {

    private int[] x, y;
    private List<Double> xList, yList;
    private int n;

    public Polygon(int[] x, int[] y, int n) {
	this.x = x;
	this.y = y;
	this.n = n;
    }

    public Polygon(List<Double> xList, List<Double> yList) {
	super();
	xList = new ArrayList<Double>();
	yList = new ArrayList<Double>();
    }

    @Override
    public void kresli(Graphics g) {
	int size = xList.size();
	x = new int[size];
	y = new int[size];
	n = size;

	for (int i = 0; i < size; i++) {
	    x[i] = (int) Math.round((xList.get(i)));
	    y[i] = (int) Math.round((yList.get(i)));
	}
	g.drawPolygon(x, y, n);
    }

    @Override
    public void nastavZacatek(double x, double y) {
	xList.add(x);
	yList.add(y);
    }

    @Override
    public void nastavKonec(double x, double y) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
