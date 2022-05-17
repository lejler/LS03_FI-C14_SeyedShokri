package de.oszimt.ls.aliendefence.model.persistenceDB;

public class AccessDB {

	// Attribute
	private String dbName;
	private String user;
	private String password;
	private String url;

	// Konstruktor
	public AccessDB() {
		this.url = "jdbc:mysql://localhost:3306/";
		this.dbName = "alien_defence";
		this.user = "root";
		this.password = "";
	}

	// Getter und Setter
	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFullURL() {
		return this.url + this.dbName;
	}
}
