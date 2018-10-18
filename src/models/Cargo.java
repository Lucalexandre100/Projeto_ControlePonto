package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Cargo {

	private int id;
	private String cargo;
	private double salario_base;
	private Time carga_horaria;
	
	public Cargo (String cargo, double salario, String ch) {
		this.cargo = cargo;
		this.salario_base = salario;
		this.carga_horaria = ValidacaoDataHora.retornaHora(ch);
	}
	
	public Cargo (int id, String cargo, double salario, Time ch) {
		this.id = id;
		this.cargo = cargo;
		this.salario_base = salario;
		this.carga_horaria = ch;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public double getSalario_base() {
		return salario_base;
	}
	public void setSalario_base(double salario_base) {
		this.salario_base = salario_base;
	}
	public Time getCarga_horaria() {
		return carga_horaria;
	}
	public void setCarga_horaria(Time carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	
	public static void cadastrar(Cargo c) {
		
		Connection con = ConexaoBaseDados.recebeConexao();
		
		String sql = "INSERT INTO CARGO (CARGO, CARGA_HORARIA, SALARIO_BASE) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, c.getCargo());
			preparador.setTime(2, c.getCarga_horaria());
			preparador.setDouble(3, c.getSalario_base());
						
			preparador.execute();
			preparador.close();
			
			con.close();
			System.out.println("Cargo cadastrado com sucesso.");
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar cargo.");
			e.printStackTrace();
		}
			
	}
	
	public static List<Cargo> buscarTodos() {
		Connection con = ConexaoBaseDados.recebeConexao();
		
		String sql = "SELECT * FROM CARGO";
		
		ArrayList<Cargo> lista = new ArrayList<Cargo>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Cargo c = new Cargo(resultado.getInt("ID"), resultado.getString("CARGO"), resultado.getDouble("SALARIO_BASE"), resultado.getTime("CARGA_HORARIA"));
				lista.add(c);
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao consultar tabela Cargo no banco.");
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public static int buscaPorDesc(String desc) {
		Connection con = ConexaoBaseDados.recebeConexao();
		
		String sql = "SELECT * FROM CARGO WHERE CARGO LIKE ?";
		
		Cargo c = null;
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, "%" + desc + "%");
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				c = new Cargo(resultado.getInt("ID"), resultado.getString("CARGO"), resultado.getDouble("SALARIO_BASE"), resultado.getTime("CARGA_HORARIA"));
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao consultar tabela Cargo no banco.");
			e.printStackTrace();
		}
		
		return c.getId();
	}
			
}
