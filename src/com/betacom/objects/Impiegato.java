package com.betacom.objects;

import com.betacom.enums.Reparto;

public class Impiegato extends User{
	
	private double salary;
	private Reparto reparto;

	public Impiegato() {
		super();
	}

	public Impiegato(String nome, String cognome, Boolean sesso, double salary) {
		super(nome, cognome, sesso);
		this.salary = salary;
	}

	public Impiegato(String nome, String cognome, Boolean sesso, double salary, String reparto) {
		super(nome, cognome, sesso);
		this.salary = salary;
		try {
			this.reparto = Reparto.valueOf(reparto);			
		} catch (Exception e) {
			System.out.println("reparto setted to unknow :" + reparto);
			this.reparto = Reparto.valueOf("UNKOWN");
		}
	}

	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Reparto getReparto() {
		return reparto;
	}

	public void setReparto(Reparto reparto) {
		this.reparto = reparto;
	}

	@Override
	public String toString() {
		String r = "Impiegato [salary=" + salary + ", nome=" + getNome()
				+ ", cognome=" + getCognome() + ", sesso=" + getSesso();
				if (reparto != null) {
					r = r + ", reparto=" + getReparto().toString();
				}
				r = r+ "]";
		return r;
	}
	
	
	

}
