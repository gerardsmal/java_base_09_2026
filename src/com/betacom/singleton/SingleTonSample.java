package com.betacom.singleton;

public class SingleTonSample {
	
	private static SingleTonSample instance = null;

	private Integer idx = 0;
	
	private SingleTonSample() {
	}
	
	public static SingleTonSample getInstance() {
		if (instance == null) {
			instance = new SingleTonSample();
		}
		return instance;
	}
	
	public Integer computeInteger() {
		return ++idx;
	}

}
