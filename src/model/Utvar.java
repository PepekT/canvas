/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;

/**
 *
 * @author pepek
 */
public interface Utvar {

    public void kresli(Graphics g);

    public void nastavZacatek(double x, double y);

    public void nastavKonec(double x, double y);
    
    
}
