package com.adrien.jeuxDeLaVie;

import java.awt.Color;

import javax.swing.JButton;

public class CelluleButton {
	// dimention des briques
	public static final int HAUTEUR = 20;
	public static final int LARGEUR = 20;

	// espace entre les briques
	public static final int BRIQUE_H_ESPACE = 1;
	public static final int BRIQUE_V_ESPACE = 1;

	// Attributs
	private int x, y;
	private Color couleur;
	private int coordonneeX, coordonneeY;
	private JButton button;

	// Constructeur
	public CelluleButton(int x, int y, Color couleur) {
		super();
		this.coordonneeX = x;
		this.coordonneeY = y;
		this.x = ((x + 1) * BRIQUE_V_ESPACE) + (x * LARGEUR) + 200;
		this.y = ((y + 1) * BRIQUE_H_ESPACE) + (y * HAUTEUR) + 100;
		this.couleur = couleur;
		this.button = new JButton();
		this.button.setBackground(couleur);
		this.button.setBounds(this.x, this.y, LARGEUR, HAUTEUR);
	}

	// toString pour vérification
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Brique [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(", couleur=");
		builder.append(couleur);
		builder.append("]");
		return builder.toString();
	}

	// Setteur et getteur
	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
		this.button.setBackground(couleur);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton b) {
		this.button = b;

	}
}
