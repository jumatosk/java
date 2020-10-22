package br.edu.ifba.ads.inf008.monitoring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifba.ads.inf008.monitoring.entities.Euclidean;
import br.edu.ifba.ads.inf008.monitoring.entities.Manhattan;
import br.edu.ifba.ads.inf008.monitoring.entities.Unity;
import br.edu.ifba.ads.inf008.monitoring.exception.UnityException;

public class UnitySQLDAO implements UnityDAOIF {
	private static final int EUCLIDEAN_UNITY = 0;
	private static final int MANHATTAN_UNITY = 1;

	private static final String DB_URI = "jdbc:mysql://localhost:3306/monitoring_system?useTimezone=true&serverTimezone=UTC";
	private static final String DB_USER = "root";
	private static final String DB_PWD = "";
	private static final String SAVE = "INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType)"
			+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_POSSIBLE = "SELECT id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType FROM unity"
			+ " WHERE videoCamera = ? AND thermomether = ? AND co2 = ? AND ch4 = ? AND available = true";
	private static final String GET_UNITY = "SELECT id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType FROM UNITY WHERE id = ?";
	public static final String GET_ALL = "SELECT * FROM UNITY";
	public static final String UPDATE_MONITORED = "UPDATE UNITY SET latitude = ?, longitude = ?, videoCamera = ?, "
			+ "thermomether = ?, co2 = ?, ch4 = ?, available = ? WHERE id = ?";
	public static final String UPDATE = "UPDATE UNITY SET latitude = ?, longitude = ?, videoCamera = ?, " 
			+ "thermomether = ?, co2 = ?, ch4 = ? WHERE id = ?";
	public static final String DELETE = "DELETE FROM UNITY WHERE id = ?";

	public UnitySQLDAO() throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URI, DB_USER, DB_PWD);
	}

	@Override
	public void save(Unity unity) throws Exception {
		PreparedStatement stmt = this.getConnection().prepareStatement(SAVE);

		stmt.setString(1, unity.getId());
		stmt.setFloat(2, unity.getPoint().getLatitude());
		stmt.setFloat(3, unity.getPoint().getLongitude());
		stmt.setBoolean(4, unity.isVideoCamera());
		stmt.setBoolean(5, unity.isThermomether());
		stmt.setBoolean(6, unity.isCo2());
		stmt.setBoolean(7, unity.isCh4());
		stmt.setBoolean(8, unity.isAvailable());

		if (unity instanceof Euclidean)
			stmt.setInt(9, EUCLIDEAN_UNITY);
		else if (unity instanceof Manhattan)
			stmt.setInt(9, MANHATTAN_UNITY);

		stmt.executeUpdate();
		stmt.close();
	}

	@Override
	public ArrayList<Unity> getAllPossibleUnity(boolean videoCamera, boolean thermomether, boolean co2, boolean ch4)
			throws Exception {
		ArrayList<Unity> unities = new ArrayList<>();
		Unity unity = null;

		PreparedStatement stmt = this.getConnection().prepareStatement(GET_ALL_POSSIBLE);

		stmt.setBoolean(1, videoCamera);
		stmt.setBoolean(2, thermomether);
		stmt.setBoolean(3, co2);
		stmt.setBoolean(4, ch4);
		ResultSet rSet = stmt.executeQuery();

		while (rSet.next()) {
			unity = null;
			int tipo = rSet.getInt("unityType");

			if (tipo == EUCLIDEAN_UNITY) {
				unity = new Euclidean(rSet.getString("id"), rSet.getFloat("latitude"), rSet.getFloat("longitude"),
						rSet.getBoolean("videoCamera"), rSet.getBoolean("thermomether"), rSet.getBoolean("co2"),
						rSet.getBoolean("ch4"));
			} else if (tipo == MANHATTAN_UNITY) {
				unity = new Manhattan(rSet.getString("id"), rSet.getFloat("latitude"), rSet.getFloat("longitude"),
						rSet.getBoolean("videoCamera"), rSet.getBoolean("thermomether"), rSet.getBoolean("co2"),
						rSet.getBoolean("ch4"));
			}
			unities.add(unity);
		}

		return unities;
	}

	@Override
	public Unity getUnity(String id) throws Exception {
		Unity unity = null;
		PreparedStatement stmt = this.getConnection().prepareStatement(GET_UNITY);

		stmt.setString(1, id);
		ResultSet rSet = stmt.executeQuery();
		
		if (!rSet.next()) {
			throw new UnityException("Não há unidades disponíveis.");
		}

		if (rSet.next()) {
			int tipo = rSet.getInt("unityType");
		
			if (tipo == EUCLIDEAN_UNITY) {
				unity = new Euclidean(id, rSet.getFloat(2), rSet.getFloat(3), rSet.getBoolean(4), rSet.getBoolean(5),
						rSet.getBoolean(6), rSet.getBoolean(7));
			} else if (tipo == MANHATTAN_UNITY) {
				unity = new Manhattan(id, rSet.getFloat(2), rSet.getFloat(3), rSet.getBoolean(4), rSet.getBoolean(5),
						rSet.getBoolean(6), rSet.getBoolean(7));
			}

		}
		
		return unity;
	}

	@Override
	public void updateMonitored(Unity unity) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(UPDATE_MONITORED);

		stmt.setFloat(1, unity.getPoint().getLatitude());
		stmt.setFloat(2, unity.getPoint().getLongitude());
		stmt.setBoolean(3, unity.isVideoCamera());
		stmt.setBoolean(4, unity.isThermomether());
		stmt.setBoolean(5, unity.isCo2());
		stmt.setBoolean(6, unity.isCh4());
		stmt.setBoolean(7, !unity.isAvailable());
		stmt.setString(8, unity.getId());

		stmt.executeUpdate();
		stmt.close();
	}
	
	@Override
	public void update(Unity unity) throws Exception {
		PreparedStatement stmt = this.getConnection().prepareStatement(UPDATE);

		stmt.setFloat(1, unity.getPoint().getLatitude());
		stmt.setFloat(2, unity.getPoint().getLongitude());
		stmt.setBoolean(3, unity.isVideoCamera());
		stmt.setBoolean(4, unity.isThermomether());
		stmt.setBoolean(5, unity.isCo2());
		stmt.setBoolean(6, unity.isCh4());
		stmt.setString(7, unity.getId());

		stmt.executeUpdate();
		stmt.close();
		
	}

	@Override
	public void delete(String id) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(DELETE);

		stmt.setString(1, id);

		stmt.executeUpdate();
		stmt.close();
	}

	@Override
	public ArrayList<Unity> getAll() throws Exception {
		ArrayList<Unity> unities = new ArrayList<>();
		Unity unity = null;

		PreparedStatement stmt = this.getConnection().prepareStatement(GET_ALL);
		ResultSet rSet = stmt.executeQuery();

		while (rSet.next()) {
			unity = null;
			int tipo = rSet.getInt("unityType");

			if (tipo == EUCLIDEAN_UNITY) {
				unity = new Euclidean(rSet.getString(1), rSet.getFloat(2), rSet.getFloat(3), rSet.getBoolean(4),
						rSet.getBoolean(5), rSet.getBoolean(6), rSet.getBoolean(7));
			} else if (tipo == MANHATTAN_UNITY) {
				unity = new Manhattan(rSet.getString(1), rSet.getFloat(2), rSet.getFloat(3), rSet.getBoolean(4),
						rSet.getBoolean(5), rSet.getBoolean(6), rSet.getBoolean(7));
			}

			unities.add(unity);
		}
		
		return unities;
	}

}
