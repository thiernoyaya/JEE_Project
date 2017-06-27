package DAO;

import java.sql.Connection;

public abstract class DAO_JEE<T> {
	
protected Connection connect = null;
	
	public DAO_JEE(Connection conn){
		try {
			this.connect = conn;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public abstract boolean create(T obj);
	public abstract boolean delete(T obj);
	public abstract boolean update(T obj) throws Exception;

}
