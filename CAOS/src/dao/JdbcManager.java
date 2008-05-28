package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The JdbcManager class has a method to get a connection to the database and
 * methods to manage transactions.
 * @author mlch
 */
//Note: Methods in this class and methods in the dao classes will catch 
//any SQLException thrown. A DaoException (which is an unchecked exception) is thrown instead.
//In this application a DaoException is never caught (so any DaoException thrown will stop
//the application). 

class JdbcManager {
	private static JdbcManager instance = new JdbcManager();
	
	private String dbName = "jdb";
	private String dbUserName = "sa";
	private String dbPassword = "h353i62";

	private Connection conn = null;
	private boolean transactionActivated = false;

	private JdbcManager() {
	}

	/**
	 * Returns the one and only instance of the TransactionManager class.
	 */
	public static JdbcManager getInstance() {
		return instance;
	}

	/**
	 * Returns a connection to the database.
	 */
	public Connection getConnection() {
		if (conn == null) {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			} catch (ClassNotFoundException e) {
				throw new DaoException("SQL Server driver not found. Caused by: " + e);
			}
		}

		try {
			if (conn == null || conn.isClosed()) {
				String dbConnString = "jdbc:odbc:smileSql";
				conn = DriverManager.getConnection(dbConnString, dbUserName, dbPassword);
			}
		} catch (SQLException e) {
			throw new DaoException("Unable to open database connection. Caused by: " + e);
		}
		return conn;
	}

	/**
	 * Starts a new transaction (the actual transaction) and returns true.
	 * If a transaction is already started, the methods return false and does nothing.
	 */
	public boolean startTransaction() {
		if (transactionActivated)
			return false;

		try {
			getConnection();
			conn.setAutoCommit(false);
			transactionActivated = true;
			return true;
		} catch (SQLException e) {
			throw new DaoException("Unable to start database transaction. Caused by: " + e);
		}
	}

	/**
	 * Commits the actual transaction, if transactionStarter is true.
	 * The value of transactionStarter must be the value returned from the associated
	 * call of the startTransation() method. 
	 * If transactionStarter is false, the method does nothing.
	 */
	public void commitTransaction(boolean transactionStarter) {
		if (!transactionStarter)
			return;

		try {
			conn.commit();
			transactionActivated = false;
		} catch (SQLException e) {
			throw new DaoException("Unable to commit database transaction. Caused by: " + e);
		}
	}

	/**
	 * Ends the actual transaction, if transactionStarter is true.
	 * The value of transactionStarter must be the value returned from the associated
	 * call of the startTransaction() method.
	 * If transactionStarter is false, the method does nothing.
	 */
	public void endTransaction(boolean transactionStarter) {
		if (!transactionStarter)
			return;

		if (transactionActivated) {
			try {
				conn.rollback();
				transactionActivated = false;
			} catch (SQLException e) {
				throw new DaoException("Unable to rollback database transaction. Caused by: " + e);
			}
		}

		//If you make the code below into a comment, the connection to the database
		//will stay open as long as the the application is running. 
		//The application will then never close the connection to the database (so hopefully
		//your IDE, your OS or a timeout in the database will close the connection).
		//A disadvantage of keeping the code is that the application will open and close a new
		//connection for each transaction and therefore run a bit slower. 
		try {
			conn.close();
		} catch (SQLException e) {
			throw new DaoException("Unable to close database connection. Caused by: " + e);
		}
	}
}
