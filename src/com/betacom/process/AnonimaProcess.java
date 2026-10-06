package com.betacom.process;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.betacom.interfaces.Azione;
import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.Impiegato;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnonimaProcess implements GeneralInterface{

	@Override
	public void execute() throws Exception {
		log.debug("Begin AnonimaProcess");
		
		/*
		 * versione senza lambda
		 */
		Azione a = new Azione() {
			
			@Override
			public void esegui(String param) {
				log.debug("Azione eseguita con il paramerto :{}", param);
				
			}
		};
		
		a.esegui("mio parametro");
		
		/*
		 * transformazione in lambda
		 */
		Azione l = (param) -> {
			log.debug("Azione eseguita con il paramerto :{}", param);
			System.out.println("System.out dentro il metodo");
		};
		l.esegui("second parametro");
		
		l = (param) -> metodo(param);
		
		l.esegui("terso parametro");
		/*
		 * esempio di sort senza lambda
		 */
		
		List<Impiegato> lI = Stream.of(
				new Impiegato("Andrea", "Verde", true, 1500, "IT"),
				new Impiegato("Pietro", "Giallo", true, 1300, "IT"),
				new Impiegato("Anna", "Nero", false, 1600, "IT"),
				new Impiegato("Giuseppe", "Rossi", true, 2000, "IT"),
				new Impiegato("Alice", "Dibello", false, 2500, "PRODUZIONE"),
				new Impiegato("Cecillia", "Grande", false, 1300, "IT"),
				new Impiegato("Eric", "Piccolo", true, 1800, "LOGISTICA"),
				new Impiegato("Paolo", "Bluetto", true, 1900, "IT"),
				new Impiegato("Ugo", "noede", true, 1200, "IT")				
				).collect(Collectors.toList());
		
		lI.sort(new Comparator<Impiegato>() {

			@Override
			public int compare(Impiegato o1, Impiegato o2) {
				return Double.compare(o1.getSalary(), o2.getSalary());
			}
		});
		
		lI.forEach(im -> log.debug(im.toString()));

		/*
		 * sort con lambda
		 */
		lI.sort(( o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
		log.debug("Sort con lambda ********");
		lI.forEach(im -> log.debug(im.toString()));
		
	}
	
	private void metodo(String param) {
		log.debug("Azione eseguita con il paramerto :{}", param);
		System.out.println("System.out dentro il metodo");
		
	}
	

}
