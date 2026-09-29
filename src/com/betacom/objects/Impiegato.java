package com.betacom.objects;

public class Impiegato extends User{
	
	private double salary;

	public Impiegato() {
		super();
	}

	public Impiegato(String nome, String cognome, Boolean sesso, double salary) {
		super(nome, cognome, sesso);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Impiegato [salary=" + salary + ", nome=" + getNome()
				+ ", cognome=" + getCognome() + ", sesso=" + getSesso() +
				"]";
	}

	
	
	

}
