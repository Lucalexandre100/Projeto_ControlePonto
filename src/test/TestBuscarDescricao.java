package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Conexao;
import models.Cargo;

public class TestBuscarDescricao {

	public static void main(String[] args) {
		Connection con = Conexao.recebeConexao();

		String desc = "Analista de Testes";

		String sql = "SELECT * FROM CARGO WHERE CARGO LIKE ?";

		Cargo c = null;

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, "%"+desc+"%");

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				c = new Cargo();
				c.setId(resultado.getInt("ID"));
				c.setCargo(resultado.getString("CARGO"));
				c.setCarga_horaria(resultado.getTime("CARGA_HORARIA"));
				c.setSalario_base(resultado.getDouble("SALARIO_BASE"));
			} else if (!resultado.next() && resultado.isFirst()) {
				System.out.println("Nenhum resultado encontrado");

			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar tabela Cargo no banco.");
			e.printStackTrace();
		}

	}

}
