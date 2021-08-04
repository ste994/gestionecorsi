package com.torino.bc.model;

public class Amministratori {
	private long codAdmin;
	private String nomeAdmin;
	private String cognomeAdmin;
	private String password;
	public long getCodAdmin() {
		return codAdmin;
	}
	public void setCodAdmin(long codAdmin) {
		this.codAdmin = codAdmin;
	}
	public String getNomeAdmin() {
		return nomeAdmin;
	}
	public void setNomeAdmin(String nomeAdmin) {
		this.nomeAdmin = nomeAdmin;
	}
	public String getCognomeAdmin() {
		return cognomeAdmin;
	}
	public void setCognomeAdmin(String cognomeAdmin) {
		this.cognomeAdmin = cognomeAdmin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
