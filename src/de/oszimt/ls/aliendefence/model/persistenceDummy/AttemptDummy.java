package de.oszimt.ls.aliendefence.model.persistenceDummy;

import java.util.Vector;

import de.oszimt.ls.aliendefence.model.Level;
import de.oszimt.ls.aliendefence.model.persistence.IAttemptPersistance;

/**
 * Klasse mit Dummywerten zum Testen der View und des Controllers
 * @author Tim Tenbusch
 *
 */
public class AttemptDummy implements IAttemptPersistance{

	public int createHighscoreEntry(int F_user_id, int F_level_id, int shots, int hits, long reaction_time) {
		// fleiüig speichern
		return 1;
	}

	public Vector<Vector<String>> getAllAttemptsPerLevel(Level level, int game_id) {
		Vector<Vector<String>> highscore = new Vector<Vector<String>>();
		Vector<String> eintrag1 = new Vector<String>();
		Vector<String> eintrag2 = new Vector<String>();
		eintrag1.addElement("1");
		eintrag2.addElement("2");
		eintrag1.addElement("Dummy Persistenz");
		eintrag2.addElement("Vorname Nachname");
		eintrag1.addElement("17.02.2021");
		eintrag2.addElement("18.02.2021");
		eintrag1.addElement("15:21");
		eintrag2.addElement("17:01");
		eintrag1.addElement("7");
		eintrag2.addElement("9");
		eintrag1.addElement("421");
		eintrag2.addElement("13");
		eintrag1.addElement("250");
		eintrag2.addElement("270");
		eintrag1.addElement("356");
		eintrag2.addElement("481");
		highscore.add(eintrag1);
		highscore.add(eintrag2);
		return highscore;
	}
	
	public int getPlayerPosition() {
		return 1;
	}
	
	public void deleteHighscore(int level_id) {
		//Omnomnom Anfrage gefressen
	}
}
