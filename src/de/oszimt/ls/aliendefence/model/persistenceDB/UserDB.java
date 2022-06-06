package de.oszimt.ls.aliendefence.model.persistenceDB;

import java.sql.*;

import de.oszimt.ls.aliendefence.model.User;
import de.oszimt.ls.aliendefence.model.persistence.IUserPersistance;
import de.oszimt.ls.aliendefence.model.persistenceDB.AccessDB;

/**
 * databaseconnection for userobjects, Story usermanagement
 * @author Clara Zufall
 */
public class UserDB implements IUserPersistance{

	private AccessDB dbAccess;

	public UserDB(AccessDB dbAccess) {
		this.dbAccess = dbAccess;
	}


	@Override
	public int createUser(User user) {
		String sql = "INSERT INTO users (firstname, sur_name, birthday, street, house_number, postal_code, city, login_name, password, salary_expectations, marital_status, final_grade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		int lastKey = -1;
		try (Connection con = DriverManager.getConnection(this.dbAccess.getFullURL(), this.dbAccess.getUser(),
				this.dbAccess.getPassword());
				PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			statement.setString(1, user.getFirst_name());
			statement.setString(2, user.getSur_name());
			statement.setObject(3, user.getBirthday());
			statement.setString(4, user.getStreet());
			statement.setString(5, user.getHouse_number());
			statement.setString(6, user.getPostal_code());
			statement.setString(7, user.getCity());
			statement.setString(8, user.getLoginname());
			statement.setString(9, user.getPassword());
			statement.setInt(10, user.getSalary_expectations());
			statement.setString(11, user.getMarital_status());
			statement.setDouble(12, user.getFinal_grade());

			ResultSet generatedKeys = statement.getGeneratedKeys();

			if (generatedKeys.next()) {
				lastKey = generatedKeys.getInt(1);
			}
			generatedKeys.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lastKey;
	}

	/**
	 * read userdata by unique username
	 * 
	 * @param username
	 * @return userobject, null if user didn't exists
	 */
	public User readUser(String username) {
		String sql = "SELECT * FROM users WHERE login_name = ? ;";
		User user = null;
		try (Connection con = DriverManager.getConnection(this.dbAccess.getFullURL(), this.dbAccess.getUser(),
				this.dbAccess.getPassword()); PreparedStatement statement = con.prepareStatement(sql)) {

			statement.setString(1, username);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				user = new User(rs.getInt("P_user_id"), rs.getString("first_name"), rs.getString("sur_name"),
						rs.getDate("birthday").toLocalDate(), rs.getString("street"), rs.getString("house_number"),
						rs.getString("postal_code"), rs.getString("city"), rs.getString("login_name"),
						rs.getString("password"), rs.getInt("salary_expectations"), rs.getString("marital_status"),
						rs.getBigDecimal("final_grade").doubleValue());
			}

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return user;
	}

	@Override
	public void updateUser(User user) {
		String sql = "UPDATE users SET first_name = ?, sur_name = ?, birthday = ?, street = ?, house_number = ?, postal_code = ?, city = ?, login_name = ?, password = ?, salary_expectations = ?, marital_status = ?, final_grade  = ? WHERE P_user_id = ?;";

		try (Connection con = DriverManager.getConnection(this.dbAccess.getFullURL(), this.dbAccess.getUser(),
				this.dbAccess.getPassword()); PreparedStatement statement = con.prepareStatement(sql)) {

			statement.setString(1, user.getFirst_name());
			statement.setString(2, user.getSur_name());
			statement.setObject(3, user.getBirthday());
			statement.setString(4, user.getStreet());
			statement.setString(5, user.getHouse_number());
			statement.setString(6, user.getPostal_code());
			statement.setString(7, user.getCity());
			statement.setString(8, user.getLoginname());
			statement.setString(9, user.getPassword());
			statement.setInt(10, user.getSalary_expectations());
			statement.setString(11, user.getMarital_status());
			statement.setDouble(12, user.getFinal_grade());
			statement.setInt(13, user.getP_user_id());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteUser(User user) {
		String sql = "DELETE FROM users WHERE P_user_id" + user.getP_user_id() + ";";
		try (Connection con = DriverManager.getConnection(this.dbAccess.getFullURL(), this.dbAccess.getUser(),
				this.dbAccess.getPassword()); Statement statement = con.createStatement()) {
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
