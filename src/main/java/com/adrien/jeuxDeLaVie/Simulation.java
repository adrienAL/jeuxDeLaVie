package com.adrien.jeuxDeLaVie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Simulation extends JPanel {
	public final static int NUM_CARRE_COLONNES = 110;// (int) (Frame.LARGEUR / Carre.LARGEUR);
	public final static int NUM_CARRE_LIGNES = 110;// (int) (Frame.HAUTEUR / Carre.HAUTEUR);

	private ArrayList<Carre> carres = new ArrayList<Carre>();
	private Timer timer;
	private int test = 0;

	public Simulation() {
		for (int i = 0; i < NUM_CARRE_COLONNES; i++) {
			for (int j = 0; j < NUM_CARRE_LIGNES; j++) {
				if ((i == 51 && j == 50) || (i == 52 && j == 51) || (i == 52 && j == 52) || (i == 51 && j == 52)
						|| (i == 50 && j == 52)) {
					this.carres.add(new Carre(i, j, Color.black));
				} else {
					this.carres.add(new Carre(i, j, Color.white));
				}
			}
		}
		this.regleDeVie();

	}

	public void regleDeVie() {
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// nouvelle liste de carres
				ArrayList<Carre> newCarres = new ArrayList<Carre>();
				for (int i = 0; i < NUM_CARRE_COLONNES; i++) {
					for (int j = 0; j < NUM_CARRE_LIGNES; j++) {
						Carre c = null;
						try {
							int index = (j) + NUM_CARRE_COLONNES * i;
							c = carres.get(index);
							if (c.getCouleur() == Color.black) {
								// test mort
								// une cellule vivante poss�dant deux ou trois
								// cellules voisines vivantes le reste, sinon elle meurt.
								int nbrVoisin = 0;
								for (int ii = -1; ii <= 1; ii++) {
									for (int jj = -1; jj <= 1; jj++) {

										int indexVoisin = ((j + jj)) + NUM_CARRE_COLONNES * (i + ii);
										if (indexVoisin >= 0 && indexVoisin < carres.size()) {
											Carre cVoisin = carres.get(indexVoisin);
											if ((ii != 0 || jj != 0) && cVoisin.getCouleur() == Color.black) {
												nbrVoisin++;
											}
										}

									}
								}
								if (nbrVoisin != 2 && nbrVoisin != 3) {
									c.setCouleur(Color.white);
								}
							} else {

								// test naissance
								// une cellule morte poss�dant exactement trois
								// cellules voisines vivantes devient vivante (elle na�t)
								int nbrVoisin = 0;
								for (int ii = -1; ii <= 1; ii++) {
									for (int jj = -1; jj <= 1; jj++) {

										int indexVoisin = ((j + jj)) + NUM_CARRE_COLONNES * (i + ii);
										if (indexVoisin >= 0 && indexVoisin < carres.size()) {
											Carre cVoisin = carres.get(indexVoisin);
											if ((ii != 0 || jj != 0) && cVoisin.getCouleur() == Color.black) {
												nbrVoisin++;
											}
										}
									}
								}
								if (nbrVoisin == 3) {
									c.setCouleur(Color.black);
								}
							}
							newCarres.add(c);
						} catch (Exception e2) {

						}
					}
				}
				carres = newCarres;
				repaint();
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
