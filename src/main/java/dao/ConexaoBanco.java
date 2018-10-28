package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	public static Connection conexao() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/todo?user=root&password=password";
			Connection conn = DriverManager.getConnection(url);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("Driver incorreto!");
		} catch (SQLException e) {
			System.out.println("Erro : " + e.getMessage());
		}
		return null;
	}
	
	/**
	 * Realiza uma conexão com o banco de dados MySQL.
	 */
}
