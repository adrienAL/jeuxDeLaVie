package com.adrien.jeuxDeLaVie;

import java.awt.Color;
import java.awt.Graphics;

public class Cellule {

	// dimention des briques
	public static final int HAUTEUR = 10;
	public static final int LARGEUR = 10;

	// espace entre les briques
	public static final int BRIQUE_H_ESPACE = 1;
	public static final int BRIQUE_V_ESPACE = 1;

	// Attributs
	private int x, y;
	private Color couleur;
	private int coordonneeX, coordonneeY;

	// Constructeur
	public Cellule(int x, int y, Color couleur) {
		super();
		this.coordonneeX = x;
		this.coordonneeY = y;
		this.x = ((x + 1) * BRIQUE_V_ESPACE) + (x * LARGEUR);
		this.y = ((y + 1) * BRIQUE_H_ESPACE) + (y * HAUTEUR);
		this.couleur = couleur;
	}

	// toString pour vérification
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cellule [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(", couleur=");
		builder.append(couleur);
		builder.append(", coordonneeX =");
		builder.append(coordonneeX);
		builder.append(", coordonneeY =");
		builder.append(coordonneeY);
		builder.append("]");
		return builder.toString();
	}

	// Méthode
	public void draw(Graphics g) {
		g.setColor(couleur);
		g.fillRect(this.x, this.y, LARGEUR, HAUTEUR);
	}

	// Setteur et getteur
	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
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

}
