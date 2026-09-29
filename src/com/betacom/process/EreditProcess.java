package com.betacom.process;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.Impiegato;

public class EreditProcess implements GeneralInterface{

	@Override
	public void execute() {
		System.out.println("Begin Eredit");
		
		Impiegato imp = new Impiegato("Paolo", "Rossi", true, 1500);
		
		System.out.println(imp);
		
		imp = new Impiegato();
		imp.setNome("Alice");
		imp.setCognome("Verde");
		imp.setSalary(1800);
		imp.setSesso(false);
		
		System.out.println(imp);
		
	}

}
