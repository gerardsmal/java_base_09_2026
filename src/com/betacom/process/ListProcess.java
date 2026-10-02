package com.betacom.process;

import java.util.ArrayList;
import java.util.List;

import com.betacom.enums.Reparto;
import com.betacom.exception.AcademyException;
import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.Impiegato;

public class ListProcess implements GeneralInterface{

	@Override
	public void execute() throws Exception {
		System.out.println("Begin ListProcess");
		
		List<Impiegato> lI = load();
		listImpiegati(lI, "Dopo creazione");
		
		Impiegato iCan = removeImpiegato(lI, 4); 
		listImpiegati(lI, "Dopo cancellazione");
		lI.add(iCan);
		listImpiegati(lI, "Dopo inserimento");
		removeImpiegato(lI, iCan);
	//	removeImpiegato(lI, iCan);  
		
		removeImpiegato(lI, "Leponte");  
		
		increaseSalary(lI, "IT", 1.5);
			
		listImpiegati(lI, "Dopo increaseSalary");
		
		
	}
	
	private List<Impiegato> load(){
		List<Impiegato> lI = new ArrayList<Impiegato>();
		lI.add(new Impiegato("Giancarlo", "Velluci", true, 1500, "IT"));
		lI.add(new Impiegato("Marco", "Verde", true, 1800, "IT"));
		lI.add(new Impiegato("Anna", "Bella", false, 1600, "IT"));
		lI.add(new Impiegato("Alice", "Fanticale", false, 1500, "IT"));
		lI.add(new Impiegato("Mirko", "Rosso", true, 1400, "PRODUZIONE"));
		lI.add(new Impiegato("Daniel", "Andreo", true, 1600, "LOGISTICA"));
		lI.add(new Impiegato("Angelina", "Perdua", false, 2000, "IT"));
		lI.add(new Impiegato("Eric", "Temio", true, 1900, "IT"));
		lI.add(new Impiegato("Maria", "Dualle", false, 1950, "IT"));
		lI.add(new Impiegato("Piero", "Leponte", true, 1300, "PRODUZIONE"));
		lI.add(new Impiegato("Cecillia", "Marcello", false, 1400, "IT"));
		lI.add(new Impiegato("Enrico", "Grazzo", true, 1700, "LOGISTICA"));
		
		return lI;
	}
	
	private void listImpiegati(List<Impiegato> lI, String titolo) {
		System.out.println("******************** " + titolo + "*************");
		int pos = 0;
		for (Impiegato it:lI) {
			System.out.println(pos + " - " + it);
			pos++;
		}		
	}
	
	private Impiegato removeImpiegato(List<Impiegato> lI, int pos) throws AcademyException{
		if (pos >= lI.size())
			throw new AcademyException("pos invalido  pos:" + pos + " max:" + lI.size());
		Impiegato r = lI.get(pos);
		lI.remove(pos);		
		return r;	
	}
	
	private void removeImpiegato(List<Impiegato> lI, Impiegato toRemove) throws AcademyException{
		if  (!lI.remove(toRemove))		
			throw new AcademyException("Impiegato non trovato");

	}

	private void removeImpiegato(List<Impiegato> lI, String cognome) throws AcademyException{
		for (Impiegato im:lI) {
			if (im.getCognome().equals(cognome)) {
				removeImpiegato(lI, im);
				break;
				
			}
		}
	
	}

	private void increaseSalary(List<Impiegato> lI, String reparto, double f) {
		for (Impiegato it:lI) {
			if (it.getReparto() == Reparto.valueOf(reparto))
				it.setSalary(it.getSalary() * f);
		}
	}

}
