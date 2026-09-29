package com.betacom.objects;

public class Fiat500 extends Car{

	@Override
	public void frena() {
		System.out.println("La Fiat 500 frena....");
	}

	@Override
	public void accelera() {
		System.out.println("La Fiat 500 accelera....");		
	}

}
