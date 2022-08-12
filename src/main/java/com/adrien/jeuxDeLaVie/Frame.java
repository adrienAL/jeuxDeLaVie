package com.adrien.jeuxDeLaVie;

import java.awt.Color;

import javax.swing.JFrame;

public class Frame extends JFrame {
	public static final int HAUTEUR = 850;
	public static final int LARGEUR = 1500;
	public static final int POSITION_X = 0;
	public static final int POSITION_Y = 0;

	public Frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(POSITION_X, POSITION_Y);
		setSize(LARGEUR, HAUTEUR);
		setResizable(false);
		setName(getName());
		setBackground(Color.white);

	}

	public void addSimu(int numSimu) {
		Simulation jeuxDeLaVie = new Simulation();
		jeuxDeLaVie.setPositionDepart(numSimu);
		jeuxDeLaVie.start();
		add(jeuxDeLaVie);
	}

	public void addSimu(TableCoordonnee cellules) {

		Cellule cellule = new Cellule(0, 0, Color.black);
		Simulation jeuxDeLaVie = new Simulation();
		TableCoordonnee grille = jeuxDeLaVie.getCellules();
		for (int i = 0; i < cellules.size(); i++) {
			CelluleButton CB = (CelluleButton) cellules.get(i);
			if (CB.getCouleur() == Color.black) {
				grille.setCoordonnee(CB.getX(), CB.getY(), cellule);
			}
		}
		jeuxDeLaVie.setCellules(grille);
		System.out.println(jeuxDeLaVie);

		jeuxDeLaVie.start();
		add(jeuxDeLaVie);
	}

}
