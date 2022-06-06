package de.oszimt.ls.aliendefence.controller;

import de.oszimt.ls.aliendefence.model.User;
import de.oszimt.ls.aliendefence.model.persistence.IUserPersistance;

/**
 * de.oszimt.ls.aliendefence.controller for users
 * @author Clara Zufall
 */
public class UserController {

	private IUserPersistance userPersistance;
	
	public UserController(IUserPersistance userPersistance) {
		this.userPersistance = userPersistance;
	}

	/**
	 * fügt einen User nach Kontrolle, ob dieser User schon existiert, der Persistenzschicht hinzu
	 * @param user Userobjekt, das hinzugefügt werden soll
	 */
	public void createUser(User user) {
		if (user.getLoginname().equals(userPersistance.readUser(user.getLoginname()).getLoginname())) {
			//TODO Konsolenausgabe bisschen blöd
			System.out.println("User existiert bereits");
			return;
		}
		userPersistance.createUser(user);
	}
	
	/**
	 * liest einen User aus der Persistenzschicht und gibt das Userobjekt zurück
	 * @param username eindeutiger Loginname
	 * @param passwort das richtige Passwort
	 * @return Userobjekt, null wenn der User nicht existiert
	 */
	public User readUser(String username, String passwort) {
		if (userPersistance.readUser(username).getPassword().equals(passwort)) return userPersistance.readUser(username);
		return null;
	}

	//TODO was soll die Methode tun?
	public void changeUser(User user) {
		
	}

	/**
	 * löscht einen User aus der Persistenzschicht
	 * @param user User, der gelöscht werden soll
	 */
	public void deleteUser(User user) {
		userPersistance.deleteUser(user);
	}

	/**
	 * überprüft, ob das Passwort des Users mit dem aus der Persistenzschicht übereinstimmt
	 * @param username eindeutiger Loginname
	 * @param passwort Passwort
	 * @return boolean, true, wenn das Passwort richtig ist
	 */
	public boolean checkPassword(String username, String passwort) {
		return readUser(username, passwort).getLoginname().equals(username) && readUser(username, passwort).getPassword().equals(passwort);
	}
}
