package de.oszimt.ls.aliendefence.controller;

import java.util.List;

import de.oszimt.ls.aliendefence.model.Level;
import de.oszimt.ls.aliendefence.model.persistence.ILevelPersistance;
import de.oszimt.ls.aliendefence.model.persistence.IPersistance;

public class LevelController {

	private final ILevelPersistance levelPersistance;
	public final String DEFAULT_LEVELNAME = "unnamed";
	public final String DEFAULT_BACKGROUND_PICTURE_URL = "background_1.jpg";
	public final long DEFAULT_DURATION = 90000L;

	/**
	 * erstellt ein neues Objekt eines LevelControllers, welche Levelobjekte der
	 * übergebenen Datenhaltung persistiert
	 * 
	 * @param alienDefenceModel
	 *            Persistenzklasse des gesamten Model
	 */
	public LevelController(IPersistance alienDefenceModel) {
		this.levelPersistance = alienDefenceModel.getLevelPersistance();
	}

	/**
	 * legt ein neues Level mit den Standardwerten an
	 * 
	 * @return Levelobjekt
	 */
	public Level createLevel() {
		int level_id = levelPersistance.createLevel(DEFAULT_LEVELNAME, DEFAULT_BACKGROUND_PICTURE_URL, DEFAULT_DURATION);
		return new Level(level_id);
	}

	/**
	 * gibt das konkrete Level zurück
	 * 
	 * @param level_id
	 * @return Levelobjekt oder null bei nicht vorhandener Level_id
	 */
	public Level readLevel(int level_id) {
		List<Level> levels = levelPersistance.readAllLevel();
		for (int i = 0; i < levels.size(); i++) {
			if (level_id == levels.get(i).getLevel_id()) {
				return levels.get(i);
			}
		}
		return null;
	}

	/**
	 * liest alle Level aus der DB
	 * 
	 * @return Levelliste
	 */
	public List<Level> readAllLevels() {
		return this.levelPersistance.readAllLevel();
	}

	/**
	 * validiert die ünderungen und speichert das Level ab
	 * 
	 * @param lvl
	 */
	public void updateLevel(Level lvl) {
		// TODO write Code to validate Level-Data
		levelPersistance.updateLevel(lvl);
	}

	/**
	 * lüscht ein Level aus der Datenhaltung
	 * 
	 * @param level_id
	 */
	public void deleteLevel(int level_id) {
		this.levelPersistance.deleteLevel(level_id);
	}

}
