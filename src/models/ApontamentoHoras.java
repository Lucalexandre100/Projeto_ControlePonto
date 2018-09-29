package models;

public class ApontamentoHoras {

	private int id;
	private String dataCad;
	private String hrEntrada;
	private String hrSaidaAlmoco;
	private String hrVoltaAlmoco;
	private String hrSaida;
	private int idFunc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDataCad() {
		return dataCad;
	}
	public void setDataCad(String dataCad) {
		this.dataCad = dataCad;
	}
	public String getHrEntrada() {
		return hrEntrada;
	}
	public void setHrEntrada(String hrEntrada) {
		this.hrEntrada = hrEntrada;
	}
	public String getHrSaidaAlmoco() {
		return hrSaidaAlmoco;
	}
	public void setHrSaidaAlmoco(String hrSaidaAlmoco) {
		this.hrSaidaAlmoco = hrSaidaAlmoco;
	}
	public String getHrVoltaAlmoco() {
		return hrVoltaAlmoco;
	}
	public void setHrVoltaAlmoco(String hrVoltaAlmoco) {
		this.hrVoltaAlmoco = hrVoltaAlmoco;
	}
	public String getHrSaida() {
		return hrSaida;
	}
	public void setHrSaida(String hrSaida) {
		this.hrSaida = hrSaida;
	}
	public int getIdFunc() {
		return idFunc;
	}
	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}
	
}
