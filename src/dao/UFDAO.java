package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.UF;

public class UFDAO {

	public List<UF> buscarEstados() {
		
		Connection con = Conexao.recebeConexao();
		
		String sql = "SELECT * FROM UF";
		
		ArrayList<UF> lista = new ArrayList<UF>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				UF u = new UF();
				u.setId(resultado.getInt("ID"));
				u.setUf(resultado.getString("UF"));
				u.setNome_uf(resultado.getString("NOME_UF"));
				lista.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public int buscarPorSigla(String uf) {
		Connection con = Conexao.recebeConexao();
		
		String sql = "SELECT * FROM UF WHERE UF = ?";
		
		UF u = null;
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, uf);
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				u = new UF();
				u.setId(resultado.getInt("ID"));
				u.setUf(resultado.getString("UF"));
				u.setNome_uf(resultado.getString("NOME_UF"));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar tabela UF no banco.");
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u.getId();
	}
	
}
