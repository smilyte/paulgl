package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.SparePart;

public class SparePartDAO {
	private static SparePartDAO instance = null;
	
	//container for all spare parts
	private List<SparePart> spareParts = new ArrayList<SparePart>(); 
	
	private JdbcManager jdbcManager = JdbcManager.getInstance();
	
	
	private SparePartDAO() {}
	
	
	/**
	 * Return the one and only instance of the SparePartDAO class.
	 */
	public static SparePartDAO getInstance() {
		if (instance == null)
			instance = new SparePartDAO();
		return instance;
	}
	
	//.........................................................
	/**
	 * Adds an object of SparePart
	 */
	public void add(SparePart sparePart) {
		spareParts.add(sparePart);
	}

	/**
	 * Updates an object of Spare Part
	 */
	public void update(SparePart sparePart){
		// nothing to do.

	}

	/**
	 * Deletes an object of Spare Part
	 */
	public void remove(SparePart sparePart) {
		spareParts.remove(sparePart);
	}
	
	/**
	 * Returns a list with all the spare parts in the database.
	 */
	public List<SparePart> getList() {
		List<SparePart> spareParts = new ArrayList<SparePart>();
		String sql = "SELECT s.amount,s.number  FROM SparePart s";
		
		try {
			Statement stmt = jdbcManager.getConnection().createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				int amount = res.getInt(1);
				int number = res.getInt(2);
				SparePart sp = new SparePart(number, amount);
				spareParts.add(sp);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DaoException("Unable to get all spare parts from database. Caused by: " + e);
		}
		
		return spareParts;
	}
}
