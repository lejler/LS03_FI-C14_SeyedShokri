package de.oszimt.ls.aliendefence.model.persistence;

public interface IPersistance {

	IAttemptPersistance getAttemptPersistance();
	ILevelPersistance getLevelPersistance();
	ITargetPersistance getTargetPersistance();
	IUserPersistance getUserPersistance();
	
}
