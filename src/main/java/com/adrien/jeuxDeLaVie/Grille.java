package com.adrien.jeuxDeLaVie;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Grille extends JPanel {
	public final static int NUM_CELLULE_COLONNES = 5;
	public final static int NUM_CELLULE_LIGNES = 5;

	private TableCoordonnee cellules = new TableCoordonnee(NUM_CELLULE_COLONNES);

	public Grille() {
		this.positionsDeDepart();
		this.setBackground(Color.black);
		this.setLocation(200, 150);
		this.setSize(106, 106);
	}

	private void positionsDeDepart() {
		for (int i = 0; i < NUM_CELLULE_COLONNES; i++) {
			for (int j = 0; j < NUM_CELLULE_LIGNES; j++) {
				this.cellules.add(new CelluleButton(i, j, Color.white));
			}
		}
	}

	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, 500, 500); // efface en repaint tout en blanc
		super.paintComponent(g);
		this.setLocation(190, 150);
		this.setSize(106, 106);
		for (int i = 0; i < cellules.size(); i++) {
			add(((CelluleButton) cellules.get(i)).draw(g));
		}
	}

}
