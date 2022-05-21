package de.oszimt.ls.aliendefence.model.persistenceDummy;

import java.time.LocalDate;

import de.oszimt.ls.aliendefence.model.persistence.IUserPersistance;
import de.oszimt.ls.aliendefence.model.User;

/**
 * Dummyklasse zum Testen
 * @author Tim Tenbusch
 *
 */
public class UserDummy implements IUserPersistance {

	public User readUser(String username) {
		return new User(1, "Dummy", "Persistenz", LocalDate.now(), "Dummystr.", "12C", "11111", "Nowhere", username, "pass", 12000, "gefangen", 1.58);
	}
	
}
