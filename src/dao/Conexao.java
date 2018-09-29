package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection recebeConexao() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CONTROLEPONTO?useSSL=false", "root", "");
			System.out.println("Conectado com sucesso. ");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Erro ao conectar no banco. ");
			e.printStackTrace();
		}
		return con;
	}
}
