package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Cargo;

public class CargoDAO<ListaCargos> {

	public void cadastrar(Cargo c) {
		
		Connection con = Conexao.recebeConexao();
		
		String sql = "INSERT INTO CARGO (CARGO, CARGA_HORARIA, SALARIO_BASE) VALUES (?, ?, ?)";
		//System.out.println(sql);
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, c.getCargo());
			preparador.setTime(2, c.getCarga_horaria());
			preparador.setDouble(3, c.getSalario_base());
						
			preparador.execute();
			preparador.close();
			
			System.out.println("Cargo cadastrado com sucesso.");
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar cargo.");
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Cargo> buscarTodos() {
		Connection con = Conexao.recebeConexao();
		
		String sql = "SELECT * FROM CARGO";
		
		ArrayList<Cargo> lista = new ArrayList<Cargo>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Cargo c = new Cargo();
				c.setId(resultado.getInt("ID"));
				c.setCargo(resultado.getString("CARGO"));
				c.setCarga_horaria(resultado.getTime("CARGA_HORARIA"));
				c.setSalario_base(resultado.getDouble("SALARIO_BASE"));
				lista.add(c);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar tabela Cargo no banco.");
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public int buscaPorDesc(String desc) {
		Connection con = Conexao.recebeConexao();
		
//		String sql = "SELECT * FROM CARGO WHERE CARGO LIKE %?%";
		String sql = "SELECT * FROM CARGO WHERE CARGO LIKE ?";
		
		Cargo c = null;
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, "%" + desc + "%");
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				c = new Cargo();
				c.setId(resultado.getInt("ID"));
				c.setCargo(resultado.getString("CARGO"));
				c.setCarga_horaria(resultado.getTime("CARGA_HORARIA"));
				c.setSalario_base(resultado.getDouble("SALARIO_BASE"));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar tabela Cargo no banco.");
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c.getId();
	}
	
}
