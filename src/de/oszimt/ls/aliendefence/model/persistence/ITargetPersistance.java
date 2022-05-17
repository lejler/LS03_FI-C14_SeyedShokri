package de.oszimt.ls.aliendefence.model.persistence;

import java.util.List;

import de.oszimt.ls.aliendefence.model.Target;

public interface ITargetPersistance {

	int createTarget(Target target, int level_id, int image_id);

	List<Target> readAllTargetsPerLevel(int level_id);

	void updateTarget(Target target);

	void deleteTarget(int target_id);

}