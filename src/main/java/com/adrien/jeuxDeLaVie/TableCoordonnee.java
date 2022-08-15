package com.adrien.jeuxDeLaVie;

import java.util.ArrayList;

public class TableCoordonnee extends ArrayList<Object> {
	private int NUM_CELLULE_COLONNES;

	public TableCoordonnee(int NUM_CELLULE_COLONNES) {
		super();
		this.NUM_CELLULE_COLONNES = NUM_CELLULE_COLONNES;
	}

	public Object getCoordonnee(int x, int y) {
		int c = y + NUM_CELLULE_COLONNES * x;
		return this.get(c);
	}

	public void setCoordonnee(int x, int y, Cellule cellule) {
		int c = y + NUM_CELLULE_COLONNES * x;
		cellule.setX(x);
		cellule.setY(y);
		this.set(c, cellule);
		System.out.println("TableauCoordonnée " + c);
		System.out.println("coordonnée x :" + x + " y : " + y);
	}
}
