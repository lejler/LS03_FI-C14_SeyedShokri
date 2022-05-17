package de.oszimt.ls.aliendefence.view;

import de.oszimt.ls.aliendefence.controller.AlienDefenceController;
import de.oszimt.ls.aliendefence.model.persistence.IPersistance;
import de.oszimt.ls.aliendefence.model.persistenceDummy.PersistanceDummy;
import de.oszimt.ls.aliendefence.view.menue.MainMenu;

public class StartAlienDefence {

	public static void main(String[] args) {
		
		IPersistance 		   alienDefenceModel      = new PersistanceDummy();//TODO new PersistanceDB();
		AlienDefenceController alienDefenceController = new AlienDefenceController(alienDefenceModel);
		MainMenu.show(alienDefenceController);
	}
}
