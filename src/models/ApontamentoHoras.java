package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ApontamentoHoras {

	private int id;
	private Date dataCad;
	private Time hrEntrada;
	private Time hrSaidaAlmoco;
	private Time hrVoltaAlmoco;
	private Time hrSaida;
	private int idFunc;
	
	public ApontamentoHoras (Date date, Time hrEnt, Time hrSdAl, Time hrVtAl, Time hrSd, int idF) {
		this.dataCad = date;
		this.hrEntrada = hrEnt;
		this.hrSaidaAlmoco = hrSdAl;
		this.hrVoltaAlmoco = hrVtAl;
		this.hrSaida = hrSd;
		this.idFunc = idF;
	}
	
	public ApontamentoHoras (int id, Date dtCad, Time hrEnt, Time hrSdAl, Time hrVtAl, Time hrSd, int idF) {
		this.id = id;
		this.dataCad = dtCad;
		this.hrEntrada = hrEnt;
		this.hrSaidaAlmoco = hrSdAl;
		this.hrVoltaAlmoco = hrVtAl;
		this.hrSaida = hrSd;
		this.idFunc = idF;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataCad() {
		return dataCad;
	}
	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}
	public Time getHrEntrada() {
		return hrEntrada;
	}
	public void setHrEntrada(Time hrEntrada) {
		this.hrEntrada = hrEntrada;
	}
	public Time getHrSaidaAlmoco() {
		return hrSaidaAlmoco;
	}
	public void setHrSaidaAlmoco(Time hrSaidaAlmoco) {
		this.hrSaidaAlmoco = hrSaidaAlmoco;
	}
	public Time getHrVoltaAlmoco() {
		return hrVoltaAlmoco;
	}
	public void setHrVoltaAlmoco(Time hrVoltaAlmoco) {
		this.hrVoltaAlmoco = hrVoltaAlmoco;
	}
	public Time getHrSaida() {
		return hrSaida;
	}
	public void setHrSaida(Time hrSaida) {
		this.hrSaida = hrSaida;
	}
	public int getIdFunc() {
		return idFunc;
	}
	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}
	
	public static void cadastrar (ApontamentoHoras aph) {
		Connection con = ConexaoBaseDados.recebeConexao();
		String sql = "INSERT INTO APONTAMENTO_HORAS (DATACAD, HRENTRADA, HRSAIDAALMOCO, HRVOLTAALMOCO, HRSAIDA, IDFUNC) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setDate(1, aph.getDataCad());
			preparador.setTime(2, aph.getHrEntrada());
			preparador.setTime(3, aph.getHrSaidaAlmoco());
			preparador.setTime(4, aph.getHrVoltaAlmoco());
			preparador.setTime(5, aph.getHrSaida());
			preparador.setInt(6, aph.getIdFunc());
			
			preparador.executeUpdate();
			con.close();
			System.out.println("Apontamento cadastrado.");
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar apontamento de horas.");
			e.printStackTrace();
		}
	}
	
	public static List<ApontamentoHoras> buscarTodos() {
		Connection con = ConexaoBaseDados.recebeConexao();
		String sql = "SELECT * FROM APONTAMENTO_HORAS";
		ArrayList <ApontamentoHoras> lista = new ArrayList<ApontamentoHoras>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			while(resultado.next()) {
				ApontamentoHoras aph = new ApontamentoHoras(resultado.getInt("ID"), new Date(resultado.getDate("DATACAD").getTime()), resultado.getTime("HRENTRADA"), resultado.getTime("HRSAIDAALMOCO"), resultado.getTime("HRVOLTAALMOCO"), resultado.getTime("HRSAIDA"), resultado.getInt("IDFUNC"));
				lista.add(aph);
			}
			
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao consultar tabela Apontamento_Horas.");
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
