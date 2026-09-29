package com.betacom.process;

import com.betacom.exception.AcademyException;
import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.User;

public class ExceptionProcess implements GeneralInterface{

	@Override
	public void execute() throws Exception {
		System.out.println("Begin ExceptionProcess");
		try {
			int o1 = 10;
			int o2 = 0;
			int res = o1/o2;
		} catch (Exception e) {
			System.err.println("Error found :" + e.getMessage());
		}

		User us = new User();
//		us.setCognome("Rossi");
		us.setNome("Paolo");
//		us.setSesso(true);
		controlUser(us);
		System.out.println("Valore di user:" + us);
	}
	
	private void controlUser(User usr) throws AcademyException {
		if (usr.getNome() == null){
			throw new AcademyException("Nome non caricato");
		}
		if (usr.getCognome() == null){
			throw new AcademyException("Cognome non caricato");
		}
		if (usr.getSesso() == null) {
			System.out.println("sesso is setted to true");
			usr.setSesso(true);
		}

	}

}
