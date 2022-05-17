package de.oszimt.ls.aliendefence.model.persistenceDummy;

import java.util.ArrayList;
import java.util.List;

import de.oszimt.ls.aliendefence.model.Target;
import de.oszimt.ls.aliendefence.model.persistence.ITargetPersistance;

public class TargetDummy implements ITargetPersistance {

	public int createTarget(Target target, int level_id, int image_id) {
		return 1;
	}

	public List<Target> readAllTargetsPerLevel(int level_id) {
		List<Target> targets = new ArrayList<Target>();
		Target t1 = new Target(100, 100, 150, 50, 1000, 2000, "ufo_1.png");
		targets.add(t1);
		Target t2 = new Target(5, 100, 150, 50, 2000, 2000, "ufo_2.png");
		targets.add(t2);
		Target t3 = new Target(800, 800, 150, 50, 3000, 2000, "ufo_3.png");
		targets.add(t3);
		Target t4 = new Target(600, 400, 150, 50, 4000, 2000, "ufo_4.png");
		targets.add(t4);
		Target t5 = new Target(220, 400, 150, 50, 5000, 2000, "ufo_5.png");
		targets.add(t5);
		return targets;
	}

	public void updateTarget(Target target) {

	}

	public void deleteTarget(int target_id) {

	}

}
