package com.betacom.process;

import java.time.LocalDate;
import java.util.Optional;

import com.betacom.exception.AcademyException;
import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionalProcess implements GeneralInterface{

	@Override
	public void execute() throws Exception {
		log.info("Begin OptionalProcess");
		
		String test = "pippo";
		
		Optional<String> vuoto = Optional.empty();   // optional vuoto
		Optional<String> name  = Optional.of(test);  // caricare un valore diverse da vuoto
		
		String valore = "Mario";
		Optional<String> opt = Optional.ofNullable(valore);
		
		if (opt.isEmpty())
			log.debug("opt non caricato");
		
		if (opt.isPresent())
			log.debug("travato valore {}", opt.get());
		
		opt.ifPresent(n -> log.debug("valore trovata {}", n));
		
		Optional<String> def = Optional.of("Pippo");
		// def = Optional.empty();
		
		String risultato = def.orElse("default");
		
		log.debug("Risultato {}", risultato);
		
		
		Optional<User> usr = loadUser(true);
		if (usr.isEmpty())
			log.error("usr non trovato");
		usr.get().setCertificatoMedico(LocalDate.now());
		log.debug("User {}", usr.get());
		
		/*
		 * metodo moderno
		 */
		User u = loadUser(false)
				.orElseThrow(() -> new AcademyException("User non trovato"));
		u.setCertificatoMedico(LocalDate.now());
		log.debug("User {}", u);
		
	}

	
	private Optional<User> loadUser(boolean load){
		User r = null;
		
		if (load) {
			r = new User("Pippo","Pluto", true);
		}
		Optional<User> usr = Optional.ofNullable(r);
		
		return usr;
	}
	
}
