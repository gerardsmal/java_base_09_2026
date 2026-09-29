package com.betacom.objects;

import com.betacom.interfaces.Animale;
import com.betacom.interfaces.Preda;

public class Gazella implements Animale, Preda{

	@Override
	public void sonoUnaPreda() {
		System.out.println("Sono una preda");
		
	}

	@Override
	public void sonoUnAnimale() {
		System.out.println("Sono una gazella");
		
	}

}
