package de.oszimt.ls.aliendefence.controller;

import java.util.List;
import java.util.ListIterator;

import de.oszimt.ls.aliendefence.model.Level;
import de.oszimt.ls.aliendefence.model.Target;
import de.oszimt.ls.aliendefence.model.persistence.IPersistance;
import de.oszimt.ls.aliendefence.model.persistence.ITargetPersistance;

public class TargetController {

	private ITargetPersistance targetPersistance;

	/**
	 * erstellt ein neues Objekt eines TargetControllers welches Targetobjekte in
	 * der übergebenen Datenhaltung persisiert
	 * 
	 * @param alienDefenceModel
	 *            Persistenzklasse der Targetobjekte
	 */
	public TargetController(IPersistance alienDefenceModel) {
		this.targetPersistance = alienDefenceModel.getTargetPersistance();
	}

	/**
	 * fügt dem gewühlten Level ein neues Target hinzu
	 * 
	 * @param target
	 *            neues Ziel
	 * @param lvl
	 *            ausgewühltes Level
	 * @return -1 wenn die Operation nicht geklappt hat, sonst die Target_id des
	 *         neuen Ziels
	 */
	public Target createTarget(Level lvl) {
		Target target = new Target(600, 400, 150, 50, 1000, 1000, "ufo_3.png");
		int image_id = 1;
		int target_id = targetPersistance.createTarget(target, lvl.getLevel_id(), image_id);
		target.setTarget_id(target_id);
		lvl.getTargets().add(target);

		return target;
	}

	/**
	 * gibt alle Targets zu einem Level aus der Datenhaltung aus
	 * 
	 * @param level_id
	 *            eindeutige Nummer des Levels
	 * @return Liste mit Zielen des Levels
	 */
	public List<Target> readTargets(int level_id) {
		return this.targetPersistance.readAllTargetsPerLevel(level_id);
	}

	/**
	 * tauscht ein Target im Levelobjekt aus und persistiert die ünderungen
	 * 
	 * @param lvl
	 *            zu welchem Level das Target gehürt
	 * @param target
	 *            das zu ündernde Target
	 * @return true wenn das angegebene Target in der Liste gefunden wurde, false
	 *         wenn nicht
	 */
	public boolean updateTarget(Level lvl, Target target) {
		boolean success = false;
		// Target im Level austauschen
		ListIterator<Target> iterator = lvl.getTargets().listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().getTarget_id() == target.getTarget_id()) {
				iterator.set(target);
				success = true;
			}
		}
		// Target in der Persistenz ündern
		if (success) {
			this.targetPersistance.updateTarget(target);
		}
		return success;
	}

	/**
	 * lüscht ein Target aus dem Levelobjekt und persistiert die ünderungen
	 * 
	 * @param lvl
	 *            zu welchem Level das Target gehürt
	 * @param target
	 *            das zu lüschende Target
	 * @return true wenn das angegebene Target in der Liste gefunden wurde, false
	 *         wenn nicht
	 */
	public boolean deleteTarget(Level lvl, int target_id) {
		boolean success = false;

		ListIterator<Target> iterator = lvl.getTargets().listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().getTarget_id() == target_id) {
				iterator.remove();
				success = true;
			}
		}

		// Target in Persistenz lüschen
		if (success) {
			this.targetPersistance.deleteTarget(target_id);
		}

		return success;
	}

}
