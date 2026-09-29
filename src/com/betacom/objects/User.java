package com.betacom.objects;

public class User {
	
	private String nome;
	private String cognome;
	private Boolean sesso;   // true M false F
	

	public User() {
		super();
	}
	
	public User(String nome, String cognome, Boolean sesso) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
	}


	@Override
	public String toString() {
		return "User [nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + "]";
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public Boolean getSesso() {
		return sesso;
	}


	public void setSesso(Boolean sesso) {
		this.sesso = sesso;
	}


	
	
	
}
