package de.oszimt.ls.aliendefence.model.persistenceDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import de.oszimt.ls.aliendefence.model.Level;
import de.oszimt.ls.aliendefence.model.persistence.ILevelPersistance;
import de.oszimt.ls.aliendefence.model.persistence.ITargetPersistance;

public class LevelDB implements ILevelPersistance {

	private AccessDB dbAccess;

	public LevelDB(AccessDB dbAccess) {
		this.dbAccess = dbAccess;
	}

	public int createLevel(String levelname, String backgroundUrl, long duration) {
		String sql = "INSERT INTO levels (name, background, duration) VALUES (?, ?, ?);";
			
		int lastKey = -1;
		try (Connection con = DriverManager.getConnection(this.dbAccess.getFullURL(), this.dbAccess.getUser(),
				this.dbAccess.getPassword());
				PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			statement.setString(1, levelname);
			statement.setString(2, backgroundUrl);
			statement.setLong(3, duration);

			statement.execute();

			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				lastKey = generatedKeys.getInt(1);
			}
			generatedKeys.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lastKey;
	}

	public List<Level> readAllLevel() {
		String sql = "SELECT * FROM levels ORDER BY P_level_id;";
		List<Level> allLevels = new Vector<Level>();

		try (Connection con = DriverManager.getConnection(this.dbAccess.getFullURL(), this.dbAccess.getUser(),
				this.dbAccess.getPassword());
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql)) {

			while (rs.next()) {

				Level level = new Level();
				level.setLevel_id(rs.getInt("P_level_id")); // ID von Level
				level.setName(rs.getString("name")); // Name von Level
				level.setDuration(rs.getInt("duration")); // Dauer von Level
				level.setBackgroundImage(rs.getString("background")); // Hintergrundsbild

				// Targets auslesen und dem Level hinzufügen
				ITargetPersistance targetDB = new TargetDB(this.dbAccess);

				level.setTargets(targetDB.readAllTargetsPerLevel(level.getLevel_id()));

				allLevels.add(level);
			}

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return allLevels;
	}

	public void updateLevel(Level lvl) {
		String sql = "UPDATE levels SET name = ?, background = ?, duration = ? WHERE p_level_id = ?;";

		try (Connection con = DriverManager.getConnection(this.dbAccess.getFullURL(), this.dbAccess.getUser(),
				this.dbAccess.getPassword()); PreparedStatement statement = con.prepareStatement(sql)) {

			statement.setString(1, lvl.getName());
			statement.setString(2, lvl.getBackgroundImage());
			statement.setLong(3, lvl.getDuration());
			statement.setInt(4, lvl.getLevel_id());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteLevel(int level_id) {
		String sql = "DELETE FROM levels WHERE P_level_id = " + level_id + ";";

		try (Connection con = DriverManager.getConnection(this.dbAccess.getFullURL(), this.dbAccess.getUser(),
				this.dbAccess.getPassword()); Statement statement = con.createStatement()) {

			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
