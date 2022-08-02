package com.adrien.jeuxDeLaVie;

import java.awt.Color;

import javax.swing.JFrame;

public class Frame extends JFrame {
	public static final int HAUTEUR = 850;
	public static final int LARGEUR = 2000;
	public static final int POSITION_X = 0;
	public static final int POSITION_Y = 0;

	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(POSITION_X, POSITION_Y);
		setSize(LARGEUR, HAUTEUR);
		setResizable(false);
		setName(getName());
		setBackground(Color.white);

		Simulation jeuxDeLaVie = new Simulation();
		add(jeuxDeLaVie);

	}

}
