package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

public class dBase {

	private Connection connection;
	private Statement statement;
	private ResultSet results = null;
	@SuppressWarnings("unused")
	private String query;

	public void createConn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/BOOK_MY_DOC", "root", "");
		statement = connection.createStatement();
	}

	public ResultSet executeQuery(String q) throws SQLException {
		//results = statement.executeQuery(q);

		String selectSQL = "SELECT name FROM users WHERE Id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setString(1, "1");
		results = preparedStatement.executeQuery();

		return results;
	}

	public int doUpdate(String query) throws Exception {
		//int i = statement.executeUpdate(query);
		return 0;
	}

	public ResultSet getData(String query) throws Exception {
		results = statement.executeQuery(query);
		return results;
	}

	public int getRowCount(String query) throws Exception {
		int count = 0;
		/*results = statement.executeQuery(query);
		while (results.next()) {
			count++;
		}*/
		return count;
	}

	public void closeConn() throws SQLException {
		statement.close();
		connection.close();
	}
}
