package database;

import java.sql.*;

public class ConnessioneDatabase {

	// ATTRIBUTI
	private static ConnessioneDatabase instance = null;
	public static Connection connection = null;
	private final String nome = "postgres";
	private final String password = "12345";
	private final String url = "jdbc:postgresql://localhost:5432/RiftView";
	private final String driver = "org.postgresql.Driver";

	// COSTRUTTORE
	private ConnessioneDatabase() throws SQLException {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, nome, password);

		} catch (ClassNotFoundException ex) {
			System.out.println("Database Connection Creation Failed : " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	/**
	 * Gets instance.
	 *
	 * @return the instance
	 * @throws SQLException the sql exception
	 */
	public static Connection getInstance() throws SQLException {
		if (instance == null) {
			instance = new ConnessioneDatabase();
		} else if (instance.connection.isClosed()) {
			instance = new ConnessioneDatabase();
		}
		return connection;
	}
}