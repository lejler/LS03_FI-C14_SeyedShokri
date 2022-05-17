package de.oszimt.ls.aliendefence.model.persistenceDummy;

import java.util.ArrayList;
import java.util.List;

import de.oszimt.ls.aliendefence.model.Level;
import de.oszimt.ls.aliendefence.model.Target;
import de.oszimt.ls.aliendefence.model.persistence.ILevelPersistance;

public class LevelDummy implements ILevelPersistance {

	public int createLevel(String levelname, String backgroundUrl, long duration) {
		return 1;
	}

	public List<Level> readAllLevel() {
		List<Level> levels = new ArrayList<Level>();
		Level level1 = new Level();
		level1.setLevel_id(1);
		level1.setName("Level 1");
		level1.setBackgroundImage("background_1.jpg");
		level1.setDuration(10000);
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

		level1.setTargets(targets);
		levels.add(level1);
		Level level2 = new Level();
		level2.setLevel_id(2);
		level2.setName("Level 2");
		level2.setBackgroundImage("background_2.jpg");
		level2.setDuration(5000);
		level2.setTargets(targets);
		levels.add(level2);
		Level level3 = new Level();
		level3.setLevel_id(3);
		level3.setName("Level 3");
		level3.setBackgroundImage("background_10.jpg");
		level3.setDuration(10000);
		level3.setTargets(targets);
		levels.add(level3);
		return levels;
	}

	public void updateLevel(Level lvl) {

	}

	public void deleteLevel(int level_id) {

	}
}
