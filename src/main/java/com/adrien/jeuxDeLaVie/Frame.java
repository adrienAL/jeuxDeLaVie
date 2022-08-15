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
			System.out.println(grille.getCoordonnee(CB.getX() - 201, CB.getY() - 101));
			if (CB.getCouleur() == Color.black) {
				grille.setCoordonnee(CB.getX() - 201, CB.getY() - 101, cellule);
				System.out.println("black : " + grille.getCoordonnee(CB.getX() - 201, CB.getY() - 101));
			}
		}
		jeuxDeLaVie.setCellules(grille);

		jeuxDeLaVie.start();
		add(jeuxDeLaVie);

		for (int i = 0; i < jeuxDeLaVie.getCellules().size(); i++) {
			Cellule CB = (Cellule) jeuxDeLaVie.getCellules().get(i);
			if (CB.getCouleur() == Color.black) {
				System.out.println(CB);
			}
		}
	}

}
