package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UF {

	private int id;
	private String uf;
	private String nome_uf;
	
	public UF (int id, String uf, String desc) {
		this.id = id;
		this.uf = uf;
		this.nome_uf = desc;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getNome_uf() {
		return nome_uf;
	}
	public void setNome_uf(String nome_uf) {
		this.nome_uf = nome_uf;
	}
	
	public static List<UF> buscarEstados() {
		
		Connection con = ConexaoBaseDados.recebeConexao();
		
		String sql = "SELECT * FROM UF";
		
		ArrayList<UF> lista = new ArrayList<UF>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				UF u = new UF(resultado.getInt("ID"), resultado.getString("UF"), resultado.getString("NOME_UF"));
				lista.add(u);
			}
			con.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static int buscarPorSigla(String uf) {
		Connection con = ConexaoBaseDados.recebeConexao();
	
		String sql = "SELECT * FROM UF WHERE UF = ?";
	
		UF u = null;
	
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, uf);
		
			ResultSet resultado = preparador.executeQuery();
		
			if(resultado.next()) {
				u = new UF(resultado.getInt("ID"), resultado.getString("UF"), resultado.getString("NOME_UF"));
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao consultar tabela UF no banco.");
			e.printStackTrace();
		}
	
		return u.getId();
	}
	
}
