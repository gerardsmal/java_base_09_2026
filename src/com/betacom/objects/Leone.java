package com.betacom.objects;

import com.betacom.interfaces.Animale;
import com.betacom.interfaces.Predatore;

public class Leone implements Animale, Predatore{

	@Override
	public void sonoUnPredatore() {
		System.out.println("Sono un predatore");
		
	}

	@Override
	public void sonoUnAnimale() {
		System.out.println("Sono un Leone");
		
	}
	
}
