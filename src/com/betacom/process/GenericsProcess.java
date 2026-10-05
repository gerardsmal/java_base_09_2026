package com.betacom.process;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.Impiegato;
import com.betacom.objects.RispostaGenerica;
import com.betacom.objects.User;

public class GenericsProcess implements GeneralInterface{
	private static final Logger log = LoggerFactory.getLogger(GenericsProcess.class);
	@Override
	public void execute() throws Exception {
		log.info("Begin GenericsProcess");
		
		List<Impiegato> lI = List.of(
				new Impiegato("Gaincarlo", "Moelinari", true, 1500, "IT"),
				new Impiegato("Marco", "Givi", true, 1600, "IT"),
				new Impiegato("Anna", "Lisa", false, 1700, "IT"),
				new Impiegato("Maria", "Grande", false, 1800, "IT"),
				new Impiegato("Luca", "Piccolo", true, 1900, "IT"),
				new Impiegato("Andrea", "Diparto", true, 2000, "IT"),
				new Impiegato("Alice", "Zuca", true, 2100, "IT"),
				new Impiegato("Daniela", "DeGarand", true, 1200, "IT"),
				new Impiegato("Angelina", "Marcese", true, 1300, "IT"),
				new Impiegato("Eric", "Undertre", true, 1400, "IT"),
				new Impiegato("Piero", "Denico", true, 1550, "IT"),
				new Impiegato("Cecilia", "Marcello", true, 1570, "IT")			
				);
		
		RispostaGenerica<Impiegato, Integer> r = new RispostaGenerica<Impiegato, Integer>();
		r.setRc(true);
		r.setOther(lI.size());
		r.setData(lI);
		
		log.debug(r.toString());
		
		
		
		List<User> lU = List.of(
				new User("Pippo", "Verde", true),
				new User("Anna", "Blue", false),
				new User("Gianni", "Laverdura", true),
				new User("Maria", "Lagrande", false)
				);
		
		RispostaGenerica<User, String> r1 = new RispostaGenerica<User, String>();
		r1.setRc(true);
		r1.setOther("Questa é una string");
		r1.setData(lU);
		
		log.debug(r1.toString());
		
		
	}

}
