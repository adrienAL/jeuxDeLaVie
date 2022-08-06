package com.adrien.jeuxDeLaVie;

import javax.swing.JFrame;

public class Editeur extends JFrame {
	public static final int HAUTEUR = 500;
	public static final int LARGEUR = 500;
	public static final int POSITION_X = 0;
	public static final int POSITION_Y = 0;

	public Editeur() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(POSITION_X, POSITION_Y);
		setSize(LARGEUR, HAUTEUR);
		setResizable(true);
		setName(getName());

		Grille grille = new Grille();
		grille.setVisible(true);
		add(grille);

	}
}
