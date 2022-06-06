package de.oszimt.ls.aliendefence.model.persistence;

import de.oszimt.ls.aliendefence.model.User;

public interface IUserPersistance {

	int createUser(User user);
	User readUser(String username);
	void updateUser(User user);
	void deleteUser(User user);

}