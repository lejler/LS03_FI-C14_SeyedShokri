package de.oszimt.ls.aliendefence.controller;

import java.util.Vector;

import de.oszimt.ls.aliendefence.model.Level;
import de.oszimt.ls.aliendefence.model.persistence.IAttemptPersistance;
import de.oszimt.ls.aliendefence.model.persistence.IPersistance;

public class AttemptController {

	private IAttemptPersistance attemptPersistance;

	/**
	 * erstellt ein neues Objekt eines AttemptController welches Attemptobjekte in
	 * der übergebenen Datenhaltung persisiert
	 * 
	 * @param alienDefenceModel.getAttemptDB()
	 *            Persistenzklasse der Attemptobjekte
	 */
	public AttemptController(IPersistance alienDefenceModel) {
		this.attemptPersistance = alienDefenceModel.getAttemptPersistance();
	}

	public Vector<Vector<String>> getAllAttemptsPerLevel(Level level, int game_id) {
		return attemptPersistance.getAllAttemptsPerLevel(level, game_id);
	}

	public int getPlayerPosition() {
		return attemptPersistance.getPlayerPosition();
	}

	public void deleteHighscore(int level_id) {
		attemptPersistance.deleteHighscore(level_id);
	}

	/**
	 * calculates points from attempt for highscore TODO create formula here
	 * 
	 * @param level Levelobjekt
	 * @param hitcounter Controllerobjekt das die Treffer und Reaktionszeiten misst
	 * @return points 
	 */
	public int calculatePoints(Level level, HitCounter hitcounter) {
		return -1;
	}
}
