package daoDB;

import java.io.File;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

public class DB4OManager {
	private static DB4OManager instance = new DB4OManager();

	private ObjectContainer db;

	private DB4OManager() {
	}

	public static DB4OManager getInstance() {
		return instance;
	}

	public ObjectContainer getObjectContainer() {
		
		    
		if (db == null) {
			  new File ("HoSP1_0.db40").delete();
			Db4o.configure().updateDepth(5);
			db = Db4o.openFile("HoSP1_0.db40");
		}
		return db;
	}
}
