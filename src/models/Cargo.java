package models;

import java.sql.Time;

public class Cargo {

	private int id;
	private String cargo;
	private double salario_base;
	private Time carga_horaria;
	
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
			
}
