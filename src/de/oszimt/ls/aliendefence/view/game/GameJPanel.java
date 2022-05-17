package de.oszimt.ls.aliendefence.view.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.oszimt.ls.aliendefence.controller.GameController;
import de.oszimt.ls.aliendefence.model.Target;
import pictures._Res;

@SuppressWarnings("serial")
public class GameJPanel extends JPanel {

	// Attribute die zum Zeichnen aus dem Controller geholt werden müssen (konkrete
	// Objekte erst in init() erzeugen)
	private GameController gc;
	private MouseClickListener mouseClickListener;
	private List<TargetPainter> rechteckePainter;
	private BufferedImage img, win, lose;
	private JLabel lblTimeleft;

	public GameJPanel(GameController gc) {
		super(); // do the JPanel-stuff
		this.gc = gc;
		this.mouseClickListener = new MouseClickListener(gc);
		this.addMouseListener(this.mouseClickListener);
		this.lblTimeleft = new JLabel(gc.timeleft() + "s");
		this.lblTimeleft.setHorizontalAlignment(SwingConstants.RIGHT);
		this.lblTimeleft.setBounds(1000, 10, 200, 40);
		this.lblTimeleft.setFont(new Font("Comic Sans Serif", Font.BOLD, 30));
		init();

	}

	/**
	 * Spielfläche initialisieren
	 */
	public void init() {
			this.img = _Res.bimage(this.gc.getCurrLevel().getBackgroundImage());
			this.win = _Res.bimage("YouWin.png");
			this.lose = _Res.bimage("YouLoose.png");

		LinkedList<TargetPainter> rechteckePainter = new LinkedList<TargetPainter>();
		for (Target t : gc.getTargets()) {
			rechteckePainter.add(new TargetPainter(t));
		}
		this.rechteckePainter = rechteckePainter;
	}

	@Override
	public void paintComponent(Graphics g) {

		// Abfrage Gewinn oder
		if (gc.timeleft() <= 0 || gc.isHasWon()) {

			g.setColor(Color.GRAY);
			if (gc.isHasWon()) {
				g.drawImage(this.win, 300, 120, null);
			} else {
				g.drawImage(this.lose, 300, 120, null);
			}
			g.setFont(new Font("Arial", Font.PLAIN, 16));
			// g.drawString(gc.getShotsFired() + " Schüsse mit " + gc.getAccuracy() + " %
			// Treffergenauigkeit", 300, 850);

		} else {

			// Spielfeldhintergrund zeichnen
			if (img != null) {
				g.drawImage(this.img, 0, 0, null);
			} else {
				g.setColor(Color.GREEN);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
			}

			// System.out.println(gc.time());
			// Targets zeichnen
			for (TargetPainter rp : this.rechteckePainter) {
				rp.paint(g, gc.time());
			}

			// Sekundenanzeige
			if (gc.timeleft() <= 5)
				g.setColor(Color.RED);
			else
				g.setColor(Color.WHITE);
			g.setFont(new Font("Comic Sans Serif", Font.PLAIN, 30));
			g.drawString(gc.timeleft() + "", 1210, 40);

		}
	}
}
