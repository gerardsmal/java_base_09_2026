package com.betacom.process;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.utils.Utilities;

public class DateProcess implements GeneralInterface{
	private final static String PATTERN_DATE_ESTESO = "E d MMMM yyyy HH:mm:ss";
	
	@Override
	public void execute() throws Exception {
		System.out.println("Begin process DateProcess");
		
		LocalDateTime adesso = LocalDateTime.now();
		
		
		String r = String.format("Adesso siamo il %s", Utilities.dataToString(adesso));
		System.out.println(r);
		
		r = String.format("Adesso siamo il %s", Utilities.dataToString(PATTERN_DATE_ESTESO,  adesso));
		System.out.println(r);
		
		
	}

}
