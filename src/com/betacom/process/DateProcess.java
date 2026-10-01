package com.betacom.process;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.User;
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
		
		LocalDate birthday = Utilities.stringToDate("10/05/1981");
		System.out.println(birthday);
		
		User usr = new User("Isabelle", "Labelle", false, birthday);
		System.out.println(usr);
		
		
		usr = new User("Luca", "Ilgrande", true, 2000, 05, 25);
		System.out.println("Data nascita trovata :" + Utilities.dataToString(usr.getDataNascita()));
		
		int plusGiorni = 15;
		usr.setDataNascita(usr.getDataNascita().plusDays(plusGiorni));
		
		usr.setCertificatoMedico(LocalDate.of(2026, 01, 01));
		
		System.out.println("Data  modificata :" + usr);
		
		int monthValidity = 6;
		LocalDate endDate = usr.getCertificatoMedico().plusMonths(monthValidity);
		
		if (LocalDate.now().isAfter(endDate)) {
			System.out.println("Certificato medico scaduto. Data fine validita :" + Utilities.dataToString(endDate));
		} else {
			System.out.println("Certificato medico valido fino il " + Utilities.dataToString(endDate));
		}
		
		
		
	}

}
