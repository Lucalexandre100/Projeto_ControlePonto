package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Funcionarios {

	private int id;
	private String nome;
	private String endereco;
	private String cep;
	private String cidade;
	private String telefone;
	private String celular;
	private int iduf;
	private int idcargo;
	
	public Funcionarios(String nm, String ender, String cep, String cid, String tel, String cel, int iduf, int idcargo) {
		this.nome = nm;
		this.endereco = ender;
		this.cep = cep;
		this.cidade = cid;
		this.telefone = tel;
		this.celular = cel;
		this.iduf = iduf;
		this.idcargo = idcargo;
	}
	
	public Funcionarios(int id, String nm, String ender, String cep, String cid, String tel, String cel, int iduf, int idcargo) {
		this.id = id;
		this.nome = nm;
		this.endereco = ender;
		this.cep = cep;
		this.cidade = cid;
		this.telefone = tel;
		this.celular = cel;
		this.iduf = iduf;
		this.idcargo = idcargo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public int getIduf() {
		return iduf;
	}
	public void setIduf(int iduf) {
		this.iduf = iduf;
	}
	public int getIdcargo() {
		return idcargo;
	}
	public void setIdcargo(int idcargo) {
		this.idcargo = idcargo;
	}
	
	public static void cadastrar (Funcionarios f) {
		Connection con = ConexaoBaseDados.recebeConexao();
		
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
			
			con.close();
			System.out.println("Funcionário cadastrado com sucesso.");
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar funcionário.");
			e.printStackTrace();
		}
		
	}
	
	public static List<Funcionarios> buscarTodos() {
		Connection con = ConexaoBaseDados.recebeConexao();
		
		String sql = "SELECT * FROM FUNCIONARIOS";
		
		ArrayList<Funcionarios> lista = new ArrayList<Funcionarios>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Funcionarios f = new Funcionarios(resultado.getInt("ID"), resultado.getString("NOME"), resultado.getString("ENDERECO"), resultado.getString("CEP"), resultado.getString("CIDADE"), resultado.getString("TELEFONE"), resultado.getString("CELULAR"), resultado.getInt("IDUF"), resultado.getInt("IDCARGO"));
				lista.add(f);
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao consultar tabela Funcionários no banco.");
			e.printStackTrace();
		}

		return lista;
	}
	
	public static int buscarIdFuncionario(String nome) {
		Connection con = ConexaoBaseDados.recebeConexao();
		String sql = "SELECT * FROM FUNCIONARIOS WHERE NOME = ?";
		
		int id=0;
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, nome);
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				Funcionarios func = new Funcionarios(resultado.getInt("ID"), resultado.getString("NOME"), resultado.getString("ENDERECO"), resultado.getString("CEP"), resultado.getString("CIDADE"), resultado.getString("TELEFONE"), resultado.getString("CELULAR"), resultado.getInt("IDUF"), resultado.getInt("IDCARGO"));
				id = func.getId();
			}
			
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao consultar tabela de Funcionários.");
			e.printStackTrace();
		}
		return id;
	}

}
