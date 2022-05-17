package de.oszimt.ls.aliendefence.model.persistence;

import de.oszimt.ls.aliendefence.toDo.User;

public interface IUserPersistance {

	User readUser(String username);

}