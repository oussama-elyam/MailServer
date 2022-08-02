package com.mailsign.dao.imp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mail.config.AppConf;


public class Singleton {
	private static Singleton uniqueInstance;
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://"+AppConf.DB_HOST+":3306/"+AppConf.DB_NAME
                    ,AppConf.DB_USERNAME
                    ,AppConf.DB_PASSWORD);
			
		}
		catch(ClassNotFoundException ex) {
			System.out.println("Erreur de pilote : " + ex.getMessage());
		}
		catch(SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return conn;
	}
}
