package com.adrien.jeuxDeLaVie;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Editeur extends JFrame implements ActionListener {
	public static final int HAUTEUR = 500;
	public static final int LARGEUR = 500;
	public static final int POSITION_X = 0;
	public static final int POSITION_Y = 0;

	public final static int NUM_CELLULE_COLONNES = 5;
	public final static int NUM_CELLULE_LIGNES = 5;

	JButton start = new JButton("Lancer");

	private TableCoordonnee cellules = new TableCoordonnee(NUM_CELLULE_COLONNES);

	public Editeur() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(POSITION_X, POSITION_Y);
		setSize(LARGEUR, HAUTEUR);
		setResizable(true);
		setName(getName());

		JPanel grille = new JPanel();
		this.positionsDeDepart();
		for (int i = 0; i < cellules.size(); i++) {
			JButton b = ((CelluleButton) cellules.get(i)).getButton();
			b.addActionListener(this);
			add(b);
		}

		start.setBounds(200, 260, 100, 50);
		start.addActionListener(this);
		add(start);

		grille.setVisible(true);
		add(grille);
	}

	private void positionsDeDepart() {
		for (int i = 0; i < NUM_CELLULE_COLONNES; i++) {
			for (int j = 0; j < NUM_CELLULE_LIGNES; j++) {
				this.cellules.add(new CelluleButton(i, j, Color.white));
			}
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() != start) {
			JButton cellule = (JButton) e.getSource();
			Color c = cellule.getBackground();
			if (c == Color.white) {
				c = Color.black;
			} else {
				c = Color.white;
			}
			cellule.setBackground(c);
			// parcour le tableau de bouton pour le metre a jour
			for (int i = 0; i < cellules.size(); i++) {
				CelluleButton CB = ((CelluleButton) cellules.get(i));
				JButton b = CB.getButton();
				if (e.getSource() == b) {
					CB.setCouleur(c);
					cellules.set(i, CB);
				}
			}

		} else {
			for (int i = 0; i < cellules.size(); i++) {
				CelluleButton CB = ((CelluleButton) cellules.get(i));
				if (CB.getCouleur() == Color.black) {

				}
			}
			Frame frame = new Frame();
			frame.addSimu(cellules);
			frame.setVisible(true);
		}

	}
}
