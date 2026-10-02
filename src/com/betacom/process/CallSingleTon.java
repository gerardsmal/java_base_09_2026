package com.betacom.process;

import com.betacom.singleton.SingleTonSample;

public class CallSingleTon {
	
	public void call() {
		Integer i = SingleTonSample.getInstance().computeInteger();
		System.out.println("Valore di idx chiamato da callSingleton:" + i);
	}

}
