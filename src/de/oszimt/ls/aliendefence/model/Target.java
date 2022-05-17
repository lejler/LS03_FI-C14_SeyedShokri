package de.oszimt.ls.aliendefence.model;

import java.util.Random;

public class Target {

	private int target_id;
	/** the area of a target */
	private Hitbox hitbox;
	/** time a target appears after game begins */
	private long time;
	/** time a target is able to hit */
	private long duration;
	private boolean hit;
	private String imageAddress;

	/** image of target */

	public Target() {
		super();
		this.target_id = 0;
		this.hitbox = new Hitbox(100, 100, 150, 50);
		this.time = 1000;
		this.duration = Long.MAX_VALUE;
		this.setHit(false);
		this.setImageAddress("ufo_1.png");
	}

	public Target(int x, int y, int width, int height, long time, long duration, String image) {
		super();
		this.target_id = 0;
		this.hitbox = new Hitbox(x, y, width, height);
		this.time = time;
		this.duration = duration;
		this.setHit(false);
		this.setImageAddress(image);
	}

	public Target(Hitbox hitbox, long time, long duration) {
		super();
		this.target_id = 0;
		this.hitbox = hitbox;
		this.time = time;
		this.duration = duration;
		this.setHit(false);
	}

	public int getTarget_id() {
		return target_id;
	}

	public void setTarget_id(int target_id) {
		this.target_id = target_id;
	}

	public Hitbox getHitbox() {
		return hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}

	public String getImageAddress() {
		return imageAddress;
	}

	public void setImageAddress(String imageAdress) {
		this.imageAddress = imageAdress;
	}

	public static Target getRandomTarget(int screenResolution_X, int screenResolution_Y) {
		Random rand = new Random();
		return new Target(rand.nextInt(screenResolution_X - 50), rand.nextInt(screenResolution_Y - 50), 350, 129, 0,
				90000, "ufo_4.png");
	}

	public String[] getData() {
		return new String[] { this.target_id + "", this.hitbox.getX() + "", this.hitbox.getY() + "",
				this.hitbox.getWidth() + "", this.hitbox.getHeight() + "", this.getImageAddress(), this.getTime() + "",
				this.getDuration() + "" };
	}

	public static String[] getTableDescriptions() {
		return new String[] { "Nr.", "X", "Y", "Breite", "Hühe", "Bild", "Startzeit", "Dauer" };
	}

	@Override
	public String toString() {
		return "Target [target_id=" + target_id + ", hitbox=" + hitbox + ", time=" + time + ", duration=" + duration
				+ ", hit=" + hit + ", imageAddress=" + imageAddress + "]";
	}

}
