package com.adrien.jeuxDeLaVie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Simulation extends JPanel {
	public final static int NUM_CELLULE_COLONNES = 500;// (int) (Frame.LARGEUR / cellule.LARGEUR);
	public final static int NUM_CELLULE_LIGNES = 500;// (int) (Frame.HAUTEUR / cellule.HAUTEUR);

	private TableCoordonnee cellules = new TableCoordonnee(NUM_CELLULE_COLONNES);
	private Timer timer;
	private int position = 0;

	public Simulation() {
		this.positionsDeDepart();
		this.regleDeVie();

		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public Simulation(int position) {
		this.position = position;
		this.positionsDeDepart();
		this.regleDeVie();

	}

	private void positionsDeDepart() {
		for (int i = 0; i < NUM_CELLULE_COLONNES; i++) {
			for (int j = 0; j < NUM_CELLULE_LIGNES; j++) {
				this.cellules.add(new Cellule(i, j, Color.white));
			}
		}
		switch (position) {
		case 0:
			Cellule cellule = new Cellule(0, 0, Color.black);
			this.cellules.setCoordonnee(22, 22, cellule);
			this.cellules.setCoordonnee(22, 21, cellule);
			this.cellules.setCoordonnee(21, 23, cellule);
			this.cellules.setCoordonnee(20, 23, cellule);
			this.cellules.setCoordonnee(22, 20, cellule);
			break;

		default:
			break;
		}

	}

	public void regleDeVie() {
		timer = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// nouvelle liste de cellules
				TableCoordonnee newCellules = new TableCoordonnee(NUM_CELLULE_COLONNES);
				for (int i = 0; i < NUM_CELLULE_COLONNES; i++) {
					for (int j = 0; j < NUM_CELLULE_LIGNES; j++) {
						Cellule c = null;
						try {
							int index = (j) + NUM_CELLULE_COLONNES * i;
							c = cellules.get(index);
							Cellule newCellule = new Cellule(i, j, c.getCouleur());

							int nbrVoisin = 0;
							for (int ii = -1; ii <= 1; ii++) {
								for (int jj = -1; jj <= 1; jj++) {

									int indexVoisin = ((j + jj)) + NUM_CELLULE_COLONNES * (i + ii);
									if (indexVoisin >= 0 && indexVoisin < cellules.size()) {
										Cellule cVoisin = cellules.get(indexVoisin);
										if ((ii != 0 || jj != 0) && cVoisin.getCouleur() == Color.black) {
											nbrVoisin++;
										}
									}

								}
							}
							// test mort
							// une cellule vivante possédant deux ou trois
							// cellules voisines vivantes le reste, sinon elle meurt.
							if (nbrVoisin != 2 && nbrVoisin != 3 && c.getCouleur() == Color.black) {
								newCellule.setCouleur(Color.white);
								// test naissance
								// une cellule morte possédant exactement trois
								// cellules voisines vivantes devient vivante (elle naît)
							} else if (nbrVoisin == 3 && c.getCouleur() == Color.white) {
								newCellule.setCouleur(Color.black);
							}

							newCellules.add(newCellule);
						} catch (Exception e2) {

						}
					}
				}
				cellules = null;
				cellules = new TableCoordonnee(NUM_CELLULE_COLONNES);
				cellules.addAll(newCellules);
				repaint();
			}

		});
		timer.start();
	}

	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, 850, 2000); // efface en repaint tout en blanc
		for (int i = 0; i < cellules.size(); i++) {
			cellules.get(i).draw(g);
		}
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
