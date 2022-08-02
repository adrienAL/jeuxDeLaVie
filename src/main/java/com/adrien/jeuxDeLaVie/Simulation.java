package com.adrien.jeuxDeLaVie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Simulation extends JPanel {
	public final static int NUM_BRIQUE_LIGNE = (int) (Frame.LARGEUR / Carre.LARGEUR);
	public final static int NUM_BRIQUE_COLONNES = (int) (Frame.HAUTEUR / Carre.HAUTEUR);

	private ArrayList<Carre> carres = new ArrayList<Carre>();
	private Timer timer;

	public Simulation() {
		for (int i = 0; i < NUM_BRIQUE_LIGNE; i++) {
			for (int j = 0; j < NUM_BRIQUE_COLONNES; j++) {
				if ((i == 30 && j == 30) || (i == 31 && j == 31) || (i == 30 && j == 32)) {
					this.carres.add(new Carre(i, j, Color.black));
				}
			}
		}

	}

	public void regleDeVie() {
		timer = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < NUM_BRIQUE_LIGNE; i++) {
					for (int j = 0; j < NUM_BRIQUE_COLONNES; j++) {

					}
				}
			}

		});
		timer.start();
	}

	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, 336, 500); // efface en repaint tout en blanc
		for (int i = 0; i < carres.size(); i++) {
			carres.get(i).draw(g);
		}
	}

}
