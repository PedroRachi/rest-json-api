package org.java.rest.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	

	private static final ThreadLocal<Connection> conn = new ThreadLocal<Connection>();

	static {
		try {
	Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
		}
	}
	
	public Connection obtemConexao() throws SQLException {
		
		String serverName = "localhost"; // caminho do servidor do BD

		String mydatabase = "CentralOnline"; // nome do seu banco de dados

		String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

		String username = "root"; // nome de um usuário de seu BD

		String password = ""; // sua senha de acesso
		
		return DriverManager
					.getConnection(url, username, password);
	}
	
	public static void fecharConexao() throws SQLException {
		if(conn.get() != null){
			conn.get().close();
			conn.set(null);
		}
	}	
}