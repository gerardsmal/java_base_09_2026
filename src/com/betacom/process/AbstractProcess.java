package com.betacom.process;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.Bmv;
import com.betacom.objects.Fiat500;

public class AbstractProcess implements GeneralInterface{
	
	@Override
	public void execute() {
		System.out.println("Begin AbstractProcess");
		
		Fiat500 fiat = new Fiat500();
		fiat.setColor("Nero");
		fiat.setMaxSpeed(130);
		fiat.setModel("Fiat 500");
		
		fiat.accelera();
		fiat.frena();
		
		System.out.println("Model:" + fiat.getModel() + " color:" + fiat.getColor() + " maxSpeed:" + fiat.getMaxSpeed());
		
		Bmv bmw = new Bmv();
		bmw.setColor("Bianca");
		bmw.setMaxSpeed(250);
		bmw.setModel("M3");
		
		bmw.accelera();
		bmw.frena();

		System.out.println("Model:" + bmw.getModel() + " color:" + bmw.getColor() + " maxSpeed:" + bmw.getMaxSpeed());
		
	}
}
