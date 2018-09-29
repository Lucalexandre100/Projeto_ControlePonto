package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Cargo;
import models.Login;

public class LoginDAO {

	public boolean autenticar(Login lg) {
		Connection con = Conexao.recebeConexao();
		
		String user = lg.getUsername();
		String senha = lg.getPwd();
		boolean achou = false;
		
		String sql = "SELECT * FROM LOGIN WHERE USERNAME = ? AND PWD = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, user);
			preparador.setString(2, senha);
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				achou = true;
			}
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar tabela Login no banco.");
			e.printStackTrace();
		}
		return achou;
		
	}
	
	public void cadastrar(Login lg) {
		Connection con = Conexao.recebeConexao();
		
		String sql = "INSERT INTO LOGIN (USERNAME, PWD, TP_PERFIL) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, lg.getUsername());
			preparador.setString(2, lg.getPwd());
			preparador.setInt(3, 1);
			
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar novo login no banco.");
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
