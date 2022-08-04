package com.adrien.jeuxDeLaVie;

import java.util.ArrayList;

public class TableCoordonnee extends ArrayList<Cellule> {
	private int NUM_CELLULE_COLONNES;

	public TableCoordonnee(int NUM_CELLULE_COLONNES) {
		super();
		this.NUM_CELLULE_COLONNES = NUM_CELLULE_COLONNES;
	}

	public Cellule getCoordonnee(int x, int y) {
		int c = x + NUM_CELLULE_COLONNES * y;
		return this.get(c);
	}

	public void setCoordonnee(int x, int y, Cellule cellule) {
		int c = x + NUM_CELLULE_COLONNES * y;
		cellule.setX(x);
		cellule.setY(y);
		this.set(c, cellule);
	}
}
