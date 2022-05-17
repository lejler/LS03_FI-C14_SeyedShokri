package de.oszimt.ls.aliendefence.model.persistence;

import java.util.List;

import de.oszimt.ls.aliendefence.model.Level;

public interface ILevelPersistance {

	/**
	 * legt in der Datenbank ein neues Level an
	 * 
	 * @return level_id für das neue Level
	 */
	int createLevel(String levelname, String backgroundUrl, long duration);

	/**
	 * gibt alle Level aus der Datenbank als Liste zurück
	 * 
	 * @return Liste aller Level
	 */
	List<Level> readAllLevel();

	/**
	 * aktualisiert die Daten eines Levels
	 * 
	 * @param lvl
	 *            ein Levelobjekt
	 */
	void updateLevel(Level lvl);

	/**
	 * lüscht ein Level aus der Datenbank
	 * 
	 * @param P_level_id
	 */
	void deleteLevel(int level_id);

}