package de.oszimt.ls.aliendefence.view.menue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import de.oszimt.ls.aliendefence.controller.AttemptController;
import de.oszimt.ls.aliendefence.model.Level;

public class Highscore extends JFrame {

	// Attribute
	private AttemptController attemptController;
	private Level level;

	public Highscore(AttemptController attemptController, Level level) {
		this(attemptController, level, 0);
	}

	// Konstruktor
	public Highscore(AttemptController attemptController, Level level, int game_id) {
		this.attemptController = attemptController;
		this.level = level;

		// Zweidimensioaler Vector, mit Inhalt der Tabelle wird geholt.
		Vector<Vector<String>> vecRow = attemptController.getAllAttemptsPerLevel(level, game_id);

		int mark = attemptController.getPlayerPosition();

		setLayout(new BorderLayout(5, 10));

		// Spaltenüberschriften
		Vector<String> title = new Vector<>();
		title.add("Rang");
		title.add("Spieler");
		title.add("Datum");
		title.add("Uhrzeit");
		title.add("Trefferwert");
		title.add("Genauigkeitswert");
		title.add("Reaktionswert");
		title.add("Highscore-Wert");

		// Tablle basierend auf zweidimensionalem Vector
		JTable table = new JTable(vecRow, title);
		if (mark >= 0)
			table.setRowSelectionInterval(mark, mark);
		setMinimumSize(new Dimension(650, 500));
		getContentPane().add(new JScrollPane(table), BorderLayout.NORTH);
		setTitle("Highscore-Liste"); // Titel
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);

		JButton btnZielndern = new JButton("Highscoreliste löschen");
		btnZielndern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAendern_Clicked(arg0);
			}
		});

		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnZielndern);

		// fügt Panel mit Button hinzu
		add(pnlSouth, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
	}

	public void btnAendern_Clicked(ActionEvent evt) {
		this.attemptController.deleteHighscore(level.getLevel_id());
		dispose();
	}
}