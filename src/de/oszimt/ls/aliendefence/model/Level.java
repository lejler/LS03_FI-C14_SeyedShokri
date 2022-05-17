package de.oszimt.ls.aliendefence.model;

import java.util.ArrayList;
import java.util.List;

public class Level {

	/** unique value */
	private int level_id;
	/** name of that level */
	private String name;
	/** List of Targets */
	private List<Target> targets;
	/** duration a level lasts im ms */
	private long duration;
	/** default duration for a level is 90s */
	public final long DEFAULT_DURATION = 90000L;	
	/** path to background image */
	private String backgroundImage;

	public Level() {
		this.targets = new ArrayList<Target>(100);
		this.name = "unnamed";
		this.duration = DEFAULT_DURATION;
		this.backgroundImage = "background_1.jpg";
	}

	public Level(int level_id) {
		this();
		this.level_id = level_id;
	}

	public int getLevel_id() {
		return this.level_id;
	}

	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Target> getTargets() {
		return this.targets;
	}

	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}

	public long getDuration() {
		return this.duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getBackgroundImage() {
		return backgroundImage;
	};

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public String[][] getTargetsAsTableModel() {
		String[][] result = new String[this.targets.size()][];
		int i = 0;
		for (Target t : this.targets) {
			result[i++] = t.getData();
		}
		return result;
	}

	public String[] getData() {
		return new String[] { "" + this.level_id, this.name, this.backgroundImage, "" + this.targets.size(),
				"" + this.duration };
	}

	public String toString() {
		return "Level [level_id=" + level_id + ", name=" + name + ", duration=" + duration + ", backgroundImage="
				+ backgroundImage + ", targets=" + targets + "]";
	}

	/** use this Level only for test porposes */
	public static Level getDefaultLevel() {
		Level level = new Level();
		// Objekte des Levels hier eintragen
		level.targets.add(new Target(100, 100, 75, 150, 0, 500000, "lemon.png"));
		level.targets.add(new Target(200, 100, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(300, 100, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(400, 100, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(500, 100, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(600, 100, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(700, 100, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(800, 100, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(900, 100, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(1000, 100, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(1100, 100, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(100, 300, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(200, 300, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(300, 300, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(400, 300, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(500, 300, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(600, 300, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(700, 300, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(800, 300, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(900, 300, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(1000, 300, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(1100, 300, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(100, 500, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(200, 500, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(300, 500, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(400, 500, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(500, 500, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(600, 500, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(700, 500, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(800, 500, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(900, 500, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(1000, 500, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(1100, 500, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(100, 700, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(200, 700, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(300, 700, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(400, 700, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(500, 700, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(600, 700, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(700, 700, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(800, 700, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(900, 700, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(1000, 700, 75, 150, 0, 500000, "ballon.png"));
		level.targets.add(new Target(1100, 700, 75, 150, 0, 500000, "ballon.png"));
		level.duration = 25000L;
		level.name = "DefaultTestLevel 001";
		level.level_id = 1;
		return level;
	}

	public static String[] getLevelDescriptions() {
		return new String[] { "Nr.", "Name", "Hintergrund", "Targets", "Dauer" };
	}
}
