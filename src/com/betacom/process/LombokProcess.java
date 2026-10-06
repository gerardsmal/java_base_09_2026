package com.betacom.process;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.ObjectLombok;
import com.betacom.objects.ObjectLombokChild;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LombokProcess implements GeneralInterface{

	@Override
	public void execute() throws Exception {
		log.info("Begin LombokProcess");
		
		ObjectLombok o = new ObjectLombok();
		o.setCognome("cognome");
		o.setNome("nome");
		o.setIndirizzo("aaaaa");
		o.setSesso(true);
		
		log.debug(o.toString());
		
		ObjectLombok o1 = new ObjectLombok("aaa", "bbb", "ccc", true);
		
		log.debug(o1.toString());
		
		o1 = ObjectLombok.builder()
				.cognome("cccc")
				.nome("nnn")
				.indirizzo("iiiii")
				.sesso(false)
				.build();

		log.debug(o1.toString());

		ObjectLombokChild c = ObjectLombokChild.builder()
				.nome("nome padre")
				.cognome("cogome padre")
				.sesso(true)
				.citta("Roma")
				.via("via")
				.build();
		
		log.debug(c.toString());
	}

}
