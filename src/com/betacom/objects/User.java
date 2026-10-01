package com.betacom.objects;

import java.time.LocalDate;

public class User {
	
	private String nome;
	private String cognome;
	private Boolean sesso;   // true M false F
	private LocalDate dataNascita;
	private LocalDate certificatoMedico;
	

	public User() {
		super();
	}
	
	public User(String nome, String cognome, Boolean sesso) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
	}

	public User(String nome, String cognome, Boolean sesso, LocalDate dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.dataNascita = dataNascita;
	}

	public User(String nome, String cognome, Boolean sesso, int anno, int mese, int giorno) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.dataNascita = LocalDate.of(anno, mese, giorno);
	}

	public User(String nome, String cognome, Boolean sesso, LocalDate dataNascita, LocalDate certificatoMedico) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.dataNascita = dataNascita;
		this.certificatoMedico = certificatoMedico;
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

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "User [nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + ", dataNascita=" + dataNascita
				+ ", certificatoMedico=" + certificatoMedico + "]";
	}

	public LocalDate getCertificatoMedico() {
		return certificatoMedico;
	}

	public void setCertificatoMedico(LocalDate certificatoMedico) {
		this.certificatoMedico = certificatoMedico;
	}


	
	
	
}
