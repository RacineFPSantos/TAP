package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {	
	EntityManagerFactory emf;
	EntityManager em;
	
	//JPA
	public EntityManager getConnection() {
		emf = Persistence.createEntityManagerFactory("aluno");
		em = emf.createEntityManager();
		
		return em;
	}

	//JDBC
		public static Connection getConnectionJDBC() {
		Properties properties = new Properties();
		
		try {
			ResourceBundle resources = ResourceBundle.getBundle("util.DatabaseProperties");
			for(@SuppressWarnings("rawtypes")
			Enumeration keys = resources.getKeys(); keys.hasMoreElements();) {
				final String key = ((String) keys.nextElement());
				final String value = resources.getString(key);
				properties.put(key,  value);
			}
			Class.forName(properties.getProperty("jdbcDriver")).newInstance();
			return (Connection) DriverManager.getConnection(properties.getProperty("url"));
		}catch(InstantiationException e) {
			e.printStackTrace();
		}catch(IllegalAccessException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;		
	}
}
