/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import model.Polygon;
import model.Usecka;
import model.Utvar;

/**
 *
 * @author pepek
 */
public class Okno extends JFrame {

    private JToolBar panel = new JToolBar();
    private JButton tlcUsecka = new JButton();
    private JButton tlcPolygon = new JButton();
    private Platno platno;
    private Utvar utvary;
    private boolean isUsecka; ///pozn

    public Okno() {
	setTitle("Uloha 1");
	setVisible(true);
	setSize(1024, 768);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new BorderLayout());

	panel.setLayout(new FlowLayout(FlowLayout.LEFT));
	add(panel, BorderLayout.NORTH);

	panel.add(tlcUsecka);
	tlcUsecka.setText("Usecka");
	panel.add(tlcPolygon);
	tlcPolygon.setText("Polygon");

	platno = new Platno(1024, 768);
	add(platno, BorderLayout.CENTER);

	pridatListener();

    }

    public static void main(String[] args)  {
	new Okno();
    }
    private void pridatListener() {
	ActionListener al = new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tlcUsecka) {
		    utvary = new Usecka(platno);
		    isUsecka = true; 
		}
		if (e.getSource() == tlcPolygon) {
		  // utvary = new Polygon(); 
		    isUsecka = false;
		}
	    }
	};
	MouseListener ml = new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1 && utvary != null) {
		    utvary.nastavZacatek(e.getX(), e.getY());
		    platno.pridejUtvar(utvary);
		    	}
	    }

	    @Override
	    public void mouseReleased(MouseEvent e) {
		if (!isUsecka) {
		    repaint();
		}
	    }
	};

	platno.addMouseMotionListener(new MouseMotionAdapter() {
	    public void mouseDragged(MouseEvent e) {
		if (isUsecka) {
		    utvary.nastavKonec(e.getX(), e.getY());
		    repaint();
		}
	    }
	});
	platno.addMouseListener(ml);
	tlcUsecka.addActionListener(al);
	tlcPolygon.addActionListener(al);
    }

}
