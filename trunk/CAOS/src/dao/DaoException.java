package dao;

/**
 * DaoException is an unchecked exception that is thrown in the Data layer.
 * @author mlch
 */
//Note: This exception is never caught in the application.
public class DaoException extends RuntimeException {

	public DaoException(String message) {
		super(message);
	}
}
