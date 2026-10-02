package com.betacom.process;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.singleton.SingleTonSample;

public class SingleTonProcess implements GeneralInterface{

	@Override
	public void execute() throws Exception {
		System.out.println("Begin SingleTonProcess");
		
		Integer i = SingleTonSample.getInstance().computeInteger();
		
		System.out.println("Valore di idx singleTon :" + i);
		
		new CallSingleTon().call();
		
		
	}

}
