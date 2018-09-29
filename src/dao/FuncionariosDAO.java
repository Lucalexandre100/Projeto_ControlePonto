package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Cargo;
import models.Funcionarios;

public class FuncionariosDAO {

	public void cadastrar (Funcionarios f) {
		Connection con = Conexao.recebeConexao();
		
		String sql = "INSERT INTO FUNCIONARIOS (NOME, ENDERECO, CEP, CIDADE, TELEFONE, CELULAR, IDUF, IDCARGO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		//System.out.println(sql);
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, f.getNome());
			preparador.setString(2, f.getEndereco());
			preparador.setString(3, f.getCep());
			preparador.setString(4, f.getCidade());			
			preparador.setString(5, f.getTelefone());
			preparador.setString(6, f.getCelular());
			preparador.setInt(7, f.getIduf());
			preparador.setInt(8, f.getIdcargo());
			preparador.execute();
			preparador.close();
			
			System.out.println("Funcionário cadastrado com sucesso.");
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar funcionário.");
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Funcionarios> buscarTodos() {
		Connection con = Conexao.recebeConexao();
		
		String sql = "SELECT * FROM FUNCIONARIOS";
		
		ArrayList<Funcionarios> lista = new ArrayList<Funcionarios>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Funcionarios f = new Funcionarios();
				f.setId(resultado.getInt("ID"));
				f.setNome(resultado.getString("NOME"));
				f.setEndereco(resultado.getString("ENDERECO"));
				f.setCidade(resultado.getString("CEP"));
				f.setTelefone(resultado.getString("TELEFONE"));
				f.setCelular(resultado.getString("CELULAR"));
				f.setIduf(resultado.getInt("IDUF"));
				f.setIdcargo(resultado.getInt("IDCARGO"));
				lista.add(f);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar tabela Funcionários no banco.");
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
