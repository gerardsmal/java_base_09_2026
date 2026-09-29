package com.betacom.process;

import java.util.ArrayList;

import com.betacom.interfaces.Animale;
import com.betacom.interfaces.GeneralInterface;
import com.betacom.interfaces.Preda;
import com.betacom.interfaces.Predatore;
import com.betacom.objects.Gazella;
import com.betacom.objects.Leone;
import com.betacom.objects.Pesce;

public class InterfaceProcess implements GeneralInterface{
	
	@Override
	public void execute() {
		System.out.println("Begin InterfaceProcess");
		ArrayList<Animale> lA = new ArrayList<Animale>();
		lA.add(new Leone());
		lA.add(new Gazella());
		lA.add(new Pesce());
		
		for (Animale it:lA) {
			identification(it);
		}
	}
	
	private void identification(Animale o) {
		o.sonoUnAnimale();
		if (o instanceof Preda) {
			Preda obj = (Preda)o;
			obj.sonoUnaPreda();
		}
		if (o instanceof Predatore) {
			Predatore obj = (Predatore)o;
			obj.sonoUnPredatore();
		}

	}
}
