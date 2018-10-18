package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

	private int id;
	private String username;
	private String pwd;
	private int tp_perfil;
	
	public Login (String user, String pwd, int perfil) {
		this.username = user;
		this.pwd = pwd;
		this.tp_perfil = perfil;
	}
	
	public Login (String user, String pwd) {
		this.username = user;
		this.pwd = pwd;
	}
	
	public Login (int id, String user, String pwd, int perfil) {
		this.id = id;
		this.username = user;
		this.pwd = pwd;
		this.tp_perfil = perfil;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getTp_perfil() {
		return tp_perfil;
	}
	public void setTp_perfil(int tp_perfil) {
		this.tp_perfil = tp_perfil;
	}
	
	public static boolean autenticar(Login lg) {
		Connection con = ConexaoBaseDados.recebeConexao();
		
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
			
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao consultar tabela Login no banco.");
			e.printStackTrace();
		}
		
		return achou;
	}
	
	public static void cadastrar(Login lg) {
		Connection con = ConexaoBaseDados.recebeConexao();
		
		String sql = "INSERT INTO LOGIN (USERNAME, PWD, TP_PERFIL) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, lg.getUsername());
			preparador.setString(2, lg.getPwd());
			preparador.setInt(3, 1);
			
			preparador.execute();
			preparador.close();
			
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar novo login no banco.");
			e.printStackTrace();
		}

	}
}
