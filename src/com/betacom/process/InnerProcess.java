package com.betacom.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.Inner;

public class InnerProcess implements GeneralInterface{
	private static final Logger log = LoggerFactory.getLogger(InnerProcess.class);
	@Override
	public void execute() throws Exception {
		log.info("Begin InnerProcess");
		
		Inner inner = new Inner();
		inner.setFatherClass("Siamo nella class padre");
		inner.setNumero(3);
		
		log.debug("Class innter: {} numero: {}", inner.getFatherClass(), inner.getNumero());
		
		Inner.Figlio figlio = inner.setInstanceOfFiglio();
		figlio.setFilgioClass("Sono nella class figlio");
		figlio.setNumero2(22);
		
		log.debug("Valore del figlio {}", figlio.displayNumber());
		
		Inner.Figlio.Nipote nipote = figlio.setInstanceOfNipote();
		nipote.setNipoteClass("Sono nella class nipote");
		nipote.setNumero3(99);
		nipote.setFatherClass("Questa é una prova");
		
		log.debug("Valore del nipote {}", nipote.displayNumber());
		log.debug("Class innter modificata: {} numero: {}", inner.getFatherClass(), inner.getNumero());
		
	}

}
