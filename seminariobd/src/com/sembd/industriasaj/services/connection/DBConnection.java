package com.sembd.industriasaj.services.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import org.apache.commons.dbcp.BasicDataSource;

public class DBConnection {

	private static BasicDataSource bds;
    private static Connection con;
    private static final String path = "com.sembd.industriasaj.services.connection.database";
    
	static{
		String urlDb = null;
		String usuarioDb = null;
		String passwordDb = null;
		String driver = null;
        String initialSize = null;
        String maxActive= null;
        String maxIdle= null;
        String maxWait= null;
        String validationQuery = null;
		try {
			ResourceBundle rb = ResourceBundle.getBundle(path);
            urlDb = rb.getString("serviteca.oracle.url");
            usuarioDb = rb.getString("serviteca.oracle.username");
            passwordDb = rb.getString("serviteca.oracle.password");
            driver = rb.getString("serviteca.oracle.driver");
            initialSize = rb.getString("serviteca.oracle.initialsize");
            maxActive = rb.getString("serviteca.oracle.maxactive");
            maxIdle = rb.getString("serviteca.oracle.maxidle");
            maxWait = rb.getString("serviteca.oracle.maxwait");
            validationQuery = rb.getString("serviteca.oracle.validationquery");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
            bds = new BasicDataSource();
            bds.setDriverClassName(driver);
            bds.setUrl(urlDb);
            bds.setUsername(usuarioDb);
            bds.setPassword(passwordDb);
            bds.setInitialSize(Integer.parseInt(initialSize));
            bds.setMaxActive(Integer.parseInt(maxActive));
            bds.setMaxIdle(Integer.parseInt(maxIdle));
            bds.setMaxWait(Integer.parseInt(maxWait));
            bds.setValidationQuery(validationQuery);
        }
        catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static Connection getConnection(){
        try{
            Connect();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
	}

    public synchronized static void returnConnection(Connection conn){
		if(conn==null){
			return;
		}
		try{
			conn.close();
		}
        catch(SQLException e){
            e.printStackTrace();
        }
	}

    private synchronized static void Connect()
    {
        try{
        	DBConnection.con = bds.getConnection();
        }
        catch (SQLException eSQL){
            eSQL.printStackTrace();
        }
     }
	
}