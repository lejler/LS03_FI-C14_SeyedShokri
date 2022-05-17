package de.oszimt.ls.aliendefence.model.persistenceDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import de.oszimt.ls.aliendefence.model.Hitbox;
import de.oszimt.ls.aliendefence.model.Target;
import de.oszimt.ls.aliendefence.model.persistence.ITargetPersistance;

public class TargetDB implements ITargetPersistance {
	private AccessDB dbAccess;

	public TargetDB(AccessDB dbAccess) {
		super();
		if (dbAccess != null)
			this.dbAccess = dbAccess;
		else
			this.dbAccess = new AccessDB();
	}

	public int createTarget(Target target, int level_id, int image_id) {
		String sql = "INSERT INTO targets (F_level_id, image_address, x_position, y_position, width, height, time, duration) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		int lastKey = -1;
		try (Connection con = DriverManager.getConnection(this.dbAccess.getFullURL(), this.dbAccess.getUser(),
				this.dbAccess.getPassword());
				PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			statement.setInt(1, level_id);
			statement.setString(2, target.getImageAddress());		
			statement.setInt(3, target.getHitbox().getX());
			statement.setInt(4, target.getHitbox().getY());
			statement.setInt(5, target.getHitbox().getWidth());
			statement.setInt(6, target.getHitbox().getHeight());
			statement.setLong(7, target.getTime());
			statement.setLong(8, target.getDuration());
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

	public List<Target> readAllTargetsPerLevel(int level_id) {
		String sql = "SELECT * FROM targets WHERE F_level_id = ? ORDER BY P_target_id;";
		List<Target> alltargets = new Vector<Target>();

		try (Connection con = DriverManager.getConnection(this.dbAccess.getFullURL(), this.dbAccess.getUser(),
				this.dbAccess.getPassword()); PreparedStatement statement = con.prepareStatement(sql)) {

			statement.setInt(1, level_id);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Target target = new Target();
				target.setTarget_id(rs.getInt("P_target_id"));
				target.setHitbox(new Hitbox(rs.getInt("x_position"), rs.getInt("y_position"), rs.getInt("width"),
						rs.getInt("height")));
				target.setTime(rs.getLong("time"));
				target.setDuration(rs.getLong("duration"));
				target.setImageAddress(rs.getString("image_address"));
				
				alltargets.add(target);
			}

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return alltargets;
	}

	public void updateTarget(Target target) {
		 String sql = "UPDATE targets SET x_position = ?, y_position = ?, width = ?, height = ?, time = ?, duration = ?, image_address = ? WHERE P_target_id = ?;";
		 try (Connection con = DriverManager.getConnection(this.dbAccess.getFullURL(), this.dbAccess.getUser(),
				this.dbAccess.getPassword()); PreparedStatement statement = con.prepareStatement(sql)) {

			statement.setInt(1, target.getHitbox().getX());
			statement.setInt(2, target.getHitbox().getY());
			statement.setInt(3, target.getHitbox().getWidth());
			statement.setInt(4, target.getHitbox().getHeight());
			statement.setLong(5, target.getTime());
			statement.setLong(6, target.getDuration());
			statement.setString(7, target.getImageAddress());
			statement.setInt(8, target.getTarget_id());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTarget(int target_id) {
		String sql = "DELETE FROM targets WHERE P_target_id = " + target_id + ";";

		try (Connection con = DriverManager.getConnection(this.dbAccess.getFullURL(), this.dbAccess.getUser(),
				this.dbAccess.getPassword()); Statement statement = con.createStatement()) {
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}