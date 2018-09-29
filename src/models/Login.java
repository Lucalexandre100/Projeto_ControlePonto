package models;

public class Login {

	private int id;
	private String username;
	private String pwd;
	private int tp_perfil;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getTp_perfil() {
		return tp_perfil;
	}
	public void setTp_perfil(int tp_perfil) {
		this.tp_perfil = tp_perfil;
	}
		
}
