package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
		public Connection getConnection() {
			
			String connectionUrl = "jdbc:sqlserver://DESKTOP-D76RND4\\SQLEXPRES:1433;databaseName=BARBEARIA;user=sa;password=823345";
			
			try {
				 return DriverManager.getConnection(connectionUrl);
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}