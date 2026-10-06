package com.betacom.process;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.Negozio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuilderProcess implements GeneralInterface{
	@Override
	public void execute() throws Exception {
		log.info("Begin BuilderProcess");
		
		Negozio n = Negozio.builder()
				.codice(23)
				.proprietario("Informatica Srl")
				.indirizzo("Via Piave 23, Torino")
				.isCenterCommerciale(true)
				.build();
				
		
		log.debug(n.toString());
	}

}
