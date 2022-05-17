package de.oszimt.ls.aliendefence.view.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.oszimt.ls.aliendefence.model.Target;
import pictures._Res;

public class TargetPainter {

	private Target target;
	private BufferedImage image;
	private BufferedImage imageDestroyed;

	public TargetPainter(Target target) {
		this.target = target;
		this.image = _Res.bimage(target.getImageAddress());
		this.imageDestroyed = _Res.bimage("explosion.png");

	}

	public void paint(Graphics g, long time) {

		long targetStartTime = target.getTime();
		long targetEndTime = target.getTime() + target.getDuration();

		// Prüft, ob das Target erscheint.
		if ((time < targetStartTime || time > targetEndTime))
			return;

		if (this.target.isHit() && time < targetEndTime) {

			g.drawImage(this.imageDestroyed, this.target.getHitbox().getX(), this.target.getHitbox().getY(),
					this.target.getHitbox().getWidth(), this.target.getHitbox().getHeight(), null);

			return;

		} 

		g.drawImage(this.image, this.target.getHitbox().getX(), this.target.getHitbox().getY(),
				this.target.getHitbox().getWidth(), this.target.getHitbox().getHeight(), null);
	}

}
