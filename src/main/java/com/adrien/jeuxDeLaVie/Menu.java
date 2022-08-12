package com.adrien.jeuxDeLaVie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu extends JFrame implements ActionListener {
	// create button
	private JButton planeur = new JButton("Planeur");
	private JButton L = new JButton("L");
	private JButton autre = new JButton("Autre");

	public static final int HAUTEUR = 500;
	public static final int LARGEUR = 500;
	public static final int POSITION_X = 0;
	public static final int POSITION_Y = 0;

	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(LARGEUR, HAUTEUR);
		setLayout(null);

		planeur.setBounds(200, 20, 100, 50);
		planeur.addActionListener(this);

		L.setBounds(200, 90, 100, 50);
		L.addActionListener(this);

		autre.setBounds(200, 160, 100, 50);
		autre.addActionListener(this);

		add(planeur);
		add(L);
		add(autre);

		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == planeur) {
			Frame frame = new Frame();
			frame.addSimu(1);
			frame.setVisible(true);
		} else if (e.getSource() == L) {
			Frame frame = new Frame();
			frame.addSimu(0);
			frame.setVisible(true);
		} else if (e.getSource() == autre) {
			Editeur editeur = new Editeur();
			editeur.setVisible(true);
		}

	}
}
