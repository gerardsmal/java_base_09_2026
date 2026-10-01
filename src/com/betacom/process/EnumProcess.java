package com.betacom.process;

import java.util.ArrayList;

import com.betacom.enums.Reparto;
import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.Impiegato;

public class EnumProcess implements GeneralInterface{

	@Override
	public void execute() throws Exception {
		System.out.println("Begin EnumProcess");
		
		ArrayList<Impiegato> lI = new ArrayList<Impiegato>();
		lI.add(new Impiegato("Giancarlo", "Belloni", true , 1500, "IT"));
		lI.add(new Impiegato("Anna", "Bella", false , 1600, "LOGISTICA"));
		lI.add(new Impiegato("Gianni", "Rosso", true , 1600, "IT"));
		lI.add(new Impiegato("Beatrice", "Verde", false , 1550, "IT"));
		lI.add(new Impiegato("Marco", "Giallo", true , 1300, "PRODUZIONE"));
		lI.add(new Impiegato("Maria", "Bianca", false , 1800, "IT"));
		lI.add(new Impiegato("Daniele", "Nero", true , 1900, "IT"));
		lI.add(new Impiegato("Angelina", "Marrone", false , 1500, "SVILUPPO"));	
		lI.add(new Impiegato("Mirko", "Giallo", false , 1500));	
		
		
		String selected = "IT";
		for (Impiegato im:lI) {
			if (im.getReparto() == Reparto.valueOf(selected))
					System.out.println(im);
		}
	}

}
